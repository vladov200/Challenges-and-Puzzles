package test.java.numbers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


import main.java.numbers.MedianSortedArrays;

public class MedianSortedArraysTest {

	@Test
	public void shouldReturnCorrectValue() {
		int[] nums1 = {1,3,5,7};
		int[] nums2 = {2,4,6,8};
		
		double expected = 4.5;
		double actual = MedianSortedArrays.findMedianSortedArraysOptimized(nums1, nums2);
		
		Assert.assertEquals(expected, actual, 0);
	}
	
	@Test
	public void shouldReturnCorrectValueForEmptyArrayOne() {
		int[] nums1 = {1,3,5,7};
		int[] nums2 = {};
		
		double expected = 4.0;
		double actual = MedianSortedArrays.findMedianSortedArraysOptimized(nums1, nums2);
		
		Assert.assertEquals(expected, actual, 0);
	}
	
	@Test
	public void shouldReturnCorrectValueForEmptyArrayTwo() {
		int[] nums1 = {};
		int[] nums2 = {1,3,5,7};
		
		double expected = 4.0;
		double actual = MedianSortedArrays.findMedianSortedArraysOptimized(nums1, nums2);
		
		Assert.assertEquals(expected, actual, 0);
	}
	
	@Test
	public void shouldReturnCorrectValueForTwoEmptyArrays() {
		int[] nums1 = {};
		int[] nums2 = {};
		
		double expected = 0.0;
		double actual = MedianSortedArrays.findMedianSortedArraysOptimized(nums1, nums2);
		
		Assert.assertEquals(expected, actual, 0);
	}
	
	@Test
	public void shouldReturnCorrectValueForCombinedLengthOne() {
		int[] nums1 = {1};
		int[] nums2 = {};
		
		double expected = 1.0;
		double actual = MedianSortedArrays.findMedianSortedArraysOptimized(nums1, nums2);
		
		Assert.assertEquals(expected, actual, 0);
	}
	
	@Test
	public void shouldReturnCorrectValueForCombinedLengthTwo() {
		int[] nums1 = {1};
		int[] nums2 = {5};
		
		double expected = 3.0;
		double actual = MedianSortedArrays.findMedianSortedArraysOptimized(nums1, nums2);
		
		Assert.assertEquals(expected, actual, 0);
	}
	
	@Test
	public void shouldReturnCorrectValueForCombinedLengthThree() {
		int[] nums1 = {1};
		int[] nums2 = {2,3};
		
		double expected = 2.0;
		double actual = MedianSortedArrays.findMedianSortedArraysOptimized(nums1, nums2);
		
		Assert.assertEquals(expected, actual, 0);
	}
}
