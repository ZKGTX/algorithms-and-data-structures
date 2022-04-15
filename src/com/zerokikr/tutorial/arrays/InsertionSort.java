package com.zerokikr.tutorial.arrays;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		int [] array = {4, -6, 8, 7, 22, -25, 10};
		
		recursiveInsertionSort(array, array.length);
		
		for (int i: array) {
			System.out.println(i);
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
	
	public static void recursiveInsertionSort (int[] array, int n) {
		
		if (n < 2) { // break condition / base case
			return;
		}
		
		recursiveInsertionSort(array, n - 1); // first, let's sort first (n - 1) elements of array 
		
		int element = array [n - 1]; // pick the current element of array
		
		int i;
		
		for (i = n - 1; i > 0 && array [i - 1] > element; i--) { // pick previous item and compare it to the element
			array[i] = array[i - 1]; 							 // if the previous item is bigger than element replace current item with previous item  
		}
		
		array[i] = element; 
		
		System.out.println("Result of call when n = " + n);
		
		for (i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			System.out.print(", ");
		}
		
		System.out.println("");
		System.out.println("------------------------------");
	}
	
	
	public static void anotherRecursiveInsertionSort (int[] array, int n) { // n = array.length
		if (n <= 1) {
			return;
		}
		
		anotherRecursiveInsertionSort(array, n - 1); // last index of array is array.length - 1
		
		int element = array [n - 1];
		
		int position = n - 2;
		
		while (position >=0 && array[position] > element) {
			array[position + 1] = array [position];
			position -= 1;
		}
		
		array [position + 1] = element;
		
	}  

}
