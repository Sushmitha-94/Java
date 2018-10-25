package com.practiceprobs;

public class mobileEquivalentNumeric {
	
	// find the numeric value of alphabet, e.g., A-0, B-1 using "sentence.charAt(i)-'A'"
	// check the index of the array and print it
	private static void findNumeric(String sentence, String[] str) {
		String output ="";
		for(int i=0;i<sentence.length();i++) {
			if(sentence.charAt(i)==' ')
				output+="0";
			else {
				output+=str[sentence.charAt(i)-'A'];
			}
		}
		System.out.println("Numeric equivalent: "+output);
	}
	public static void main(String[] args) {
		String str[]= {"2","22","222",
					   "3","33","333",
					   "4","44","444",
					   "5","55","555",
					   "6","66","666",
					   "7","77","777","7777",
					   "8","88","888",
					   "9","99","999","9999"};
		String sentence="HI GOOD MORNING";
		findNumeric(sentence,str);
		
	}


}
