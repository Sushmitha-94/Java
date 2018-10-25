package com.practiceprobs;

// display non palindrome words
public class PalindromWordInString {

	// check if the word is palindrome and true if yes
	public static boolean isPalindrome(String str) {
		char[] charArr=str.toCharArray();
		for(int i=0,j=charArr.length-1;i<j;i++,j--) {
			if(charArr[i]!=charArr[j]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String stringToCheck="Hari speaks malayalam";
		String[] stringArr=stringToCheck.split(" ");
		for(String strLoop:stringArr) {
			if(!isPalindrome(strLoop)) {
				System.out.print(strLoop+" ");
			}
		}
	}

}
