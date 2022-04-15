package com.zerokikr.tutorial.arrays;

public class MergeSort {

	// DIVIDE AND CONQUER approach
	public static void mergeSort(int[] array, int start, int end) { // NOT in-place, stable, O (nlogn) base 2

		if (end - start < 2) {
			return;
		}

		int mid = (start + end) / 2;

		mergeSort(array, start, mid);

		mergeSort(array, mid, end);

		merge(array, start, mid, end);

	}

	public static void merge(int[] array, int start, int mid, int end) {

		if (array[mid - 1] <= array[mid]) { // array[mid - 1] is the last element in the left partition,
											// array[mid] is the first element in the right partition,
											// both partitions are sorted by this point
			return;
		}

		int i = start;
		int j = mid;
		int tempIndex = 0;

		int[] tempArray = new int[end - start];

		while (i < mid && j < end) {
			tempArray[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
		}

		System.arraycopy(array, i, array, start + tempIndex, mid - i);
		System.arraycopy(tempArray, 0, array, start, tempIndex);
	}

}
