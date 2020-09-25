package main.java.utils;

import java.util.List;

public class Utils {

	public static void printList(List<int[]> list) {
		list.forEach(array -> printArray(array));
	}
	
	public static void printArray(int[] array) {
		System.out.print("[");
		for(int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		
		if(array.length > 0) {
			System.out.print(array[array.length - 1]);			
		} 
		
		System.out.println("]");
	}
	
	/**
	 * Swap value at sourceIndex with value at destinationIndex.
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void swapElements(int[] array, int sourceIndex, int destinationIndex) {
		if(sourceIndex == destinationIndex) {
			return;
		}
		
		array[sourceIndex] = array[sourceIndex] ^ array[destinationIndex];
		array[destinationIndex] = array[sourceIndex] ^ array[destinationIndex];
		array[sourceIndex] = array[sourceIndex] ^ array[destinationIndex];
	}
	
	/**
	 * Swap value at sourceIndex with value at destinationIndex.
	 * 
	 * @param list
	 * @param sourceIndex
	 * @param destinaitonIndex
	 */
	public static void swapListElements(List<int[]> list, int sourceIndex, int destinaitonIndex) {
		if(sourceIndex == destinaitonIndex) {
			return;
		}
		
		int[] tmpArray = list.get(sourceIndex);
		list.set(sourceIndex, list.get(destinaitonIndex));
		list.set(destinaitonIndex, tmpArray);
	}
	
	/**
	 * Remove element located at index from the array.
	 * <p>
	 * 
	 * This operation create a new array in the process.
	 * <p>
	 * 
	 * @param array
	 * @param index
	 * @return
	 */
	public static int[] removeElementAtIndex(int[] array, int index) {
		if(index < 0 || index >= array.length) {
			return array;
		}
		
		int[] result = new int[array.length - 1];
		System.arraycopy(array, 0, result, 0, index);
		System.arraycopy(array, index + 1, result, index, result.length - index);
		return result;
	}
}
