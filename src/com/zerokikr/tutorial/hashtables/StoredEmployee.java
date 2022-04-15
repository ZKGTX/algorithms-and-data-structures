package com.zerokikr.tutorial.hashtables;

public class StoredEmployee {
	
	public String key; // raw key, not the hashed value!
	public Employee employee;
	
	public StoredEmployee(String key, Employee employee) {
		this.key = key;
		this.employee = employee;
	}
	
	

}
