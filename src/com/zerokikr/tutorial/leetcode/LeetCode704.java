package com.zerokikr.tutorial.leetcode;

import com.zerokikr.tutorial.arrays.BinarySearch;

// Binary Search
public class LeetCode704 {
	
	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		System.out.println(binarySearch(nums, 7));
		
	}
	
	public static int binarySearch (int[] nums, int target) {
		
		int start = 0;
		int end = nums.length;
		
		while (start < end) {
			
			int mid = (start + end) / 2;
			
			if (nums[mid] == target) {
				return mid;
			}
			
			else if (nums[mid] > target) {
				end = mid;
			}
			
			else {
				start = mid + 1;
			}
		}
		
		return -1;
	}
	
}

