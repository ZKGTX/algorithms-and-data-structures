package com.zerokikr.tutorial.hashtables;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class MainApp2 {

	public static void main(String[] args) {

		int[] nums = new int[10];
		int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };

		for (int i = 0; i < numsToAdd.length; i++) {
			nums[hash(numsToAdd[i])] = numsToAdd[i];
		}

		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

		Employee vasiliyPalkin = new Employee("Vasiliy", "Palkin", 1234);
		Employee petrKonev = new Employee("Petr", "Konev", 9876);
		Employee borisBritva = new Employee("Boris", "Britva", 5678);
		Employee borisBritva2 = new Employee("Boris", "Britva", 5678);
		Employee vasiliyPalkin2 = new Employee("Vasiliy", "Palkin", 1234);
		Employee stepanRazin = new Employee("Stepan", "Razin", 9157);

		LinkedList<Employee> list = new LinkedList<>();

		list.add(vasiliyPalkin);
		list.add(petrKonev);
		list.add(borisBritva);
		list.add(borisBritva2);
		list.add(vasiliyPalkin2);
		list.add(stepanRazin);

		removeDuplicate(list);

		ListIterator<Employee> it = list.listIterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	public static int hash(int value) {
		return Math.abs(value % 10);
	}

	public static void removeDuplicate(LinkedList<Employee> list) {

		HashMap<Integer, Employee> map = new HashMap<>();

		ListIterator<Employee> iterator = list.listIterator();

		while (iterator.hasNext()) {
			
			Employee current = iterator.next();
			
			if (!map.containsKey(current.getId())) {
				
				map.put(current.getId(), current);
				
			} else {
				
				iterator.remove();
			}

		}

	}

}
