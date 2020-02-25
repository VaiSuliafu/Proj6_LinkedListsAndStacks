package assign06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author Erin Parker, Vai Suliafu, and Michael Eyer
 * @version ??
 */
public class BalancedSymbolChecker {

	/**
	 * Generates a message indicating whether the input file has unmatched
	 * symbols. (Use the helper methods below for constructing messages.)
	 * 
	 * @param filename - name of the input file to check
	 * @return a message indicating whether the input file has unmatched symbols
	 * @throws FileNotFoundException if the file does not exist
	 */
	public static String checkFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		
		if (!file.exists())
		{
			throw new FileNotFoundException();
		}
		Scanner scr = new Scanner(file);
//		Scanner scr = new Scanner(new FileReader(file));
		LinkedListStack<Character> stack = new LinkedListStack<Character>();

		int lineNum = 0;
		char [] charArr;
		char currentCheckSymbol;
		boolean inBlockComment = false;
		
		// while the scanner has a next line
		while(scr.hasNextLine())
		{
			// read the next line into an array of chars
			charArr = scr.nextLine().toCharArray();
			
			// loop through the array of chars (each line)
			int i = 0;
			while (i < charArr.length)
			{
				// if there is a line comment, we can stop looping through this line immediately
				if (i != charArr.length - 1 && charArr[i] == '/' && charArr[i+1] == '/')
				{
					// breaking out for loop
					break;
				}
				
				// if not currently in a comment
				while(!inBlockComment && i < charArr.length)
				{
					// check if the next two characters in char array begin a comment
					if (i != charArr.length - 1 && charArr[i] == '/' && charArr[i+1] == '*')
					{
						inBlockComment = true;
						break;
					}
					
					// if a specific char is observed, push it on the stack
					if (charArr[i] == '(' || charArr[i] == '{' || charArr[i] == '[')
					{
						
						stack.push(charArr[i]);
					}
					
					// if a specific char is observed, check if top char on stack is the matches observed char
					if (charArr[i] == ')' || charArr[i] == '}' || charArr[i] == ']')
					{
						currentCheckSymbol = stack.pop();
						
						// if symbols do not match print the error message
						if (!checkMatchingSymbols(charArr[i], currentCheckSymbol))
						{
							return unmatchedSymbol(lineNum+1, i+1, charArr[i], getMatchingSymbol(currentCheckSymbol));
						}
					}
					
					// increment i
					i++;
				}
				
				// this block of code runs only runs if we entered a comment earlier at line 53
				while(inBlockComment && i < charArr.length)
				{
					
					// check if this comment ends
					if (i != charArr.length - 1 && charArr[i] == '*' && charArr[i+1] == '/')
					{
						inBlockComment = false;
						break;
					}
					
					// increment i so the next char is checked
					i++;
				}

			}
			lineNum++;
		}
		
		// print out the message if we ended in block comment
		if (inBlockComment)
		{
			return unfinishedComment();
		}
		
		// print out the message if stack was not empty at end
		if (!stack.isEmpty())
		{
			return unmatchedSymbolAtEOF(stack.pop());
		}
		
		return allSymbolsMatch();
	}

	
	private static boolean checkMatchingSymbols (char c1, char c2)
	{
		if (c1 == ')' && c2 == '(')
			return true;
		else if (c1 == ']' && c2 == '[')
			return true;
		else if (c1 == '}' && c2 == '{')
			return true;
		else
			return false;
	}
	
	private static char getMatchingSymbol (char c)
	{
		if (c == '(')
			return ')';
		else if (c == '{')
			return '}';
		else if (c == '[')
			return ']';
		else
			return '/';
	}

	/**
	 * Use this error message in the case of an unmatched symbol.
	 * 
	 * @param lineNumber - the line number of the input file where the matching symbol was expected
	 * @param colNumber - the column number of the input file where the matching symbol was expected
	 * @param symbolRead - the symbol read that did not match
	 * @param symbolExpected - the matching symbol expected
	 * @return the error message
	 */
	private static String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected " + symbolExpected
				+ ", but read " + symbolRead + " instead.";
	}

	/**
	 * Use this error message in the case of an unmatched symbol at the end of the file.
	 * 
	 * @param symbolExpected - the matching symbol expected
	 * @return the error message
	 */
	private static String unmatchedSymbolAtEOF(char symbolExpected) {
		return "ERROR: Unmatched symbol at the end of file. Expected " + getMatchingSymbol(symbolExpected) + ".";
	}

	/**
	 * Use this error message in the case of an unfinished comment
	 * (i.e., a file that ends with an open /* comment).
	 * 
	 * @return the error message
	 */
	private static String unfinishedComment() {
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Use this message when no unmatched symbol errors are found in the entire file.
	 * 
	 * @return the success message
	 */
	private static String allSymbolsMatch() {
		return "No errors found. All symbols match.";
	}
}