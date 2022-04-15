package com.zerokikr.tutorial.leetcode;

public class LeetCode977 {
	
	public static void main(String[] args) {
		
	}
	
	public static int[] squaredSortedArray (int[] nums) {
		
		int[] squared = new int[nums.length];
		
		int left = 0;
		int right = nums.length - 1;
		
		for(int i = nums.length - 1; i >= 0; i--) {
			
			if (Math.abs(nums[left]) < Math.abs(nums[right])) {
				squared [i] = nums[right] * nums[right];
				right--;
			}
			else {
				squared [i] = nums[left] * nums[left];
				left++;
			}
			
		}
		
		return squared;
	}

}
