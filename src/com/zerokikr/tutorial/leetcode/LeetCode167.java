package com.zerokikr.tutorial.leetcode;


// Two Sum II
public class LeetCode167 {
	
	public static void main(String[] args) {
		
	}
	
	public int[] twoSum(int[] numbers, int target) {
        int [] result = new int[2];
        
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int mid = numbers[left] + numbers[right];
            if (mid == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
            else if (mid > target) {
                right--;
            }
            else {
                left++;
            }
            
        }
        result[0] = left + 1;
        result[1] = right + 1;
        return result;    
    }

}
