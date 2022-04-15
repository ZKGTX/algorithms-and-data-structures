package com.zerokikr.tutorial.arrays;

public class ArraysTutorial {

	public static void main(String[] args) {

		int[] array = { 12, -7, 15, 7, -18, 24, 6, 19, 15 };

		mergeSort(array, 0, array.length);

		for (int i : array) {
			System.out.println(i);
		}

	}

	public static void bubbleSort(int[] array) { // in-place, stable, very slow O(n2) quadratic
		for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			for (int i = 0; i < lastUnsortedIndex; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
				}
			}
		}
	}

	public static void selectionSort(int[] array) { // in-place, unstable, slow O(n2) quadratic, but fast if the array
													// is nearly sorted
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

	public static void insertionSort(int[] array) { // in-place, stable, very slow O(n2) quadratic

		for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {

			int newElement = array[firstUnsortedIndex];

			int i;

			for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
				array[i] = array[i - 1];
			}

			array[i] = newElement;
		}
	}

	// shellSort is a variation of insertionSort
	public static void shellSort(int[] array) { // in-place, unstable, O (time complexity) depends on gap (in worst case
												// O(n2))

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

	public static int iterativeFactorial(int number) {
		if (number == 0) {
			return 1;
		}

		int factorial = 1;

		for (int i = 1; i <= number; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}

	// 1! = 1 * 0! = 1
	// 2! = 2 * 1 = 2 * 1!
	// 3! = 3 * 2 * 1 = 3 * 2!
	// 4! = 4 * 3 * 2 * 1 = 4 * 3!
	// 5! = 5 * 4 * 3 * 2 * 1 = 5 * 4!

	// n! = n * (n - 1)!

	public static int recursiveFactorial(int number) {

		if (number == 0) {
			return 1;
		}

		return number * recursiveFactorial(number - 1); // at this point recursiveFctorial (number) gets pushed to call
														// stack and recursiveFactorial(number - 1) is called
	}

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

		if (array[mid - 1] >= array[mid]) { // array[mid - 1] is the last element in the left partition,
											// array[mid] is the first element in the right partition,
											// both partitions are sorted by this point
			return;
		}

		int i = start;
		int j = mid;
		int tempIndex = 0;

		int[] tempArray = new int[end - start];

		while (i < mid && j < end) {
			tempArray[tempIndex++] = array[i] >= array[j] ? array[i++] : array[j++];
		}

		System.arraycopy(array, i, array, start + tempIndex, mid - i);
		System.arraycopy(tempArray, 0, array, start, tempIndex);
	}

	// DIVIDE AND CONQUER approach
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

	public static int partition(int[] array, int start, int end) {
		// This is using the first element of the array as the pivot

		int pivot = array[start];

		int i = start; // will traverse array from left to right
		int j = end; // will traverse array from right to left

		while (i < j) {

			// NOTE: EMPTY LOOP BODY
			while (i < j && array[--j] >= pivot); // decrement first, then use as index or will get IndexOutOfBoundException
				

			if (i < j) {
				array[i] = array[j];
			}

			// NOTE: EMPTY LOOP BODY
			while (i < j && array[++i] <= pivot); // decrement first, then use as index or will step outside the sub-array when traversing
			
				

			if (i < j) {
				array[j] = array[i];
			}
		}

		array[j] = pivot;
		return j;

	}
	
	public static void countingSort (int[] array, int min, int max) { // works when length of the array is nearly equal to range of values of elements(values from 1 to 20 and length is 20)
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
	
	public static void radixSort (int[] array, int radix, int width) {
		for (int i = 0; i < width; i++) {
			radixSingleSort(array, i, radix);
		}
		
	}
	
	public static void radixSingleSort (int[] array, int position, int radix) {
		
		int numItems = array.length;
		int[] countArray = new int[radix];
		
		
		for (int value: array) {
			countArray[getDigit(position, value, radix)]++;
		}
		
		// adjust the count array
		for (int j = 1; j < radix; j++) {
			countArray[j] += countArray[j - 1];
		}
		
		int[] temp = new int[numItems];
		
		for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
			temp[--countArray[getDigit(position, array[tempIndex], radix)]] = array[tempIndex];
		}
		
		for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
			array[tempIndex] = temp[tempIndex];
		}
		
	}
	
	public static int getDigit (int position, int value, int radix) {
		return value / (int) Math.pow(radix, position) % radix;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
