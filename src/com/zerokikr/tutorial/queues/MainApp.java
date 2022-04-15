package com.zerokikr.tutorial.queues;

import java.util.LinkedList;

public class MainApp {
	
	public static void main(String[] args) {
		
		System.out.println(isPalindromeQ("I did, did I?"));
		System.out.println(isPalindromeQ("Racecar"));
		System.out.println(isPalindromeQ("hello"));
		
		Employee vasiliyPalkin = new Employee ("Vasiliy", "Palkin", 1234);
		Employee petrKonev = new Employee ("Petr", "Konev", 9876);
		Employee borisBritva = new Employee ("Boris", "Britva", 5678);
		Employee stepanRazin = new Employee ("Stepan", "Razin", 9157);
		
		
		ArrayQueue q = new  ArrayQueue(3); 
		q.add(vasiliyPalkin);
		q.add(petrKonev);
		q.add(borisBritva);
		q.add(stepanRazin);
		
		
		q.remove();
		q.remove();
		q.remove();
		q.remove();
		
		q.add(vasiliyPalkin);
		q.add(petrKonev);
		q.add(borisBritva);
		q.add(stepanRazin);
		
		//printQ();
			
	}
	
	public static boolean isPalindromeQ(String string) {
		
		String s = string.replaceAll("[^a-zA-Z]", "").toLowerCase();
		
		char[] chars = s.toCharArray();
		
		LinkedList<Character> stack = new LinkedList<>();
		
		LinkedList<Character> queue = new LinkedList<>();
		
		for (char c : chars) {
			stack.push(c);
			queue.add(c);
		}
		
		for (char c : chars) {
			if (stack.peek() == queue.peek()) {
				stack.pop();
				queue.poll();
			}
		}
		
		return queue.size() == 0;
	}
	
	public static boolean isPalindromeX(String string) {
		
		LinkedList<Character> stack = new LinkedList<>();
		
		LinkedList<Character> queue = new LinkedList<>();
		
		String lowerCase = string.toLowerCase();
		
		for (int i = 0; i < lowerCase.length(); i++) {
			char c = lowerCase.charAt(i);
			if (c >= 'a' && c <= 'z') {
				queue.addLast(c);
				stack.push(c);
			}
			
		}
		
		while (!stack.isEmpty()) {
			
			if (!stack.pop().equals(queue.removeFirst()))
				
				return false;
		}
		
		return true;
	}

}
