package com.practiceprobs;

import java.util.HashMap;

// assign lifts to the users

public class LiftAssign {

	static int[] liftPosition=new int[5];
	static int[] capacity=new int[5];
	static HashMap<Integer,int[]> liftStops=new HashMap<Integer,int[]>();
	
	// find the no of stops it takes to reach "from" + to reach "to"
	static int noOfStops(int lift,int from,int to) {
		int noOfStops=-1;
		if(lift==1 || lift==0){
			if(from>=0 && from<=5 && to>=0 && to<=5) {
				noOfStops=Math.abs(liftPosition[lift]-from)+Math.abs(from-to);
			}
		}
		else if(lift==2 || lift==3) {
			if((from==0 || (from>=6 && from<=10)) && (to==0 || (to>=6 && to<=10))) {
				
				if(from==0)
					noOfStops=Math.abs(liftPosition[lift]-6)+1;
				else
					noOfStops=Math.abs(liftPosition[lift]-from);
				
				if(to==0)
					noOfStops+=Math.abs(from-6)+1;
				else
					noOfStops+=Math.abs(from-to);
			}
		}
		else if(lift==4) {
			noOfStops=Math.abs(liftPosition[lift]-from)+Math.abs(from-to);
		}
		return noOfStops;
	}
	
	// assign lift that has less no of stops.
	// if two lifts have same no of steps, assign the lift that need single direction to reach "From" and "to"
	static void assignSameDirection(int from,int to) {
		//int absValue=Integer.MAX_VALUE;
		int lift=0;
		int noOfStops=Integer.MAX_VALUE;
		for(int i=0;i<5;i++){
			if(liftPosition[i]==-1)
				break;
			int a=noOfStops(i,from,to);
			if(a!=-1 && noOfStops>a)
			{
				noOfStops=a;
				lift=i;
			}
			else if(a!=-1 && noOfStops==a && liftPosition[lift]!=liftPosition[i]) {
				noOfStops=a;
				lift=i;
			}
			/*
			if(Math.abs(liftPosition[i]-from)<absValue) {
				absValue=Math.abs(liftPosition[i]-from);
				lift=i;
			}
			else if(Math.abs(liftPosition[i]-from)==absValue && liftPosition[lift]!=liftPosition[i]){
				 if((liftPosition[i]-from)>0 && (liftPosition[i]-to)>0) {
					absValue=Math.abs(liftPosition[i]-from);
					lift=i;
				}
				else if((liftPosition[i]-from)<0 && (liftPosition[i]-to)<0) {
					absValue=Math.abs(liftPosition[i]-from);
					lift=i;
				}
			}*/
		}
		liftPosition[lift]=to;
		System.out.println("L"+(lift+1)+" is assigned");
		displayPosition();
	}
	
	// displays position of lifts
	static void displayPosition() {
		System.out.print("Lift : L1 L2 L3 L4 L5\nFloor:");
		for(int i=0;i<5;i++)
			System.out.print(" "+liftPosition[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		assignSameDirection(2,5);
		assignSameDirection(0,4);
		assignSameDirection(1,7);
		assignSameDirection(6,10);
		assignSameDirection(0,6);
		assignSameDirection(7,8);
		liftPosition[2]=-1;
		displayPosition();
	}

}
