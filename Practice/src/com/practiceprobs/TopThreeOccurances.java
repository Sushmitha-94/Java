package com.practiceprobs;

import java.util.HashMap;
import java.util.Set;

public class TopThreeOccurances {

	static HashMap<Integer,int[]> mapValuesAndOccurance=new HashMap<Integer,int[]>();
	static Integer[] heapOcc=new Integer[10];
	static Integer[] heapIndex=new Integer[10];
	
	public static int hashValuesAndOccurance(int[] a) {
		for(int i=0;i<a.length;i++) {
			int dummy[]=new int[3];
			
			if(!mapValuesAndOccurance.containsKey(a[i]))
			{
				dummy[0]=1;
				dummy[1]=i;
				dummy[2]=a[i];
				mapValuesAndOccurance.put(a[i],dummy);
			}
			else {
				dummy=mapValuesAndOccurance.get(a[i]);
				dummy[0]++;
				mapValuesAndOccurance.put(a[i],dummy);
			}
		}
		return topThree();
	}
	
	public static int topThree() {
		int i=-1;
		Set<Integer> keySet=mapValuesAndOccurance.keySet();
		for(Integer a:keySet) {
			int[] toHeap=mapValuesAndOccurance.get(a);
			i++;
			heapOcc[i]=toHeap[0];
			heapIndex[i]=toHeap[1];	
			
		}
		for(int j=(i-1)/2;j>=0;j--) {
			maxHeapify(j,i);
		}
		for(int j=i;j>=0;j--) {
			swap(0,j);
			maxHeapify(0,j);
		}
		return i;
	}
	
	public static void maxHeapify(int i,int n) {
		int largest=i;
		int left=(i*2)+1;
		int right=(i*2)+2;
		if(left<n) {
			if(heapOcc[left]>heapOcc[largest])
			largest=left;
		}
			
		if(right<n) {
			if(heapOcc[right]>heapOcc[largest])
				largest=right;
		}
		if(largest!=i) {
			swap(largest,i);
			maxHeapify(largest,n);
		}
	}
	
	public static void swap(int i,int j) {
		Integer temp=heapOcc[i];
		heapOcc[i]=heapOcc[j];
		heapOcc[j]=temp;
		temp=heapIndex[i];
		heapIndex[i]=heapIndex[j];
		heapIndex[j]=temp;
	}
	
	
	public static void main(String[] args) {
		int[] arr= {2,5,2,2,5,5,3,3,4,2,3,5,5,7,7,7};
		int index=hashValuesAndOccurance(arr);
		int i=0;
		while(i<index+1) {
			System.out.print(arr[heapIndex[i]]+" Occurances:");
			System.out.println(heapOcc[i]);
			i++;
		}
	}

}


/*public static void topThree() {
		Set<Integer> keySet=mapValuesAndOccurance.keySet();
		for(Integer a:keySet) {
			int[] toHeap=mapValuesAndOccurance.get(a);
			if(index<3) {
				heapData[index]=toHeap[0];
				heapIndex[index]=toHeap[1];
				index++;
				heapify();
			}
			else {
				if(heapData[0]<toHeap[0]) {
					heapData[0]=toHeap[0];
					heapIndex[0]=toHeap[1];
					heapify();
				}
				else if(heapData[0]==toHeap[0] && heapIndex[0]>toHeap[1]) {
					heapData[0]=toHeap[0];
					heapIndex[0]=toHeap[1];
					heapify();
				}
					
			}
		}
	}
	public static void heapify() {
		if((index==2 || index==3) && heapData[0]>heapData[1]) 
		{
			swap(0,1);
			heapify();
		}
		else if((index==2 || index==3) && heapData[0]==heapData[1]) {
			if(heapIndex[0]>heapIndex[1])
			{
				swap(0,1);
				heapify();
			}
		}
		else{
			if(index==3 && heapData[1]>heapData[2])
			{
				swap(1,2);
				heapify();
			}
			if(index==3 && heapData[1]==heapData[2]) {
				if(heapIndex[1]>heapIndex[2]) {
					swap(1,2);
					heapify();
				}
					
			}
		}
	}
	*/


/*static HashMap<Integer,Integer> valueOccur=new HashMap<Integer,Integer>();
static String[] topThree=new String[3];
static int[] heapData=new int[3];
static int top=-1;

public static void hashArray(int[] arr) {
	for(int i=0;i<arr.length;i++) {
		if(!valueOccur.containsKey(arr[i])) {
			valueOccur.put(arr[i], 0);
		}
		valueOccur.put(arr[i], valueOccur.get(arr[i])+1);
	}
}

public static int heapify() {
	int temp=0;
	if(top>=2){
		if(heapData[0]>heapData[2]
				) {
			temp=2;
			
		}
		if(heapData[0]>heapData[1]) {
			temp=1;
		}
		if(temp!=0) {
			int tem=heapData[0];
			heapData[0]=heapData[temp];
			heapData[temp]=tem;
		}
	}

	System.out.println("Index 0 :" +heapData[0]+"\nIndex 1 :" +heapData[1]+"\nIndex 2 :" +heapData[2]);
	return temp;
}

public static int insertHeap(Integer data) {
	if(top<2) {
		heapData[++top]=data;
		heapify();
		return top;
	}
	else if(data>=heapData[0]) {
		heapData[0]=data;
		return heapify();
	}
	return -1;
}

public static void createMinHeap() {
	int i=0;
	for (Map.Entry<Integer, Integer> entry : valueOccur.entrySet()) {
	    String key = entry.getKey().toString();
	    Integer value = entry.getValue();
	    int heapV=insertHeap(value);
	    
	    if(heapV!=-1) {
	    	topThree[heapV]=key;
	    }
	    System.out.println("Key:"+key+" value:"+value +" inserted at : "+heapV);
	}
	
	for(int j=0;j<3;j++) {
		System.out.println(topThree[j]);
	}
}
*/