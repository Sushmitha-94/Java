package com.practiceprobs;

// next smallest palindrome
public class nextSmallestPalindrome {

	// if all are 9, display 1 followed by (n-1) 0s and display last digit as 9
	public static boolean allNine(int[] a) {
		for(int i=0;i<a.length;i++) {
			if(a[i]!=9)
				return false;
		}
		return true;
	}
	
	// find mid element, then left and right.
	// if left is smaller then right, make isSmallest as true
	// mirror all right with left
	// if isSmallest is true, add 1 to the mid element in case of odd and carry over if spills
	// add 1 to the left and keep on carry over if needed and mirror to right
	public static int[] generatePalindrome(int[] a){
		int mid=a.length/2;
		int left,right;
		boolean isSmallest=false;
		if(a.length%2==0) {
			left=mid-1;
			right=mid;
		}
		else {
			left=mid-1;
			right=mid+1;
		}
		while(left>=0 && a[left]==a[right]) {
			left--;right++;
		}
		if(left<0 || a[left]<a[right])
			isSmallest=true;
		
		for(;left>=0;left--,right++)
			a[right]=a[left];
			
		if(isSmallest) {
			int carry=1;
			int i=mid-1,j;
			if(a.length%2==0)
				j=mid;
			else {
				a[mid]+=carry;
				carry=a[mid]/10;
				a[mid]%=10;
				j=mid+1;
			}
			
			while(carry>0) {
				a[i]+=carry;
				carry=a[mid]/10;
				a[i]%=10;
				a[j]=a[i];
				j++;i--;
			}
		}
		return a;
	}
	public static int[] nextSmaPalin(int[] a) {
		
		int i;
		if(allNine(a)) {
			int b[]=new int[a.length+1];
			b[0]=1;
			for(i=1;i<a.length;i++)
				b[i]=0;
			b[i]=1;
			return b;
		}
		else {
			return generatePalindrome(a);
		}
	}
	
	public static void main(String[] args) {
		int[] a= {1,2,9,3,1};
		System.out.println("Next smallest palindrome is: ");
		int[] b=nextSmaPalin(a);
		for(int i=0;i<b.length;i++)
			System.out.print(b[i]);
	}

}
