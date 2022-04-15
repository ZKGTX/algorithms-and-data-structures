package com.zerokikr.tutorial.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayListTutorial {

	List<String> stringlist = new ArrayList<>(); // use List interface when declaring stringList to be able to change to
												 // another List-implementing class later (like Vector)

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee("Vasiliy", "Palkin", 1234));
		
		// you need to implement equals() and hashCode() methods in Employee class to be able to do this
		Employee[] employeeArray = employees.toArray(new Employee[employees.size()]);
		
		// you need to implement equals() and hashCode() methods in Employee class to get true here
		System.out.println(employees.contains(new Employee("Vasiliy", "Palkin", 1234)));

	}

}
