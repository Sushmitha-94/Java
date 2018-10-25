package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//load spring config file
		ClassPathXmlApplicationContext context1 = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		context1.refresh();
		TrackCoach track=context1.getBean("MyCoach",TrackCoach.class);
		
		// call methods in bean
		System.out.println(track.getTeam()+" "+track.getDailyWorkout()+" Fortune: "+track.getDailyFortune());
		
		//close context
		context1.close();
	}

}
