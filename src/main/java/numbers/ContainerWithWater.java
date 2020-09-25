package main.java.numbers;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a 
 * point at coordinate (i, ai). n vertical lines are drawn such that the 
 * two endpoints of line i is at (i, ai) and (i, 0). 
 * 
 * Find two lines, which together with x-axis forms a container, such that 
 * the container contains the most water.
 * 
 * https://leetcode.com/problems/container-with-most-water/
 *
 */
public class ContainerWithWater {

	/**
	 * Find the max area by calculating the area of each possible
	 * combination and maximizing the results.
	 * <p>
	 * 
	 * Brute force algorithm with a time complexity of O(n^2).
	 * <p>
	 * 
	 * Used to generate correct values for testing.
	 * <p>
	 * 
	 * @param heights
	 * @return
	 */
	public static int findMaxAreaBruteForce(int[] heights) {
		int maxArea = 0;
		for(int i = 0; i < heights.length; i++) {
			for(int j = i + 1; j < heights.length; j++) {
				int calculatedArea = Math.min(heights[i], heights[j]) * (j - i);
				
				if(calculatedArea > maxArea) {
					maxArea = calculatedArea;
				}
			}
		}
		
		return maxArea;
	}
	
	/**
	 * Find the max area by keeping track of two pointer on each
	 * side of the array and maximizing the results.
	 * <p>
	 * 
	 * The update pointer policy is quite simple: keep the larger
	 * element of the two pointers and update the other. 
	 * <p>
	 * 
	 * Time complexity of O(n) since we loop the array only once.
	 * <p>
	 * 
	 * @param heights
	 * @return
	 */
	public static int findMaxAreaOptimized(int[] heights) {
		int pLeft = 0;
		int pRight = heights.length - 1;
		
		int maxArea = 0;
		while(pLeft < pRight) {
			int calculatedArea = Math.min(heights[pLeft], heights[pRight]) * (pRight - pLeft);
			
			if(calculatedArea > maxArea) {
				maxArea = calculatedArea;
			}
			
			if(heights[pLeft] < heights[pRight]) {
				pLeft += 1;
			} else {
				pRight -= 1;
			}
		}
		
		return maxArea;
	}
}
