package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class BalancedSymbolCheckerTester {

	@Test
	void test1() {
		
		String filename = "src/assign06/try.txt";
		File x = new File(filename);
		System.out.println(x.exists()); // this prints true
		BalancedSymbolChecker.checkFile(filename); // so why does this have an error?

	}
	


}
