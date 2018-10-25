package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//load spring config file
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach=context.getBean("MyCoachCon", Coach.class);
				
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//fortune service method- constructor injection
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
