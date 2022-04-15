package com.zerokikr.tutorial.leetcode;

//LeetCode 695. Max Area of Island

public class LeetCode695 {
	
	boolean [][] seen;
	
public int maxAreaOfIsland(int[][] grid) {
	int maxCount = 0;
	int rows = grid.length;
	int columns = grid[0].length;
	
	seen = new boolean[rows][columns];
	
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < columns; j++) {
			maxCount = Math.max(maxCount, checkIsland(i, j, grid));
		}
	}
    	return maxCount;
    }

public int checkIsland (int row, int column, int[][] grid) {
	if (row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || seen[row][column] || grid[row][column] == 0) {
		return 0;
	}
	
	seen[row][column] = true;
	
	return (1 + checkIsland(row+1, column, grid) + checkIsland(row-1, column, grid) + checkIsland(row, column+1, grid) + checkIsland(row, column-1, grid));
}

}
















/*
 *int[][] grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *				  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *				  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *				  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *				  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *				  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *				  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *				  [0,0,0,0,0,0,0,1,1,0,0,0,0]]; 
 */