package com.zerokikr.tutorial.stacks;

import java.util.EmptyStackException;

public class ArrayStack {
	
	private Employee[] stack;
	
	private int top; // top is always index where we would push the next element. zero by default. equals the size of stack
	
	
	public ArrayStack (int capacity) {
		stack = new Employee [capacity];
	}
	
	public void push(Employee employee) { // time complexity is O(n) linear because of resizing
		
		if (top == stack.length) {
			 // need to resize the backing array!
			Employee[] newArray = new Employee[2 * stack.length];
			
			System.arraycopy(stack, 0, newArray, 0, stack.length);
			//                 ^    ^      ^     ^        ^
		    //                 |    | copy into  |   how many elements to copy
		    //         copy from 1st element  starting at
			
			stack = newArray;
		}
		
		stack [top++] = employee;
	}
	
	public Employee pop() { // constant time O(1) if there is no resizing of array
		
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		Employee employee = stack[--top]; // the actual top item is stored at position [top - 1]
		
		stack[top] = null;
		
		return employee;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public Employee peek() { // always constant time O(1)
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		return stack [top - 1];
	}
	
	public int size() {
		return top;
	}
	
	public void printStack() {
		for (int i = top - 1; i >= 0; i--) {
			System.out.println(stack[i]); 
		}
	}

	
}
