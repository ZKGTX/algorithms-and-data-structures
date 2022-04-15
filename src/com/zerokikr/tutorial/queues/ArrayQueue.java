package com.zerokikr.tutorial.queues;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue {
	
	private Employee[] queue;
	private int front; // position 0
	private int back; // points to next available position in the queue (1 for a queue of 0 elements)
	
	public ArrayQueue (int capacity) {
		queue = new Employee[capacity];
	}
	
	public void add (Employee employee) { // circular (rapping) queue implementation
		
		if (size() == queue.length - 1) {
			int numItems = size();
			Employee[]newArray = new Employee[2 * queue.length];
			System.arraycopy(queue, front, newArray, 0, queue.length - front);
			System.arraycopy(queue, 0, newArray, queue.length - front, back);
			queue = newArray;
			front = 0;
			back = numItems;
		}
		queue[back] = employee;
		if (back < queue.length - 1) {
			back++;
		}
		else {
			back = 0;
		}
		
	}
	
	public Employee remove() { // circular (wrapping) queue implementation
		if (size() == 0) {
			throw new NoSuchElementException();
		} 
		
		Employee employee = queue[front];
		queue[front] = null;
		front++;
		if (size() == 0) {
			front = 0;
			back = 0;
		}
		
		else if (front == queue.length) {
			front = 0;
		}
		
		return employee;
	}
	
	public Employee peek() {
		
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		
		return queue[front];
	}
	
	public void printQ () {
		if (front <= back) {
			for (int i = front; i < back; i++) { // back == queue.length()
			System.out.println(queue[i]);
		}
	}
		else {
			for (int i = front; i < queue.length; i++) {
				System.out.println(queue[i]);
			}
			for (int i = 0; i < back; i++) {
				System.out.println(queue[i]);
			}
		}
		
		
	}
	
	
	public int size() {
		if (front <= back) { // test if the queue is wrapped
			return back - front;
		}
		return back - front + queue.length;
	}

}
