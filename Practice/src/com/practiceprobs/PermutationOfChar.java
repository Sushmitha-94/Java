package com.practiceprobs;

public class PermutationOfChar {

	public static boolean toPermute(char[] charTP,int index,char ch,int left) {
		for(int i=left;i<index;i++) {
			if(ch==charTP[i])
				return false;
		}
		return true;
	}
	public static void swap(char[] charTP,int i,int j) {
		char temp=charTP[i];
		charTP[i]=charTP[j];
		charTP[j]=temp;
	}
	
	public static void permute(char[] charTP,int left,int right) {
		if(left==right) {
			System.out.println(charTP);
		}
		else {
			for(int i=left;i<=right;i++) {
				if(toPermute(charTP,i,charTP[i],left)) {
					swap(charTP,i,left);
					permute(charTP,left+1,right);
					swap(charTP,i,left);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		char[] charToP= {'A','B','C','A'};
		permute(charToP,0,charToP.length-1);
	}

}
