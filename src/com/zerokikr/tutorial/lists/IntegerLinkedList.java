package com.zerokikr.tutorial.lists;

public class IntegerLinkedList {
	
	private IntegerNode head;
	
	
	public void insertSorted(Integer number) {
		
		IntegerNode newNode = new IntegerNode(number);
		
		if (head == null || head.getNumber() >= number) {
			newNode.setNext(head);
			head = newNode;
			return;
		}
		
		// find the insertion point
		
		IntegerNode current = head.getNext();
		IntegerNode previous = head;
		
		while (current != null && current.getNumber() < number) {
			previous = current;
			current = current.getNext();
		}
		
		newNode.setNext(current);
		previous.setNext(newNode);
		
		
		
		}
		
	
	
	public boolean isEmpty () {
		return head == null;
	}
	
	public void printList () {
		IntegerNode current = head;
		System.out.print("HEAD -> ");
		while (current != null) {
			System.out.print(current);
			System.out.print(" -> ");
			current = current.getNext();
		}
		System.out.print("null");
	}

	
}
