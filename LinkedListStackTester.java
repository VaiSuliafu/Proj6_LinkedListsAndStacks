package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class LinkedListStackTester {

	LinkedListStack<Character> stack = new LinkedListStack<Character>();
	
	@Test
	void testClear() {
		stack.push('a');
		stack.push('b');
		stack.clear();
		assertTrue(stack.isEmpty());
	}
	
	void testIsEmptyTrue() {
		assertTrue(stack.isEmpty());
	}
	
	void testIsEmptyFalse() {
		stack.push('a');
		assertFalse(stack.isEmpty());
	}
	
	void peekEmptyList() {
		assertThrows(NoSuchElementException.class, () -> {stack.peek();});
	}
	
	void popEmptyList() {
		assertThrows(NoSuchElementException.class, () -> {stack.pop();});
	}
	
	void testSize() {
		stack.push('a');
		stack.push('b');
		assertEquals(2, stack.size());
	}
	
	void popTest1() {
		stack.push('b');
		stack.push('a');
		assertEquals('a', stack.pop());
		assertEquals('b', stack.pop());
	}
	
	void peekTest1() {
		stack.push('b');
		stack.push('a');
		assertEquals('a', stack.peek());
	}

}
