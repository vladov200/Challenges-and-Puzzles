package main.java.strings;

import java.util.HashSet;

public class LongestSubstringNoRepeat {

	/**
	 * Find the length of the longest substring in a string.
	 * <p>
	 * 
	 * Add characters to a hash set if and only if they were
	 * not previously present.
	 * <p>
	 * 
	 * If a duplicate character is encountered, take note
	 * of the size of the set and clear.
	 * <p>
	 * 
	 * Repeat for each character in the string.
	 * <p>
	 * 
	 * Please note, upper case and lower case characters are
	 * considered to be different characters.
	 * 
	 * Time complexity: O(1) * O(n)
	 * 	Checking hash set for character is O(1)
	 * 	Looping through all characters is  O(n)
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		if(s == null) {
			return 0;
		}
		
		int substringLength = 0;
		HashSet<Character> bagOfChars = new HashSet<>();
		
		for(Character character : s.toCharArray()) {
			if(bagOfChars.contains(character)) {
				if(bagOfChars.size() > substringLength) {
					substringLength = bagOfChars.size();
				}
				
				bagOfChars.clear();
			}
			
			bagOfChars.add(character);
		}
		
		return substringLength;
	}
}
