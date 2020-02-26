package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class BalancedSymbolCheckerTester {

	@Test
	void class1Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class1.java");
		assertEquals("ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.", message);
	}
	
	@Test
	void class2Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class2.java");
		assertEquals("ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.", message);
	}
	
	@Test
	void class3Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class3.java");
		assertEquals("No errors found. All symbols match.", message);
	}
	
	@Test
	void class4Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class4.java");
		assertEquals("ERROR: File ended before closing comment.", message);
	}
	
	@Test
	void class5Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class5.java");
		assertEquals("ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.", message);
	}
	
	@Test
	void class6Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class6.java");
		assertEquals("No errors found. All symbols match.", message);
	}
	
	@Test
	void class7Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class7.java");
		assertEquals("ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.", message);
	}
	
	@Test
	void class8Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class8.java");
		assertEquals("ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.", message);
	}
	
	@Test
	void class9Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class9.java");
		assertEquals("ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.", message);
	}
	
	@Test
	void class10Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class10.java");
		assertEquals("ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.", message);
	}
	
	@Test
	void class11Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class11.java");
		assertEquals("ERROR: Unmatched symbol at the end of file. Expected }.", message);
	}
	
	@Test
	void class12Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class12.java");
		assertEquals("No errors found. All symbols match.", message);
	}
	
	@Test
	void class13Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class13.java");
		assertEquals("No errors found. All symbols match.", message);
	}
	
	@Test
	void class14Test() throws FileNotFoundException {
		
		String message = BalancedSymbolChecker.checkFile("src/TestFiles/Class14.java");
		assertEquals("No errors found. All symbols match.", message);
	}
}
