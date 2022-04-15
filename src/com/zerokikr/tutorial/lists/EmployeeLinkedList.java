package com.zerokikr.tutorial.lists;

public class EmployeeLinkedList {
	
	private EmployeeNode head;
	private int size; // 0 by default 
	
	
	public void addToFront (Employee employee) { // inserting happens at the front of the list
		
		EmployeeNode node = new EmployeeNode(employee); //create new node with new employee
		
		node.setNext(head); // current head node becomes the next node
		
		head = node; // new node becomes the new head
		
		size++;
	}
	
	public EmployeeNode removeFromFront () {
		if (isEmpty()) {
			return null;
		}
		
		EmployeeNode removedNode = head;
		head = head.getNext();
		size--;
		removedNode.setNext(null);
		return removedNode;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty () {
		return head == null;
	}
	
	
	
	
	
	public void printList () {
		EmployeeNode current = head;
		System.out.print("HEAD -> ");
		while (current != null) {
			System.out.print(current);
			System.out.print(" -> ");
			current = current.getNext();
		}
		System.out.print("null");
	}

}
