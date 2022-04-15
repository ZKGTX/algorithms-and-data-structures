package com.zerokikr.tutorial.arrays;

public class QuickSort {
	
	//DIVIDE AND CONQUER approach

	public static void quickSort(int[] array, int start, int end) { // in-place, unstable, O (nlogn) base 2, 
																	// in worst case quadratic O(n2),
																	// but in average case faster than mergeSort

		if (end - start < 2) { // this means that array.length = 1 (one element array is always sorted)
			return;
		}

		int pivotIndex = partition(array, start, end);
		
		quickSort(array, start, pivotIndex);
		quickSort(array, pivotIndex + 1, end);
		
		
	}
	
	public static int partition (int[] array, int start, int end) {
		//This is using the first element of the array as the pivot
		
		int pivot = array[start];
		
		int i = start; // will traverse array from left to right
		int j = end; // will traverse array from right to left
		
		while (i < j) {
			
			// NOTE: EMPTY LOOP BODY
			while (i < j && array [--j] >= pivot);  // decrement first, then use as index or will get IndexOutOfBoundException 
			
			if (i < j) {
				array[i] = array[j];
			}
			
			// NOTE: EMPTY LOOP BODY
			while (i < j && array[++i] <= pivot); //decrement first, then use as index or will step outside the sub-array when traversing
			
			if (i < j) {
				array[j] = array[i];
			}
		}
		
		array[j] = pivot;
		return j;
		
	}
	
	
	

}
