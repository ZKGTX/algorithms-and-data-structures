package com.zerokikr.tutorial.leetcode;

// LeetCode53. Maximum subarray (Kadane's algorithm)

public class LeetCode53 {
	
	public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = maxSum;
        
        for (int i = 1; i < nums.length; i++) {
        	currentSum = Math.max(currentSum + nums[i], nums[i]);
        	maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
