package com.practiceprobs;

import java.util.HashMap;

// print next greater value in the array and print "_" for largest value

public class nextGreaterNA_ {

	// track the next largest value in nge array
	public static int[] nextGreatestElement(int[] input,int n) {
		int[] nge=new int[n];
		for(int i=0;i<n;i++) {
			int max=Integer.MAX_VALUE;
			for(int j=0;j<n;j++) {
				if(input[i]<input[j]) {
					if(input[j]<max) {
						max=input[j];
					}
				}
			}
			if(max==Integer.MAX_VALUE) {
				nge[i]=-1;
			}
			else {
				nge[i]=max;
			}
		}
		return nge;
	}
	
	public static void displayArray(int[] arr,int n) {
		System.out.println();
		for(int i=0;i<n;i++) {
			if(arr[i]==-1) {
				System.out.print("_");
			}
			else {
				System.out.print(arr[i]);
			}
			System.out.print(" ");
		}
	}
	
	public static int pivotSort(int a[],int low,int high) {
		int pivot=a[high];
		int index=low;
		for(int i=low;i<high;i++) {
			if(a[i]<pivot) {
				int temp=a[index];
				a[index]=a[i];
				a[i]=temp;
				index++;
			}
		}
		int temp=a[index];
		a[index]=a[high];
		a[high]=temp;
		return index;
	}
	
	public static void quicksort(int a[],int low,int high) {
		if(low<high) {
			int index=pivotSort(a,low,high);
			quicksort(a,low,index-1);
			quicksort(a,index+1,high);
		}
	}
	
	public static void main(String[] args) {
		/*Scanner s=new Scanner(System.in);
		Scanner numScanner=new Scanner(s.nextLine());
		int[] inputVal = new int[10];
		for(int i=0;;i++) {
			if(numScanner.hasNext()) {
				inputVal[i]=numScanner.nextInt();
			}
			else {
				break;
			}
		}*/
		int[] inputVal= {4,15,2,9,20,11,13};
		displayArray(inputVal,inputVal.length);
		int[] sortedArray=new int[inputVal.length];
		for(int i=0;i<inputVal.length;i++) {
			sortedArray[i]=inputVal[i];
		}
		quicksort(sortedArray,0,sortedArray.length-1);
		HashMap<Integer,Integer> hashSort=new HashMap<Integer,Integer>();
		for(int i=0;i<sortedArray.length;i++) {
			hashSort.put(sortedArray[i], i);
		}
		System.out.println();
		for(int i=0;i<inputVal.length;i++) {
			
			int index=hashSort.get(inputVal[i]);
			index++;
			if(index<inputVal.length) {
				System.out.print(sortedArray[index]+" ");
			}
			else
				System.out.print("_ ");
		} 
	}

}
