package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		// load config file - Spring factory
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

		
		// retrieve from spring container
		Coach trackCoach=context.getBean("myCoach",Coach.class);
		
		System.out.println("in Class: "+trackCoach.getDailyWorkout());
		context.close();
	}

}
