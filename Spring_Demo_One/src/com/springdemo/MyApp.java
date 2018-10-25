package com.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		//create the object
		Coach theCoach=new SwimmingCoach(new HappyFortuneService());
		
		//use the object
		System.out.println(theCoach.getDailyWorkout());
	}

}
