package assign06;

import java.util.Random;

import assign05.ArrayListSorter;

public class StackTimer {
	final static int TIMES_TO_LOOP = 1000;
	
	public static void main (String [] args)
	{
		timeLinkedPush(10000, 200000, 10000);
		timeArrayPush(10000, 200000, 10000);
		timeLinkedPop(10000, 200000, 10000);
		timeArrayPop(10000, 200000, 10000);
		timeLinkedPeek(10000, 200000, 10000);
		timeArrayPeek(10000, 200000, 10000);
	}
	
	public static void timeLinkedPush (int start, int end, int stepSize)
	{
		System.out.println("Linked List Push");
		LinkedListStack<Character> stack = new LinkedListStack<Character>();
		
		for (int N = start; N < end + 1; N += stepSize)
		{
			long startTime, midTime, stopTime, totalTime;
			
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1_000_000_000);
			
			totalTime = 0;
			int i;
			int j;
			
			for (j = 0; j < N; j++)
				stack.push('a');
			
			for(i = 0; i < TIMES_TO_LOOP; i++)
			{
				midTime = System.nanoTime();
				stack.push('d');
				stopTime = System.nanoTime();
				totalTime += (stopTime - midTime);
				stack.pop();
			}
			
			double averageTime = totalTime / TIMES_TO_LOOP;
			
			System.out.println(N + "\t" + averageTime);
		}
		
		System.out.println();
	}
	
	public static void timeArrayPush (int start, int end, int stepSize)
	{
		System.out.println("Array Push");
		ArrayStack<Character> stack = new ArrayStack<Character>();
		
		for (int N = start; N < end + 1; N += stepSize)
		{
			long startTime, midTime, stopTime, totalTime;
			
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1_000_000_000);
			
			totalTime = 0;
			int i;
			int j;
			
			for (j = 0; j < N; j++)
				stack.push('a');
			
			for(i = 0; i < TIMES_TO_LOOP; i++)
			{
				midTime = System.nanoTime();
				stack.push('d');
				stopTime = System.nanoTime();
				totalTime += (stopTime - midTime);
				stack.pop();
			}
			
			double averageTime = totalTime / TIMES_TO_LOOP;
			
			System.out.println(N + "\t" + averageTime);
		}
		
		System.out.println();
	}
	
	public static void timeLinkedPop (int start, int end, int stepSize)
	{
		System.out.println("Linked List Pop");
		LinkedListStack<Character> stack = new LinkedListStack<Character>();
		
		for (int N = start; N < end + 1; N += stepSize)
		{
			long startTime, midTime, stopTime, totalTime;
			
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1_000_000_000);
			
			totalTime = 0;
			int i;
			int j;
			
			for (j = 0; j < N; j++)
				stack.push('a');
			
			for(i = 0; i < TIMES_TO_LOOP; i++)
			{
				midTime = System.nanoTime();
				stack.pop();
				stopTime = System.nanoTime();
				totalTime += (stopTime - midTime);
				stack.push('a');
			}
			
			double averageTime = totalTime / TIMES_TO_LOOP;
			
			System.out.println(N + "\t" + averageTime);
		}
		
		System.out.println();
	}
	
	public static void timeArrayPop (int start, int end, int stepSize)
	{
		System.out.println("Array Pop");
		ArrayStack<Character> stack = new ArrayStack<Character>();
		
		for (int N = start; N < end + 1; N += stepSize)
		{
			long startTime, midTime, stopTime, totalTime;
			
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1_000_000_000);
			
			totalTime = 0;
			int i;
			int j;
			
			for (j = 0; j < N; j++)
				stack.push('a');
			
			for(i = 0; i < TIMES_TO_LOOP; i++)
			{
				midTime = System.nanoTime();
				stack.pop();
				stopTime = System.nanoTime();
				totalTime += (stopTime - midTime);
				stack.push('a');
			}
			
			double averageTime = totalTime / TIMES_TO_LOOP;
			
			System.out.println(N + "\t" + averageTime);
		}
		
		System.out.println();
	}
	
	public static void timeLinkedPeek (int start, int end, int stepSize)
	{
		System.out.println("Linked Peek");
		LinkedListStack<Character> stack = new LinkedListStack<Character>();
		
		for (int N = start; N < end + 1; N += stepSize) 
		{
			long startTime, midTime, stopTime, totalTime;
			
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1_000_000_000);
			
			totalTime = 0;
			int i;
			int j;
			
			for (j = 0; j < N; j++)
				stack.push('a');
			
			for(i = 0; i < TIMES_TO_LOOP; i++)
			{
				midTime = System.nanoTime();
				stack.peek();
				stopTime = System.nanoTime();
				totalTime += (stopTime - midTime);
			}
			
			double averageTime = totalTime / TIMES_TO_LOOP;
			
			System.out.println(N + "\t" + averageTime);
		}
		
		System.out.println();
	}
	
	public static void timeArrayPeek (int start, int end, int stepSize)
	{
		System.out.println("Array peek");
		ArrayStack<Character> stack = new ArrayStack<Character>();
		
		for (int N = start; N < end + 1; N += stepSize) 
		{
			long startTime, midTime, stopTime, totalTime;
			
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1_000_000_000);
			
			totalTime = 0;
			int i;
			int j;
			
			for (j = 0; j < N; j++)
				stack.push('a');
			
			for(i = 0; i < TIMES_TO_LOOP; i++)
			{
				midTime = System.nanoTime();
				stack.peek();
				stopTime = System.nanoTime();
				totalTime += (stopTime - midTime);
			}
			
			double averageTime = totalTime / TIMES_TO_LOOP;
			
			System.out.println(N + "\t" + averageTime);
		}
		
		System.out.println();
	}
}
