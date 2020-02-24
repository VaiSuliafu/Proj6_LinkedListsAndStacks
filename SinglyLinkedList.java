package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SinglyLinkedList <T extends Comparable> implements List <T> {

	private Node<T> head;
	private int size;
	
	public SinglyLinkedList ()
	{
		this.size = 0;
		this.head = new Node(null, null);
	}
	
	/**
	 * Inserts an element at the beginning of the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @param element - the element to add
	 */
	@Override
	public void addFirst(T element) 
	{
		Node newNode = new Node<T>(element, head.getReference());
		head.setReference(newNode);
		this.size++;
	}

	/**
	 * Inserts an element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException if index is out of range 
	 * (index < 0 || index > size())
	 */
	@Override
	public void add(int index, T element) throws IndexOutOfBoundsException 
	{	
		if (index > this.size || index < 0)
			throw new IndexOutOfBoundsException();
		
		if (index == 0)
		{
			this.addFirst(element);
			return;
		}
		
		Node<T> temp = getNodeAtIndex(index - 1);
		
		Node <T> tempReference = temp.getReference();
		
		temp.setReference(new Node <T> (element, tempReference));
		
		this.size++;
	}

	/**
	 * Gets the first element in the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public T getFirst() throws NoSuchElementException 
	{
		if (this.size == 0)
			throw new NoSuchElementException();
		
		return this.head.getReference().getValue();
	}

	/**
	 * Gets the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range 
	 * (index < 0 || index >= size())
	 */
	@Override
	public T get(int index) throws IndexOutOfBoundsException 
	{	
		if (index < 0 || index >= this.size)
			throw new IndexOutOfBoundsException();
		
		Iterator<T> iter = new sLLIterator();
		
		for (int i = 0; i < index; i++)
			iter.next();
		return iter.next();
			
	}

	/**
	 * Removes and returns the first element from the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public T removeFirst() throws NoSuchElementException 
	{	
		Node<T> removalNode = head.getReference();
		T temp = removalNode.getValue();
		head.setReference(removalNode.getReference());
		this.size--;
		return temp;
	}

	/**
	 * Removes and returns the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range 
	 * (index < 0 || index >= size())
	 */
	@Override
	public T remove(int index) throws IndexOutOfBoundsException 
	{	
		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();
		
		if (index == 0)
		{
			return this.removeFirst();
		}
		
		Node<T> temp = getNodeAtIndex(index - 1);
		
		T tempVal = temp.getReference().getValue();
		
		temp.setReference(temp.getReference().getReference());
		
		this.size--;
		
		return tempVal;			
	}

	/**
	 * Determines the index of the first occurrence of the specified 
	 * element in the list, or -1 if this list does not contain the element.
	 * O(N) for a singly-linked list.
	 * 
	 * @param element - the element to search for
	 * @return the index of the first occurrence; -1 if the element is not found
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(T element) 
	{
		Iterator<T> iter = iterator();
		int index = 0;
		
		while (iter.hasNext())
		{
			if (element.compareTo(iter.next()) == 0)
			{
				return index;
			}

			index++;
		}
		
		return -1;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return the number of elements in this list
	 */
	@Override
	public int size() 
	{
		return this.size;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return true if this collection contains no elements; false, otherwise
	 */
	@Override
	public boolean isEmpty() 
	{
		return (this.size <= 0);
	}

	/**
	 * Removes all of the elements from this list.
	 * O(1) for a singly-linked list.
	 */
	@Override
	public void clear() 
	{
		this.head = null;
	}

	/**
	 * Generates an array containing all of the elements in this list in proper 
	 * sequence (from first element to last element).
	 * O(N) for a singly-linked list.
	 * 
	 * @return an array containing all of the elements in this list, in order
	 */
	@Override
	public Object[] toArray() 
	{
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) new Object[this.size];
		
		Node<T> temp = head;
		
		for (int i = 0; i < this.size; i++)
		{
			arr[i] = temp.getValue();
			temp = temp.getReference();
		}
		
		return arr;
	}

	/**
	 * @return an iterator over the elements in this list in proper sequence 
	 * (from first element to last element)
	 */
	@Override
	public Iterator<T> iterator() 
	{
		return new sLLIterator();
	}
	
	class sLLIterator implements Iterator<T> 
	{
		private Node<T> reference = head;
		private boolean lastRemoved = false;

		@Override
		public boolean hasNext() {
			return reference.getReference() != null;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			T tempVal = reference.getReference().getValue(); // get next nodes value
			reference = reference.getReference(); // move this node to the next node
			lastRemoved = false;
			return tempVal;
		}
		
		public void remove() {
			if (lastRemoved)
				throw new IllegalStateException();
			
			T tempVal = reference.getReference().getValue();
			reference.setReference(reference.getReference().getReference());
		}
	}
		
	
	/* Returns the node at the specified index */
	private Node<T> getNodeAtIndex(int index)
	{
		Node <T> temp = head;
		
		for (int i = 0; i <= index; i++)
		{
			temp = temp.getReference();
		}
		
		return temp;
	}
	
	public class Node <T> {
		
		private T value;
		
		private Node<T> reference;
		
		public Node (T value, Node<T> reference) {
			this.value = value;
			this.reference = reference;
		}
		
		public void setValue (T value)
		{
			this.value = value;
		}
		
		public void setReference (Node<T> reference)
		{
			this.reference = reference;
		}
		
		public T getValue ()
		{
			return this.value;
		}
		
		public Node<T> getReference ()
		{
			return this.reference;
		}

	}

}
