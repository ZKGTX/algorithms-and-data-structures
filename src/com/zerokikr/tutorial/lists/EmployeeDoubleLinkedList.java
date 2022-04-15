package com.zerokikr.tutorial.lists;

public class EmployeeDoubleLinkedList {
	
	private EmployeeNode head;
	private EmployeeNode tail;
	private int size; // 0 by default 
	
	
	public void addToFront (Employee employee) { // inserting happens at the front of the list
		
		EmployeeNode node = new EmployeeNode(employee); //create new node with new employee
		
		node.setNext(head); // current head node becomes the next node
		
		if (head == null) {
			tail = node;
		}
		
		else {
			head.setPrevious(node);
		}
		
		head = node; // new node becomes the new head
		
		size++;
	}
	
	public void addToEnd (Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		if (tail == null) {
			head = node;
		}
		else {
			tail.setNext(node);
			node.setPrevious(tail);
		}
		tail = node;
		size++;
	}
	
	public EmployeeNode removeFromFront () {
		
		if (isEmpty()) {
			return null;
		}
		
		EmployeeNode removedNode = head;
		
		if (head.getNext() == null) {
			tail = null;
		}
		else {
			head.getNext().setPrevious(null);
		}
		
		head = head.getNext();
		size--;
		removedNode.setNext(null);
		return removedNode;
	}
	
	public EmployeeNode removeFromEnd () {
		if (isEmpty()) {
			return null;
		}
		
		EmployeeNode removedNode = tail;
		
		if (tail.getPrevious() == null) {
			head = null;
		}
		
		else {
			tail.getPrevious().setNext(null);
		}
		
		tail = tail.getPrevious();
		
		size--;
		removedNode.setPrevious(null);
		return removedNode;
	}
	
	public boolean addBefore(Employee newEmployee, Employee existingEmployee) {
		
		if (head == null) { //первым делом проверь не пуст ли список!
			return false;
		}
		
		EmployeeNode current = head;
		
		while (current != null && !current.getEmployee().equals(existingEmployee)) { // иди по узлам до конца пока не встретил existingEmployee в каком-то узле
			current = current.getNext();
		}
		
		// вываливаемся из while когда current == null или когда наткнулись на existingEmployee 
		
		if (current == null) {
			return false;
		}
		
		else {
			
			EmployeeNode newNode = new EmployeeNode(newEmployee);
			
			newNode.setPrevious(current.getPrevious());
			newNode.setNext(current);
			current.setPrevious(newNode);
				
				if (head == current) {
					head = newNode;
				}
				
				else {
					newNode.getPrevious().setNext(newNode);
				}
				
				size++;
				
				return true;

		}			
		 
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
			System.out.print(" <-> ");
			current = current.getNext();
		}
		System.out.print("null");
	}

}
