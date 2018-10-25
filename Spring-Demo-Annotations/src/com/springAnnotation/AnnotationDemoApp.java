package com.springAnnotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from spring container
		Coach theCoach=context.getBean("myCoach",Coach.class);
		
		// call methods from bean
		System.out.println(theCoach.getDailyWorkout()+"Your Fortune today :"+theCoach.getDailyFortune());
		
		// close context
		context.close();
	}

}
