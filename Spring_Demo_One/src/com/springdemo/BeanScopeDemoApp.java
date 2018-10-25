package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load config file - Spring factory
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		
		// retrieve from spring container
		Coach trackCoach=context.getBean("MyCoach",Coach.class);
		
		Coach alphaCoach=context.getBean("MyCoach",Coach.class);
		
		// check if these are same beans
		System.out.println("Same?"+ (trackCoach==alphaCoach));
		
		//memory location of these beans
		
		System.out.println("Memory of trackCoach :  "+ trackCoach);
		System.out.println("Memory of alphaCoach :  "+ alphaCoach);
		
		context.close();
	}

}
