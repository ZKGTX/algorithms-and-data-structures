package com.zerokikr.tutorial.leetcode;

//LeetCode 733. Flood Fill

public class LeetCode733 {	
	/* 					    	
	 * 	int [][] image = [[1,1,1],  <- 0 row
                          [1,1,0],  <- 1 row
                          [1,0,1]]; <- 2 row
                           ^ ^ ^
                           | | |
        				   0 1 2
        				   column
        
        
        int [][] output = [[2,2,2],
        				   [2,2,0],
        				   [2,0,2]];
      */  
	
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	if (image[sr][sc] == newColor) {
		return image;
	}
	fill(image, sr, sc, image[sr][sc], newColor);
	return image;
	
	
}

public void fill (int[][] image, int sr, int sc, int currentColor, int newColor) {
	if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image [sr] [sc] != currentColor) {
		return;
	}
	image[sr][sc] = newColor;
	fill (image, sr-1, sc, currentColor, newColor);
	fill (image, sr+1, sc, currentColor, newColor);
	fill (image, sr, sc-1, currentColor, newColor);
	fill (image, sr, sc+1, currentColor, newColor);

}
}
           
	
        
        
	
	
    


