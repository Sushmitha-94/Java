package com.practiceprobs;

// to display the rectangle that can be formed using the given two points in a array
public class matrixRectangle {
	
	// Print the rectangle values
	public static void printVal(int[][] arr,int a,int b,int i,int j) {
		for(int l=a;l<=b;l++) {
			for(int k=i;k<=j;k++)
				System.out.print(arr[l][k]);
			System.out.println();
		}
	}
	
	// check and print the rectangle that can be formed
	public static void findRect(int[][] arr,int a,int b,int i,int j) {
		if(a<i && b<j)
			printVal(arr,a,i,b,j);
		else if(a<i && b>j)
			printVal(arr,a,i,j,b);
		else if(a>i && b>j)
			printVal(arr,i,a,j,b);
		else if(a>i && b<j)
			printVal(arr,i,a,b,j);
		else
			System.out.println("No Rectangle can be formed");
	}
	public static void main(String[] args) {
		int[][] arr= {{1,2,3,4,6},{5,3,8,1,2},{4,6,7,5,5},{2,4,8,9,4}};
		int a=3,b=4,i=2,j=0;
		if(a==i || b==j || Math.abs(a-i)==Math.abs(b-j))
			System.out.println("No Rectangle can be formed");
		else
			findRect(arr,a,b,i,j);
	}

}
