package com.practiceprobs;

public class MatrixPath {
	
	public static void findPath(int[][] arr,int i,int j) {
		boolean isDone=false;
		if(i==3 && j==3) {
			isDone=true;
		}
		if(!isDone) {
			
		}
		
	}
	
	public static void main(String[] args) {
		int[][] pathToFind= {{1,1,0,0},
							 {0,1,0,0},
							 {0,1,1,0},
							 {0,0,1,1}};
		findPath(pathToFind,0,0);
	}

}
