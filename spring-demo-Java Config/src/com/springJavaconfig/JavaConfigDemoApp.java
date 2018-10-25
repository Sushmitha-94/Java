package com.springJavaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean from spring container
		SwimCoach theCoach=context.getBean("swimCoach",SwimCoach.class);
		
		// call methods from bean
		System.out.println(theCoach.getTeam()+" "+theCoach.getDailyWorkout()+"\nYour Fortune today :"+theCoach.getDailyFortune());
		
		// close context
		context.close();
	}

}
