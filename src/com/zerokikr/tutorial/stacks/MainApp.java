package com.zerokikr.tutorial.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MainApp {
	
	public static void main(String[] args) {
		
		System.out.println(isPalindrome("I did, did I?"));
		System.out.println(isPalindrome("Racecar"));
		System.out.println(isPalindrome("hello"));
		System.out.println(isPalindrome("Ass"));
		System.out.println(isPalindrome("Abba"));
				
		
		System.out.println("------------------------------");
		
		ArrayStack stack = new ArrayStack(10);
		
		stack.push(new Employee("Dick", "Tracy", 1365));
		stack.push(new Employee("Jessica", "Rabbit", 1967));
		stack.push(new Employee("Donald", "Duck", 9669));
		stack.push(new Employee("H.P.", "Baxxter", 2582));
		
		stack.printStack();
		
		//System.out.println(stack.pop());
		
		//System.out.println("-------------------");
		
		//stack.printStack();

	}
	
	public static boolean isPalindrome(String string) {
		
		String s = string.replaceAll("[^a-zA-Z]", "").toLowerCase();
		
		char[] chars = s.toCharArray();
		
		LinkedList<Character> stack = new LinkedList<>();
		
		for (char c: chars) {
			stack.push(c);
		}
		
		for (char c: chars) {
			if (stack.peek() == c) {
				stack.pop();
			}
		}
		
		return stack.size() == 0;
		
		
		
	
		
		
		
		
		
		
		
	}
	
}
	
	
	

