package com.zerokikr.tutorial.arrays;

public class CountingSort {

	public static void countingSort(int[] array, int min, int max) { 
		// works when length of the array is nearly equal
		// to range of values of elements(values from 1
		// to 20 and length is 20)
		// can achieve linear time O(1)
		// need to know min and max value of elements in array to use this sort
		
		int[] countArray = new int[(max - min) + 1];

		for (int i = 0; i < array.length; i++) {
			countArray[array[i] - min]++;
		}

		int j = 0;
		for (int i = min; i <= max; i++) {
			while (countArray[i - min] > 0) {
				array[j++] = i;
				countArray[i - min]--;
			}
		}
	}

}
