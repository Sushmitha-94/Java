package com.springAnnotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load spring config
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve ben from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		context.close();
	}

}
