package com.zerokikr.tutorial.heaps;


public class Heap { // Max heap
	
	private int[] heap;
	private int size;
	
	public Heap (int capacity) {
		heap = new int[capacity];
	}
	
	public void insert (int value) {
		
		if (isFull()) {
			
			throw new IndexOutOfBoundsException("Heap is full");
		}
		
		heap[size] = value; 
		
		fixHeapAbove(size);
		
		size++; // size is incremented after the value is added	
		
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("heap is empty");
		}
		
		else {
			return heap[0];
		}
	}
	
	public int delete (int index) { //you always want to take the root off the heap
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Heap is empty");
		}
		
		int parent = getParent(index); // we get the parent of the value we delete to compare it with the replacement 
		
		int deletedValue = heap[index]; // we save the value we delete to return it at the end of the method
		
		heap[index] = heap[size - 1]; // we replace the deleted value. The replacement is always the rightmost node in the heap. [size - 1] when backed by an array.
		
		if (index == 0 || heap[index] < heap[parent]) { // if we delete the root or if the replacement value is less than its parent we need to fix the heap below the index we delete
			fixHeapBelow(index, size - 1);
		} 
		
		else {
			fixHeapAbove(index);
		}
		
		size--;
		
		return deletedValue;
	}
	
	private void fixHeapAbove (int index) { // "heapify", we travel up the tree comparing the value we inserted to its parents and if parent value is less than value we insert, we switch them
		
		int newValue = heap[index]; // this is the index of a value that we just inserted
		
		while (index > 0 && newValue > heap[getParent(index)]) {
			heap[index] = heap[getParent(index)];
			index = getParent(index);
		}
		
		heap[index] = newValue;
	}
	
	private void fixHeapBelow (int index, int lastHeapIndex) {
		
		int childToSwap;
		
		while (index <= lastHeapIndex) { // as long as the index we're looking at is a part of the heap
										
			int leftChild = getChild(index, true);
														// we get two children
			int rightChild = getChild(index, false);
		
			// we then check if these children are part of the heap
			if (leftChild <= lastHeapIndex) { // this means that there is a left child
				// so we check if there is also a right child
				if (rightChild > lastHeapIndex) { // this means that there is no right child (as it goes beyond the array)
					childToSwap = leftChild;
				}
				else {
					childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild); // if there are two children we need to select the child with the greatest value
				}
				
				
				int tmp = heap[index]; // then compare the value of index with the value of previously selected child
				
				if (heap[index] < heap[childToSwap]) { // if the index value is less than child value we swap
					heap[index] = heap[childToSwap];
					heap[childToSwap] = tmp;
				}
				
				else { // if the index value is larger than child value we break the loop 
					break;
				}
				
				index = childToSwap; // we now have to compare the replaced value with its new children so we update index and loop back around
			}
			
			else { // if the children are not a part of the heap than we're done 	
				break;
			}
				
		}
	}
	
	public void printHeap () {
		for (int i = 0; i < size; i++) {
			System.out.print(heap[i]);
			System.out.print(", ");
		}
		System.out.println();
	}
	
	public boolean isFull () {
		return size == heap.length;
	}
	
	public boolean isEmpty () {
		return size == 0;
	}
	
	
	public int getParent (int index) {
		return (index - 1) / 2;  // rounds down automatically to the lowest whole number when using integers
	}
	
	public int getChild (int index, boolean left) {
		return 2 * index + (left ? 1 : 2);
	}
	
	
	

}
