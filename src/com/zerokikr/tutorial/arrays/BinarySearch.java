package com.zerokikr.tutorial.arrays;

public class BinarySearch {
	
	public static void main(String[] args) {
		
		int[] array = {-50, - 13, 2, 7, 16, 22, 56, 89};
	
	}
	
	public static int iterativeBinarySearch(int[] array, int value) {
		
		int start = 0;
		int end = array.length;
		
		while (start < end) {
			
			int mid = start + (end - start) / 2;
			
			if (array[mid] == value) {
				return mid;
			}
			
			else if (array [mid] < value) {
				start = mid + 1;
			}
			
			else {
				end = mid;
			}
		}
		
		return -1;
	}
	
	public static int recursiveBinarySearch (int [] array, int value) {
		
		return recursiveBinarySearch(array, 0, array.length, value);
		
	}
	
	public static int recursiveBinarySearch(int[] array, int start, int end, int value) {
		
		if (start >= end) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		
		if (array[mid] == value) {
			return mid;
		}
		
		else if (array[mid] < value) {
			return recursiveBinarySearch(array, mid + 1, end, value);
		}
		else {
			return recursiveBinarySearch(array, start, mid, value);
		}
		
	}

}
