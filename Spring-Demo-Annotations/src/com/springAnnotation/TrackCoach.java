package com.springAnnotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Java Annotation -Bean ID
@Component("myCoach")
@Scope("singleton")
public class TrackCoach implements Coach {
	
	// add qualifier to specify the class
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TrackCoach() {
		System.out.println("Inside track default Constructor");
	}
	/*
	//Constructor injection
	@Autowired
	public TrackCoach(FortuneService fortuneService){
		this.fortuneService=fortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Run 5 KMs..";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@PostConstruct
	public void postDestructMethod() {
		System.out.println("After construction trackCoach");
	}
	
	@PreDestroy
	public void preDestroyMethod() {
		System.out.println("Before destruction trackCoach");
	}
}
