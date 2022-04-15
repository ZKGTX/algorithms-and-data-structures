package com.zerokikr.tutorial.trees;

public class Tree { // this implementation doesn't allow duplicates
	
	private TreeNode root; 
	
	public void insert(int value) {
		if (root == null) {
			root = new TreeNode(value);
		}
		else {
			root.insert(value);
		}
	}
	
	public void traverseInOrder () {
		if (root != null) {
			root.traverseInOrder();
		}
	}
	
	public void traversePreOrder () {
		if (root != null) {
			root.traversePreOrder();
		}
	}
	
	public TreeNode get(int value) {
		if (root != null) {
			return root.get(value);
		}
		
		return null;
	}
	
	public void delete (int value) {
		
		root = delete(root, value);
	}
	
	private TreeNode delete (TreeNode subtreeRoot, int value) { // returns the replacement node for the one that's being deleted.
																// If it doesn't need to be replaced you just get the node back.
		if (subtreeRoot == null) {
			return subtreeRoot;
		}
		
			if (value < subtreeRoot.getData()) {
				
				subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
			}
			
			else if (value > subtreeRoot.getData()) {
				
				subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
			}
			
			else {
				
				// cases 1 and 2: node to delete has 0 or 1 children
				
				if (subtreeRoot.getLeftChild() == null) {
					return subtreeRoot.getRightChild();
				}
				
				else if (subtreeRoot.getRightChild() == null) {
					return subtreeRoot.getLeftChild();
				}
				
				// case 3: node to delete has 2 children
				
				// replace the value in the subtreeRoot node with the largest value in the left subtree
				subtreeRoot.setData(subtreeRoot.getLeftChild().max());
				
				// delete the node that has the largest value in the left subtree
				subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), subtreeRoot.getData()));
				
			}
			
			return subtreeRoot;
	}  
	
	public int min () {
		
		if (root == null) {
			return Integer.MIN_VALUE; // if the tree is empty return the smallest possible value
		}
		
		else {
			return root.min();
		}
	}
	
	public int max() {
		
		if (root == null) {
			return Integer.MAX_VALUE; // if the tree is empty return the largest possible value
		}
		
		else {
			return root.max();
		}
	}
	
	
	

}