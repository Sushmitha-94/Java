package com.practiceprobs;

import java.util.Scanner;

public class Dummy {

	static Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args) {
		int a=1;
		// replace given string by ""
		String intToString=Integer.toString(a);
		while(!intToString.isEmpty()) {
			System.out.println("Enter digit to be deleted: ");
			String input=scan.nextLine();
			intToString=intToString.replaceAll(input, "");
			System.out.println("Integer: "+intToString);
		}
		
		// alphabetical order
		String c="GOTTO",b="GOTCHA";
		int result=c.compareTo(b);
		if(result==0)
			System.out.println("Same");
		else if(result>0)
			System.out.println(b+" comes first");
		else
			System.out.println(c+" comes first");
	}

}
