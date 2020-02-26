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
	
	@Test
	void testIsEmptyTrue() {
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void testIsEmptyFalse() {
		stack.push('a');
		assertFalse(stack.isEmpty());
	}
	
	@Test
	void peekEmptyList() {
		assertThrows(NoSuchElementException.class, () -> {stack.peek();});
	}
	
	@Test
	void popEmptyList() {
		assertThrows(NoSuchElementException.class, () -> {stack.pop();});
	}
	
	@Test
	void testSize() {
		stack.push('a');
		stack.push('b');
		assertEquals(2, stack.size());
	}
	
	@Test
	void popTest1() {
		stack.push('b');
		stack.push('a');
		assertEquals('a', stack.pop());
		assertEquals('b', stack.pop());
	}
	
	@Test
	void peekTest1() {
		stack.push('b');
		stack.push('a');
		assertEquals('a', stack.peek());
	}

}
