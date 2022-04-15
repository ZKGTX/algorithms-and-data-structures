package com.zerokikr.tutorial.hashtables;

public class SimpleHashTable {

	private StoredEmployee[] hashTable;

	public SimpleHashTable() {
		hashTable = new StoredEmployee[10];
	}

	private int hashKey(String key) {
		return key.length() % hashTable.length;
	}

	private int findKey(String key) { // accepts raw key as parameter

		int hashedKey = hashKey(key);

		if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
			return hashedKey;
		}

		int stopIndex = hashedKey;

		if (hashedKey == hashTable.length - 1) {
			hashedKey = 0;
		}

		else {
			hashedKey++;
		}

		while (hashedKey != stopIndex && hashTable[hashedKey] != null && !hashTable[hashedKey].key.equals(key)) {

			hashedKey = (hashedKey + 1) % hashTable.length;
		}

		if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
			return hashedKey;
		}
		else {
			return -1;
		}
	}

	private boolean occupied(int index) {
		return hashTable[index] != null;
	}

	public void put(String key, Employee employee) {

		int hashedKey = hashKey(key);

		if (occupied(hashedKey)) {
			int stopIndex = hashedKey;
			if (hashedKey == hashTable.length - 1) {
				hashedKey = 0;
			} else {
				hashedKey++;
			}

			while (occupied(hashedKey) && hashedKey != stopIndex) {
				hashedKey = (hashedKey + 1) % hashTable.length;
			}
		}

		if (occupied(hashedKey)) {
			System.out.println("Position " + hashedKey + " already occupied");
		}

		else {
			hashTable[hashedKey] = new StoredEmployee(key, employee);
		}
	}

	public Employee get(String key) {

		int hashedKey = findKey(key);
		if (hashedKey == -1) {
			return null;
		}
		return hashTable[hashedKey].employee;
	}
	
	public Employee remove (String key) { // this method uses rehashing of current hash table
		int hashedKey = findKey(key);
		if (hashedKey == -1) {
			return null;
		}
		
		Employee employee = hashTable[hashedKey].employee;
		hashTable[hashedKey] = null;
		
		StoredEmployee[] oldHashTable = hashTable; // storing the current hash table before rehashing
		
		hashTable = new StoredEmployee[oldHashTable.length];
		
		for (int i = 0; i < oldHashTable.length; i++) {
			if (oldHashTable[i] != null) {
				put(oldHashTable[i].key, oldHashTable[i].employee);
			}
		}
		
		return employee;
	}

	public void printHashTable() {
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] == null) {
				System.out.println("Empty");
			} else {
				System.out.println(hashTable[i].employee);
			}
		}
	}

}
