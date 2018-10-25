package com.practiceprobs;

public class RemoveSubstring {

	public static void main(String[] args) {
		String str="Geek For Geeks";
		String str1="Gs"; 
		for(int i=0;i<str1.length();i++) {
			str=str.replace(str1.charAt(i)+"", "");
		}
		System.out.println(str);
	}

}
