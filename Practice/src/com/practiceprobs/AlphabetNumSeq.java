package com.practiceprobs;

// possible decodings of the given number to alphabet
// eg., i/p : 1284
// ABHD, LHD
// o/p: 2
public class AlphabetNumSeq {
	
	public static int possibleDecoding(int[] digit,int n) {
		int[] count=new int[n+1];
		count[0]=1;
		count[1]=1;
		for(int i=2;i<=n;i++) {
			count[i]=0;
			if(digit[i-1]>0)
			{
				count[i]+=count[i-1];
			}
			if(digit[i-2]==1 || (digit[i-2]==2 && digit[i-1]<7)) {
				count[i]+=count[i-2];
			}	
		}		
		return count[n];
	}
	
	public static void main(String[] args) {
		int[] digit= {1,2,8,4};
		System.out.println("Possible decoding: "+possibleDecoding(digit,digit.length));
	}

}
