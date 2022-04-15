package com.zerokikr.tutorial.leetcode;

//LeeyCode88. Merge Sorted Array

public class LeetCode88 {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int i = m + n - 1;
        
        while (pointer2 >= 0) {
        	if (pointer1 >= 0 && nums1[pointer1] > nums2[pointer2]) {
        		nums1[i] = nums1[pointer1];
        		i--;
        		pointer1--;
        	} else {
        		nums1[i] = nums2[pointer2];
        		i--;
        		pointer2--;
        	}
        }
        
        
        
    }
}
