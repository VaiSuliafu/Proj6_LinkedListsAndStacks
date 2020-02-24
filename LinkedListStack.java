package assign06;

import java.util.NoSuchElementException;

public class LinkedListStack <T extends Comparable> implements Stack <T> {

	private SinglyLinkedList<T> mainList;
	
	public LinkedListStack () {
		mainList = new SinglyLinkedList<T>();
	}
	
	/**
	 * Removes all of the elements from the stack.
	 */
	@Override
	public void clear() {
		mainList.clear();
	}

	/**
	 * @return true if the stack contains no elements; false, otherwise.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return mainList.isEmpty();
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public T peek() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (mainList.size() == 0)
			throw new NoSuchElementException();
		return mainList.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public T pop() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (mainList.size() == 0)
			throw new NoSuchElementException();
		return mainList.removeFirst();
	}

	/**
	 * Adds a given element to the stack, putting it at the top of the stack.
	 * 
	 * @param element - the element to be added
	 */
	@Override
	public void push(T element) {
		mainList.addFirst(element);
	}

	/**
	 * @return the number of elements in the stack
	 */
	@Override
	public int size() {
		return mainList.size();
	}



}
