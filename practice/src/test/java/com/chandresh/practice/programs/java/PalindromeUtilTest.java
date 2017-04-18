package com.chandresh.practice.programs.java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PalindromeUtilTest {

	
	@Test
	public void isPalindrome_Null_False(){
		boolean actual = PalindromeUtil.isPalindrome(null);
		assertEquals(false, actual);
	}
	
	@Test
	public void isPalindrome_EmptyString_True(){
		boolean actual = PalindromeUtil.isPalindrome("");
		assertEquals(true, actual);
	}
	
	@Test
	public void isPalindrome_InvalidPalindromeWord_False(){
		boolean actual = PalindromeUtil.isPalindrome("Madaam");
		assertEquals(false, actual);
	}
	
	@Test
	public void isPalindrome_ValidPalindromeWord_True(){
		boolean actual = PalindromeUtil.isPalindrome("Madam");
		assertEquals(true, actual);
	}
	
	@Test
	public void isPalindrome_ValidPalindromeWithNonAlphanumericCharacters_True(){
		boolean actual = PalindromeUtil.isPalindrome("Madam, I'm Adam.");
		assertEquals(true, actual);
	}
	
	@Test
	public void isPalindrome_InvalidPalindromeWithNonAlphanumericCharacters_True(){
		boolean actual = PalindromeUtil.isPalindrome("Madam,$I1'm Adam.");
		assertEquals(false, actual);
	}
}
