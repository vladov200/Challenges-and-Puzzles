package test.java.numbers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.numbers.ContainerWithWater;

public class ContainerWithWaterTest {

	@Test
	public void shouldReturnCorrectValue() {
		int[] heights = {1,8,6,2,5,4,8,3,7};

		int expected = 49;
		int actual = ContainerWithWater.findMaxAreaOptimized(heights);

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnCorrectValueLongArray() {
		int[] heights = {9,4,5,1,2,3,6,5,4,2,1,0,2,1,7,4,5,1,6,3,2,5,4,1,2,5,8,5,3,2,6,5,5,4,4,1,5,8};

		int expected = 296;
		int actual = ContainerWithWater.findMaxAreaOptimized(heights);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnZeroForOneElement() {
		int[] heights = {1};

		int expected = 0;
		int actual = ContainerWithWater.findMaxAreaOptimized(heights);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnZeroForEmptyElement() {
		int[] heights = {};

		int expected = 0;
		int actual = ContainerWithWater.findMaxAreaOptimized(heights);

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnCorrectValueForDuplicates() {
		int[] heights = {1,1,1};

		int expected = 2;
		int actual = ContainerWithWater.findMaxAreaOptimized(heights);

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnCorrectValueForNegatives() {
		int[] heights = {-1,1,1};

		int expected = 1;
		int actual = ContainerWithWater.findMaxAreaOptimized(heights);

		Assert.assertEquals(expected, actual);
	}
}
