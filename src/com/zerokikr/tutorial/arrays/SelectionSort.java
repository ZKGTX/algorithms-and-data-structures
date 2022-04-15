package com.zerokikr.tutorial.arrays;

public class SelectionSort {

	public static void selectionSort(int[] array) { // in-place, unstable, slow O(n2) quadratic, 
													// but fast if the array is nearly sorted
		
		for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

			int largest = 0;
			for (int i = 0; i <= lastUnsortedIndex; i++) {
				if (array[i] > array[largest]) {
					largest = i;
				}
			}
			swap(array, largest, lastUnsortedIndex);
		}
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
