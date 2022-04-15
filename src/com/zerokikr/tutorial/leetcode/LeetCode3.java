package com.zerokikr.tutorial.leetcode;

import java.util.HashSet;

// LeetCode 3. Longest Substring Without Repeating Characters

public class LeetCode3 {
	
	public int lengthOfLongestSubstring(String s) {
			int aPointer = 0;
			int bPointer = 0;
			int maxCount = 0;
			
			HashSet<Character> hashSet = new HashSet<Character>();
			
			while (bPointer < s.length()) {
				if (!hashSet.contains(s.charAt(bPointer))) {
					hashSet.add(s.charAt(bPointer));
					bPointer++;
					maxCount = Math.max(maxCount, hashSet.size());
				}
				else {
					hashSet.remove(s.charAt(aPointer));
					aPointer++;
				}
				
				
			}
			return maxCount;
	}

}
