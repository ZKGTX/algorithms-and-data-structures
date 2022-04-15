package com.zerokikr.tutorial.hashtables;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {
	
	private LinkedList<StoredEmployee>[] hashtable;
	
	public ChainedHashTable() {
		hashtable = new LinkedList[10];
		for (int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new LinkedList<StoredEmployee>();
		}
	}
	
	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}
	
	public void put (String key, Employee employee) {
		int hashedKey = hashKey(key);
		hashtable[hashedKey].add(new StoredEmployee(key, employee));
	}
	
	public Employee get (String key) {
		
		int hashedKey = hashKey(key);
		
		ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
		
		StoredEmployee storedEmployee = null;
		
		while (iterator.hasNext()) {
			storedEmployee = iterator.next();
			if (storedEmployee.key.equals(key)) {
				return storedEmployee.employee;
			}
		}
		
		return null;
	}
	
	public Employee remove (String key) {
		
		int hashedKey = hashKey(key);
		
		ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
		
		StoredEmployee storedEmployee = null;
		
		int index = -1;
		
		while (iterator.hasNext()) {
			storedEmployee = iterator.next();
			index++;
			if (storedEmployee.key.equals(key)) {
				break;
			}
		}
		if (storedEmployee == null) {
			return null;
		}
		else {
			hashtable[hashedKey].remove(index);
			return storedEmployee.employee;
		}

	}
	
	public void printHashtable () {
		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i].isEmpty()) {
				System.out.println("position " + i + " : empty");
			}
			else {
				System.out.print("position " + i + " ");
				ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
				while (iterator.hasNext()) {
					System.out.print(iterator.next().employee);
					System.out.print(" -> ");
				}
				System.out.println("null");
			}
		}
	}

}
