package com.zerokikr.tutorial.leetcode;


//LeetCode 189. Rotate Array

public class LeetCode189 {

    public void rotate(int[] nums, int k) {
        
        k = k % nums.length;
        reverse(0, nums, nums.length-1);
        reverse(0, nums, k-1);
        reverse(k, nums, nums.length-1);
        
		
    }
    public void reverse (int leftPointer, int[] nums, int rightPointer) {
        while (leftPointer < rightPointer) {
            int temp = nums[leftPointer];
            nums[leftPointer] = nums[rightPointer];
            nums[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
        
    }
    
}
