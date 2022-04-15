package com.zerokikr.tutorial.leetcode;

/*
 * LeetCode 35. Search Insert Position
 * 
Given a sorted array of distinct integers and a target value,
return the index if the target is found.

If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.


*/

public class LeetCode35 {

	public static void main(String[] args) {
			
	}
	
	public static int searchInsertPosition (int[] nums, int target) {  // binary search (array is sorted!)
		
		int leftPointer = 0;
		int rightPointer = nums.length - 1;
		
		while (leftPointer <= rightPointer) {
			int midPointer = (leftPointer + rightPointer) / 2;
			int guess = nums[midPointer];
			if (guess == target) {
				return midPointer;
			}
			
			else if (guess > target) {
				rightPointer = midPointer - 1;
			}
			else {
				leftPointer = midPointer + 1;
			}
		}
		
		return leftPointer;
	}

}
