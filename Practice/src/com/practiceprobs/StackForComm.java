package com.practiceprobs;

public class StackForComm {

	public String[] stringArray;
	public int top;
	public int maxArray;
	public String[] countVar;
	
	StackForComm(int maxArray){
		stringArray=new String[maxArray];
		top=-1;
		this.maxArray=maxArray;
	}
	
	public void push(String value) {
		if(top<maxArray) {
			stringArray[++top]=value;
		}
	}
	
	public void set(String val1,String val2) {
		push(val1);
		push(val2);
	}
	
	public String pop(String value) {
		if(top>-1) {
			return stringArray[top--];
		}
		return null;
	}
	
	public String getVal(String value) {
		for(int i=top;i>=0;i--) {
			if(value.equals(stringArray[i])) {
				return stringArray[i+1];
			}
		}
		return null;
	}
	
	public void unset(String value) {
		for(int i=top;i>=0;i--) {
			if(value.equals(stringArray[i])) {
				stringArray[i+1]=null;
			}
		}
	}
	
	public boolean update(String value,String value2) {
		if(getVal(value)!=null) {
			set(value,value2);
			return true;
		}
		return false;
	}
	
	public int countVal(String value) {
		countVar=new String[top];
		int topCount=0;
		int count=0;
		boolean isThere=false;
		int i;
		for(i=top;i>0;i--) {
				/*for(int j=0;j<topCount;j++) {
					if(stringArray[i-1]!=null && stringArray[i-1].equals(countVar[j]))
						isThere=true;
				}
				if(!isThere)
					countVar[topCount++]=stringArray[i-1];
				if(value.equals(stringArray[i]) && !isThere)
					count++;*/
			
			for(int j=0;j<topCount;j++) {
				if(stringArray[i-1].equals(countVar[j])) {
					isThere=true;
					break;
				}
			}
			if(!isThere) {
				countVar[topCount++]=stringArray[i-1];
			}
			if(value.equals(stringArray[i]) && !isThere) {
				count++;
				i--;
			}
				
		}
		
		return count;
	}
	
	public void rollBack() {
		while(!stringArray[top].equals("BEGIN"))
			top--;
		top--;
	}
}
