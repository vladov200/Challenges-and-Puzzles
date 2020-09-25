package main.java.numbers;

public class MedianSortedArrays {

	/**
	 * Given two sorted arrays of size m and n, return the median of the
	 * two sorted arrays.
	 * <p>
	 * 
	 * Method traverses both arrays at the same time until the midpoint 
	 * is reached. During traversal, a placeholder array is kept 
	 * up-to-date with the correct values.
	 * <p>
	 * 
	 * Once the midpoint is reached, the median is calculated using the
	 * placeholder array and the sum of the lengths of both arrays.
	 * <p>
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int p1 = 0;
		int p2 = 0;

		int[] placeholder = new int[2];

		int loopUpperLimit = ((nums1.length + nums2.length) / 2) + 1;
		int actionPointer = 0;
		for(int i = 0; i < loopUpperLimit; i++) {
			if(p1 >= nums1.length) {
				actionPointer = 2;
			} else if(p2 >= nums2.length) {
				actionPointer = 1;
			} else {
				if(nums1[p1] < nums2[p2]) {
					actionPointer = 1;
				} else {
					actionPointer = 2;
				}
			}

			if(actionPointer == 1) {
				placeholder[0] = placeholder[1];
				placeholder[1] = nums1[p1];
				p1 += 1;
			} else {
				placeholder[0] = placeholder[1];
				placeholder[1] = nums2[p2];
				p2 +=1;
			}
		}

		if((nums1.length + nums2.length) % 2 == 0) {
			return ((double) (placeholder[0] + placeholder[1])) / 2;
		} else {
			return (double) placeholder[1];
		}
	}
	
	/**
	 * Given two sorted arrays of size m and n, return the median of the
	 * two sorted arrays.
	 * <p>
	 * 
	 * This method finds the median by keeping track of two pointers and
	 * taking action based on the numbers found on the left side and the
	 * right side. 
	 * <p>
	 * 
	 * At all times, the sum of elements up to the pointers is equal to
	 * the sum of elements of both arrays divided by two.
	 * <p>
	 * 
	 * If the number to the left of the first array pointer is less 
	 * than the number to the right of the second array pointer AND the 
	 * number to the left of the second array pointer is less than the 
	 * number to the right of the first array pointer, the median area 
	 * has been found.
	 * <p>
	 * 
	 * Afterwards, depending on the sum of the length of the arrays, 
	 * calculate the median and return. 
	 * <p>
	 * 
	 * If the sum of lengths is even, return max(left number first 
	 * array pointer, left number second array pointer) + min(left 
	 * number first array pointer, left number second array pointer)/2
	 * <p>
	 * 
	 * If the sum of lengths is odd, return max(left number first 
	 * array pointer, left number second array pointer).
	 * <p>
	 * 
	 * This is a pretty complicated algorithm but the attached youtube
	 * video does a nice job explaining it.
	 * <p>
	 * 
	 * https://www.youtube.com/watch?v=LPFhl65R7ww
	 * <p>
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArraysOptimized(int[] nums1, int[] nums2) {
		int totalPartitionLength = ((nums1.length + nums2.length) + 1) / 2;
		
		if(nums1.length == 0 && nums2.length == 0) {
			return 0.0;
		}
		
		if(nums1.length < nums2.length) {
			return findMedianSortedArraysOptimizedRecurse(nums1, nums2, totalPartitionLength, nums1.length / 2);
		} else {
			return findMedianSortedArraysOptimizedRecurse(nums2, nums1, totalPartitionLength, nums2.length / 2);
		}
	}
	
	private static double findMedianSortedArraysOptimizedRecurse(int[] nums1, int[] nums2, int totalPartitionLength, int nums1PartitionIndex) {
		int nums1Left = (nums1PartitionIndex <= 0) ? Integer.MIN_VALUE : nums1[nums1PartitionIndex - 1];
		int nums1Right = (nums1PartitionIndex == nums1.length) ? Integer.MAX_VALUE : nums1[nums1PartitionIndex];
		
		int nums2PartitionIndex = totalPartitionLength - nums1PartitionIndex;
		int nums2Left = (nums2PartitionIndex <= 0) ? Integer.MIN_VALUE : nums2[nums2PartitionIndex - 1];
		int nums2Right = (nums2PartitionIndex == nums2.length) ? Integer.MAX_VALUE : nums2[nums2PartitionIndex];
		
		if(nums1Left <= nums2Right && nums2Left <= nums1Right) {
			if((nums1.length + nums2.length) % 2 == 0) {
				return ((double) (Math.max(nums1Left, nums2Left) + 
						Math.min(nums1Right, nums2Right))) / 2;
			} else {
				return (double) Math.max(nums1Left, nums2Left);
			}
		} else if(nums1Left < nums2Right) {
			return findMedianSortedArraysOptimizedRecurse(nums1, nums2, totalPartitionLength, nums1PartitionIndex + 1);
		} else {
			return findMedianSortedArraysOptimizedRecurse(nums1, nums2, totalPartitionLength, nums1PartitionIndex - 1);
		}
	}
}
