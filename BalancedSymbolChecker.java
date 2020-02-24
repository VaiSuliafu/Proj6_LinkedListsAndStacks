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
 * @author Erin Parker && ??
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
		Scanner scr = new Scanner(new FileReader(file));
		String mainString = "";
		
		LinkedListStack<Character> stack = new LinkedListStack<Character>();

		int lineNum = 0;
		char [] charArr;
		char currentCheckSymbol;
		boolean inComment = false;
		while (scr.hasNextLine())
		{
			charArr = scr.nextLine().toCharArray();
			for (int i = 0; i < charArr.length; i++)
			{
				if (charArr[i] == '(' || charArr[i] == '{' || charArr[i] == '[')
				{
					stack.push(charArr[i]);
				}
				if (charArr[i] == ')' || charArr[i] == '}' || charArr[i] == ']')
				{
					currentCheckSymbol = stack.pop();
					if (!checkMatchingSymbols(charArr[i], currentCheckSymbol))
					{
						unmatchedSymbol(lineNum, i, charArr[i], getMatchingSymbol(currentCheckSymbol));
					}
				}
			}
			lineNum++;
		}
		
		if (!stack.isEmpty())
		{
			
		}
	}
	
	private static boolean checkMatchingSymbols (char c1, char c2)
	{
		if (c1 == '(' && c2 == ')')
			return true;
		else if (c1 == '{' && c2 == '}')
			return true;
		else if (c1 == '[' && c2 == ']')
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
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
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