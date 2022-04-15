package com.zerokikr.tutorial.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Dell { // [7, 2, 1, 20] = 72201
	
	public static void main(String[] args) {
		
		int[] array = {54, 546, 548, 60};
		
		System.out.println(maxNumber(array));
		
	}
	
	public static String maxNumber (int [] array) {
		
		Integer[] nums = new Integer[array.length];
		
		for (int i = 0; i < array.length; i++) {
			nums[i] = array[i];
		}
		
		Arrays.sort(nums, new Comparator <Integer>() {
			
			public int compare (Integer a, Integer b) {
				
				String s1 = a.toString();
				String s2 = b.toString();
				
				return (s2 + s1).compareTo(s1 + s2);
			}
			
		}); 
		
		String result = "";
		
		for (Integer j : nums) {
			result += j;
		}
		
		return result;
	}
	
	
	
	
	
	

}
