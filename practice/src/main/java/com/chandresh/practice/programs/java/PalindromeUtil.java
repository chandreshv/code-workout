package com.chandresh.practice.programs.java;

/**
 * Checks if a string is a palindrome.
 *
 * Palindrome is a word, phrase or sentence that reads the same backward or
 * forward. For example, the following string is a palindrome: "Madam, I'm Adam."
 */
public class PalindromeUtil {
	/**
	 * Checks whether passed String is a palindrome or not.
	 *
	 * Requirements:
	 * - Limit the amount of additional consumed memory to O(1).
	 * - Limit complexity to O(n).
	 *
	 * @return true if passed string is palindrome, false - otherwise
	 */
	public static boolean isPalindrome(String str) {
		if(str==null)
			return false;
		
		return isPalindrome(str,0,str.length()-1);
	}

	/**
	 * @param str: input string
	 * @param start: start index of the string
	 * @param end: end index of the string
	 * @return true is the input string is is palindrome, false otherwise
	 */
	private static boolean isPalindrome(String str, int start, int end) {
		
		while(start<end){
			
			//remove non-alphanumeric characters from start
			while(start<end){
				if(isAlphanumeric(str.charAt(start)))
					break;
				else
					start++;
			}
			
			//remove non-alphanumeric characters from end
			while(start<end){
				if(isAlphanumeric(str.charAt(end)))
					break;
				else
					end--;
			}
			
			//check euqality of characters at start and end index
			if (start < end) {
				if (((int) str.charAt(start) == (int) str.charAt(end))
						|| ((int) str.charAt(start) + 32 == (int) str
								.charAt(end))
						|| ((int) str.charAt(start) - 32 == (int) str
								.charAt(end))) {
					start++;
					end--;
				} else {
					return false;
				}
			}
		}
	
		return true;
	}

	/**
	 * @param ch
	 * @return true if the character is alphanumeric (A-Z, a-z, 0-9), false otherwise
	 */
	private static boolean isAlphanumeric(char ch) {
		return (Character.isAlphabetic(ch) || Character.isDigit(ch));
	}
}