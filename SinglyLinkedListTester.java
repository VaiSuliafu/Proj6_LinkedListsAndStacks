package assign06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assign06.SinglyLinkedList.Node;

public class SinglyLinkedListTester <T> {
	
	SinglyLinkedList<Character> linkedList = new SinglyLinkedList();
	
	@Test
	void addFirst1()
	{
		linkedList.addFirst('a');
		assertEquals('a', linkedList.getFirst());
		assertEquals('a', linkedList.get(0));
		assertEquals(1, linkedList.size());
	}
	
	@Test
	void addFirst2()
	{
		linkedList.addFirst('b');
		linkedList.addFirst('a');
		assertEquals('a', linkedList.getFirst());
		assertEquals('a', linkedList.get(0));
		assertEquals('b', linkedList.get(1));
		assertEquals(2, linkedList.size());
	}
	
	@Test
	void addException1()
	{
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.add(1, 'b');
		});
	}
	
	@Test
	void addException2()
	{
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.add(-1, 'b');
		});
	}
	
	@Test
	void addException3()
	{
		linkedList.addFirst('a');
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.add(2, 'b');
		});
	}
	
	@Test
	void add1()
	{
		linkedList.add(0, 'a');
		assertEquals('a', linkedList.getFirst());
		assertEquals(1, linkedList.size());
	}
	
	@Test
	void add2()
	{
		linkedList.add(0, 'b');
		linkedList.add(0, 'a');
		assertEquals('a', linkedList.get(0));
		assertEquals('b', linkedList.get(1));
		assertEquals(2, linkedList.size());
	}
	
	@Test
	void add3()
	{
		linkedList.add(0, 'a');
		linkedList.add(1, 'b');
		linkedList.add(2, 'c');
		assertEquals('a', linkedList.get(0));
		assertEquals('b', linkedList.get(1));
		assertEquals('c', linkedList.get(2));
		assertEquals(3, linkedList.size());
	}
	
	@Test
	void add4()
	{
		linkedList.add(0, 'b');
		linkedList.add(0, 'a');
		linkedList.add(2, 'd');
		linkedList.add(2, 'c');
		assertEquals('a', linkedList.get(0));
		assertEquals('b', linkedList.get(1));
		assertEquals('c', linkedList.get(2));
		assertEquals('d', linkedList.get(3));
		assertEquals(4, linkedList.size());
	}
	
	@Test
	void getFirstException1()
	{
		assertThrows(NoSuchElementException.class, () -> {
			linkedList.getFirst();
		});
	}
	
	@Test
	void getException1()
	{
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.get(-1);
		});
	}
	
	@Test
	void getException2()
	{
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.get(0);
		});
	}
	
	@Test
	void getException3()
	{
		linkedList.addFirst('a');
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.get(1);
		});
	}
	
	@Test
	void removeFirstException1()
	{
		assertThrows(NoSuchElementException.class, () -> {
			linkedList.getFirst();
		});
	}
	
	@Test
	void removeException1()
	{
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.remove(-1);
		});
	}
	
	@Test
	void removeException2()
	{
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.remove(0);
		});
	}
	
	@Test
	void removeException3()
	{
		linkedList.addFirst('a');
		assertThrows(IndexOutOfBoundsException.class, () -> {
			linkedList.remove(1);
		});
	}
	
	@Test
	void remove1()
	{
		linkedList.add(0, 'a');
		assertFalse(linkedList.isEmpty());
		linkedList.remove(0);
		assertTrue(linkedList.isEmpty());
	}
	
	@Test
	void remove2()
	{
		linkedList.add(0, 'a');
		linkedList.add(1, 'b');
		assertFalse(linkedList.isEmpty());
		linkedList.remove(0);
		assertEquals('b', linkedList.get(0));
	}
	
	@Test
	void remove3()
	{
		linkedList.addFirst('c');
		linkedList.addFirst('b');
		assertEquals('b', linkedList.remove(0));
		assertEquals('c', linkedList.remove(0));
	}
	
	@Test
	void remove4()
	{
		linkedList.addFirst('a');
		assertEquals('a', linkedList.remove(0));
	}
	
	@Test
	void remove5()
	{
		linkedList.addFirst('d');
		linkedList.addFirst('c');
		linkedList.addFirst('b');
		linkedList.addFirst('a');
		assertEquals('d', linkedList.remove(3));
		assertEquals('c', linkedList.remove(2));
		assertEquals('b', linkedList.remove(1));
		assertEquals('a', linkedList.remove(0));
	}
	
	@Test
	void removeFirst()
	{
		linkedList.addFirst('a');
		linkedList.addFirst('b');
		linkedList.addFirst('c');
		assertEquals('c', linkedList.removeFirst());
		assertEquals('b', linkedList.removeFirst());
		assertEquals('a', linkedList.removeFirst());
	}
	
	@Test
	void removeFirstNoElements()
	{
		assertThrows(NoSuchElementException.class, () -> {linkedList.removeFirst();});
	}
	
	@Test
	void removeBadIndex()
	{
		linkedList.addFirst('a');
		linkedList.addFirst('c');
		assertThrows(IndexOutOfBoundsException.class, () -> {linkedList.remove(3);});
	}
	
	@Test
	void testToArray()
	{
		linkedList.addFirst('c');
		linkedList.addFirst('b');
		linkedList.addFirst('a');
		assertEquals('a', linkedList.toArray()[0]);
		assertEquals('b', linkedList.toArray()[1]);
		assertEquals('c', linkedList.toArray()[2]);
	}
	
	@Test
	void testSize()
	{
		linkedList.addFirst('c');
		linkedList.addFirst('b');
		linkedList.addFirst('a');
		assertEquals(3, linkedList.size());
	}
	
	@Test
	void testClear()
	{
		linkedList.addFirst('c');
		linkedList.addFirst('b');
		linkedList.addFirst('a');
		linkedList.clear();
		assertTrue(linkedList.isEmpty());
	}
	
	@Test
	void testIndexOf()
	{
		linkedList.addFirst('c');
		linkedList.addFirst('b');
		linkedList.addFirst('a');
		assertEquals(1, linkedList.indexOf('b'));
	}
	
	@Test
	void testIndexOfBadIndex()
	{
		linkedList.addFirst('c');
		linkedList.addFirst('b');
		linkedList.addFirst('a');
		assertEquals(1, linkedList.indexOf('b'));
	}

}
