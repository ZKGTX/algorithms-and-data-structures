package com.zerokikr.tutorial.lists;

public class LinkedListTutorial {
	
	public static void main(String[] args) {
		
		Employee vasiliyPalkin = new Employee ("Vasiliy", "Palkin", 1234);
		Employee petrKonev = new Employee ("Petr", "Konev", 9876);
		Employee borisBritva = new Employee ("Boris", "Britva", 5678);
		Employee stepanRazin = new Employee ("Stepan", "Razin", 9157);
		
		EmployeeLinkedList list = new EmployeeLinkedList();
		
		list.addToFront(stepanRazin);
		list.addToFront(petrKonev);
		list.addToFront(borisBritva);
		list.addToFront(vasiliyPalkin);
		
		//list.printList();
		
		EmployeeDoubleLinkedList doubleList = new EmployeeDoubleLinkedList();
		doubleList.addToFront(stepanRazin);
		doubleList.addToFront(petrKonev);
		doubleList.addToFront(borisBritva);
		doubleList.addToFront(vasiliyPalkin);
		
		doubleList.printList();
		
		doubleList.removeFromEnd();
		
		System.out.println("");
		
		doubleList.printList();
		
		System.out.println("");
		
		doubleList.addBefore(stepanRazin, vasiliyPalkin);
		
		doubleList.printList();
		
		System.out.println("");

		
		doubleList.addBefore(new Employee ("First", "Employee", 1212), stepanRazin);
		
		doubleList.printList();
		
		System.out.println("-------------------------");
		
		IntegerLinkedList integerList = new IntegerLinkedList();
		
		integerList.insertSorted(4);
		integerList.insertSorted(2);
		integerList.insertSorted(1);
		integerList.insertSorted(5);
		
		integerList.printList();


		
		
		
		
	}

}
