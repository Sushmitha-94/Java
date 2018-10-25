package com.practiceprobs;

import java.util.ArrayList;
import java.util.HashMap;

public class SortFreqOfOccurances {
	static int[] distinctVal;
	static int[] distinctOcc;
	static HashMap<Integer,ArrayList<Integer>> hashOccur=new HashMap<Integer,ArrayList<Integer>>();
	
	public static int[] sort(int[] a,int low,int high) {
		int pivot=a[high];
		int index=low;
		for(int i=low;i<high;i++) {
			if(a[i]<=pivot) {
				a=swap(a,index,i);
				index++;
			}
		}
		if(low<high) {
			a=swap(a,index,high);
			a=sort(a,low,index-1);
			a=sort(a,index+1,high);
		}
		
		return a;
	}
	
	public static int[] swap(int[] a,int low,int high) {
		int temp=a[low];
		a[low]=a[high];
		a[high]=temp;
		return a;
	}
	
	public static void main(String[] args) {
		int[] inputArr= {2,2,3,4,5,12,2,3,3,3,12};
		int[] sorted=sort(inputArr,0,inputArr.length-1);
		distinctVal=new int[inputArr.length];
		distinctOcc=new int[inputArr.length];
		for(int i=0;i<distinctVal.length;i++) {
			
		}
		/*distinctVal=new int[inputArr.length];
		distinctOcc=new int[inputArr.length];
		int i=0;
		for(int val:inputArr) {
			boolean isNew=true;
			for(int j=0;j<i;j++) {
				if(val==distinctVal[j]) {
					distinctOcc[j]++;
					isNew=false;
					break;
				}
			}
			if(isNew) {
				distinctVal[i]=val;
				distinctOcc[i]=1;
				i++;
			}
		}
		sort(distinctVal,distinctVal);*/
	}

}
