package com.zerokikr.tutorial.leetcode;

import java.util.HashSet;

//leetCode217. Contains Duplicate


public class LeetCode217 {
	
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		
		for (Integer num: nums) {
			if (set.contains(num)) {
				return true;
			}
			set.add(num);
		}
		return false;
	}
}
