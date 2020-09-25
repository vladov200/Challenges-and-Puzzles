package test.java.utils;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.utils.Utils;

public class UtilsTest {

	@Test
	public void shouldSwapVariablesOnce() {
		int[] array = {10, 20};
		int[] expected = {20, 10};
		
		Utils.swapElements(array, 0, 1);
		
		Assert.assertArrayEquals(expected, array);
	}
	
	@Test
	public void shouldSwapListVariablesOnce() {
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] {10, 20});
		list.add(new int[] {30, 40});
		
		ArrayList<int[]> expected = new ArrayList<>();
		expected.add(new int[] {30, 40});
		expected.add(new int[] {10, 20});
		
		Utils.swapListElements(list, 0, 1);
		
		Assert.assertArrayEquals(expected.toArray(), list.toArray());
	}
	
	@Test
	public void shouldSwapVariablesSelf() {
		int[] array = {10, 20};
		int[] expected = {10, 20};
		
		Utils.swapElements(array, 0, 0);
		
		Assert.assertArrayEquals(expected, array);
	}
	
	@Test
	public void shouldSwapListVariablesSelf() {
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] {10, 20});
		list.add(new int[] {30, 40});
		
		ArrayList<int[]> expected = new ArrayList<>();
		expected.add(new int[] {10, 20});
		expected.add(new int[] {30, 40});
		
		Utils.swapListElements(list, 0, 0);
		
		Assert.assertArrayEquals(expected.toArray(), list.toArray());
	}
	
	@Test
	public void shouldSwapVariablesMultiple() {
		int[] array = {0, 1, 2, 3, 4};
		int[] expectedOne = {1, 0, 2, 3, 4};
		int[] expectedTwo = {1, 0, 2, 4, 3};
		int[] expectedThree = {4, 0, 2, 1, 3};
		
		Utils.swapElements(array, 0, 1);
		Assert.assertArrayEquals(expectedOne, array);
		
		Utils.swapElements(array, 3, 4);
		Assert.assertArrayEquals(expectedTwo, array);

		Utils.swapElements(array, 0, 3);
		Assert.assertArrayEquals(expectedThree, array);
	}
	
	@Test
	public void shouldSwapListVariablesMultiple() {
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] {10, 20});
		list.add(new int[] {30, 40});
		list.add(new int[] {50, 60});
		list.add(new int[] {70, 80});
		
		ArrayList<int[]> expectedOne = new ArrayList<>();
		expectedOne.add(new int[] {30, 40});
		expectedOne.add(new int[] {10, 20});
		expectedOne.add(new int[] {50, 60});
		expectedOne.add(new int[] {70, 80});
		
		ArrayList<int[]> expectedTwo = new ArrayList<>();
		expectedTwo.add(new int[] {30, 40});
		expectedTwo.add(new int[] {10, 20});
		expectedTwo.add(new int[] {70, 80});
		expectedTwo.add(new int[] {50, 60});
		
		ArrayList<int[]> expectedThree = new ArrayList<>();
		expectedThree.add(new int[] {50, 60});
		expectedThree.add(new int[] {10, 20});
		expectedThree.add(new int[] {70, 80});
		expectedThree.add(new int[] {30, 40});
		
		Utils.swapListElements(list, 0, 1);
		Assert.assertArrayEquals(expectedOne.toArray(), list.toArray());
		
		Utils.swapListElements(list, 2, 3);
		Assert.assertArrayEquals(expectedTwo.toArray(), list.toArray());

		Utils.swapListElements(list, 0, 3);
		Assert.assertArrayEquals(expectedThree.toArray(), list.toArray());
	}
	
	@Test
	public void shouldThrowExceptionOnIndexOutOfBounds() {
		int[] array = {0, 1, 2, 3, 4};
		
		try {
			Utils.swapElements(array, 0, 100);
			Assert.fail("Method should have failed with ArrayIndexOutOfBoundsException");
		} catch(Exception ex) {
			Assert.assertEquals("Index 100 out of bounds for length 5", ex.getMessage());
		}
	}
	
	@Test
	public void shouldThrowListExceptionOnIndexOutOfBounds() {
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] {10, 20});
		list.add(new int[] {30, 40});
		
		try {
			Utils.swapListElements(list, 0, 100);
			Assert.fail("Method should have failed with ArrayIndexOutOfBoundsException");
		} catch(Exception ex) {
			Assert.assertEquals("Index 100 out of bounds for length 2", ex.getMessage());
		}
	}
	
	@Test
	public void shouldRemoveElement() {
		int[] array = {0, 1, 2, 3, 4};
		int index = 2;
		
		int[] expected = {0, 1, 3, 4};
		int[] actual = Utils.removeElementAtIndex(array, index);
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnSame() {
		int[] array = {0, 1, 2, 3, 4};
		int index = -1;
		
		int[] actualOutOfBoundsNegative = Utils.removeElementAtIndex(array, index);
		Assert.assertArrayEquals(array, actualOutOfBoundsNegative);
		
		index = 100;
		
		int[] actualOutOfBoundsPositive = Utils.removeElementAtIndex(array, index);
		Assert.assertArrayEquals(array, actualOutOfBoundsPositive);
	}
}
