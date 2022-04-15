package com.zerokikr.tutorial.heaps;

import java.util.PriorityQueue;

public class MainApp2 {
	
	
	public static void main(String[] args) {
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // JDK implementation of PriorityQueue is using Min Heap
		
		pq.add(25);
		pq.add(-22);
		pq.add(10);
		pq.add(34);
		pq.add(0);
		pq.add(-3243);
		pq.add(567);
		pq.add(89);
		
		System.out.println(pq.peek()); // this will peek() at -3243 because it's a min heap and so the least value is at the root and has the priority
		System.out.println(pq.remove());
		System.out.println(pq.peek());
	}
	
}
