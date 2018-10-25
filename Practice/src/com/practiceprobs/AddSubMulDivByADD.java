package com.practiceprobs;

// add, sub, mul and div two numbers just using addition
public class AddSubMulDivByADD {

	public static int add(int a,int b) {
		int result=a+b;
		return result;
	}
	public static int sub(int a,int b) {
		int result=a+(-b);
		return result;
	}
	public static int mul(int a,int b) {
		boolean neg=false;
		if(b==0 || a==0) {
			return 0;
		}
		else if(b<0 || a<0) {
			neg=true;
			b=Math.abs(b);
			a=Math.abs(a);
		}
		int result=0;
		for(int i=1;i<=b;i++)
			result+=a;
		if(neg)
			return -(result);
		return result;
	}
	@SuppressWarnings("null")
	public static int div(int a,int b) {
		boolean neg=false;
		if(a==0) {
			return 0;
		}
		else if(b==0) {
			return (Integer) null;
		}
		else if(b<0 || a<0) {
			neg=true;
			b=Math.abs(b);
			a=Math.abs(a);
		}
		int count=0;
		while(a>=b) {
			a-=b;
			count++;
		}
		if(neg)
			return -(count);
		return count;
	}
	public static void main(String[] args) {
		int a=10,b=-2;
		System.out.println("Addition: "+add(a,b));
		System.out.println("Subtraction: "+sub(a,b));
		System.out.println("Multiplication: "+mul(a,b));
		System.out.println("Division: "+div(a,b));
	}

}
