package com.zerokikr.tutorial.arrays;

public class ShellSort {

	// shellSort is a variation of insertionSort
	public static void shellSort(int[] array) { // in-place, unstable, O (time complexity) depends on gap (in worst case O(n2))										

		for (int gap = array.length / 2; gap > 0; gap = gap / 2) {

			for (int i = gap; i < array.length; i++) {

				int newElement = array[i];

				int j = i;

				while (j >= gap && array[j - gap] > newElement) {
					array[j] = array[j - gap];
					j = j - gap;
				}
				array[j] = newElement;
			}
		}
	}

}
