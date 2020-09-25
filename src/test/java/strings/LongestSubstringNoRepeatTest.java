package test.java.strings;

import org.junit.jupiter.api.Test;

import main.java.strings.LongestSubstringNoRepeat;

import org.junit.Assert;

public class LongestSubstringNoRepeatTest {

	@Test
	public void shouldReturnCorrectLength() {
		String testString0 = "abcabcdd";
		int expected0 = 4;
		
		int actual0 = LongestSubstringNoRepeat.lengthOfLongestSubstring(testString0);
		Assert.assertEquals(expected0, actual0);
		
		
		String testString1 = "dddddddd";
		int expected1 = 1;
		
		int actual1 = LongestSubstringNoRepeat.lengthOfLongestSubstring(testString1);
		Assert.assertEquals(expected1, actual1);
		
		
		String testString2 = "ppwwwkew";
		int expected2 = 3;
		
		int actual2 = LongestSubstringNoRepeat.lengthOfLongestSubstring(testString2);
		Assert.assertEquals(expected2, actual2);
		
		
		String testString3 = "jghw87 hgnbi 98!!";
		int expected3 = 9;
		
		int actual3 = LongestSubstringNoRepeat.lengthOfLongestSubstring(testString3);
		Assert.assertEquals(expected3, actual3);
	}
	
	@Test
	public void shouldReturnZeroForEmpty() {
		String testString = "";
		int expected = 0;
		
		int actual = LongestSubstringNoRepeat.lengthOfLongestSubstring(testString);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnZeroForNull() {
		String testString = null;
		int expected = 0;
		
		int actual = LongestSubstringNoRepeat.lengthOfLongestSubstring(testString);
		Assert.assertEquals(expected, actual);
	}
}
