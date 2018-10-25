package com.practiceprobs;

import java.util.Date;

public class numberOfDaysBetween {

	public static boolean isValidDate(int[]date) {
		int maxDays=0;
		switch(date[1]) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			maxDays=31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			maxDays=30;
			break;
		case 2:
			if(leapYear(date[2]))
				maxDays=29;
			maxDays=28;
			break;
		}
		if(date[0]>0 || date[0]<=maxDays)
			return true;
		return true;
	}
	public static boolean leapYear(int year) {
		if(year%4==0)
			return true;
		return false;
	}
	public static boolean isValidMonth(int[]date) {
		if(date[2]<1 || date[2]>12)
			return false;
		return true;
	}
	public static boolean isValid(int[] date1,int[] date2) {
		/*if(!isValidDate(date1) || !isValidDate(date2) || !isValidMonth(date1) || !isValidMonth(date2)
			|| (date1[2]>date2[2]) || (date1[2]==date2[2] && date1[1]>date2[1])
			|| (date1[2]==date2[2] && date1[1]==date2[1] && date1[0]>date2[0]))
			return false;*/
		return true;
	}
	public static void dateDiff(int[] date1,int[] date2) {
		if(date1[2]==date2[2]) {
			if(date1[1]==date2[1])
				System.out.println(date2[0]-date1[0]);
			else {
				
			}
		}
	}
	public static void main(String[] args) {
		int[] date1= {10,2,2014};
		int[] date2= {1,12,2015};
		boolean validCheck=isValid(date1,date2);
		if(!validCheck)
			System.out.println("Invalid Date");
		else
			dateDiff(date1,date2);
		
		Date date=new Date(date1[2],date1[1],date1[0]);
		Date date3=new Date(date2[2],date2[1],date2[0]);
		//int numOfDays=Da
	}

}
