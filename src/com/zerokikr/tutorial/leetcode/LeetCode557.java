package com.zerokikr.tutorial.leetcode;

//LeetCode557. Reverse Words in a String III

public class LeetCode557 {
	
	public static void main(String[] args) {
		System.out.println(reverseWords("HELLO WORLD AND KISS MY ASS"));
	}
	
	    public static String reverseWords(String s) {
	    	String[] words = s.split(" ");
	    	for (int i = 0; i < words.length; i++) {
	    		words [i] = new StringBuilder(words[i]).reverse().toString();
	    	}
	    	return String.join(" ", words);
	        
	    }
	
}
