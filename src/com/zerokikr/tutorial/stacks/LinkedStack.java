package com.zerokikr.tutorial.stacks;

import java.util.LinkedList;

public class LinkedStack { // if you need a class that behaves as a stack
	
	private LinkedList <Employee> stack;  
	
	public LinkedStack () {
		stack = new LinkedList <Employee>();
	}
	
	public void push(Employee employee) {
		stack.push(employee);
	}
	
	public Employee pop () {
		return stack.pop();
	}
	
	public Employee peek () {
		return stack.peek();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
}
