package com.springAnnotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("Inside default Constructor");
	}
	
	//create setter for setter injection
	//AutoWired - setter
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice tennis for 30 mins..";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	/*//Method Injection
	@Autowired
	@Qualifier("happyFortuneService")
	public void methodInjection(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("Inside Method injection :"+fortuneService.getFortune());
	}*/
	
	@PostConstruct
	public void postDestructMethod() {
		System.out.println("After construction tennisCoach");
	}
	
	@PreDestroy
	public void preDestroyMethod() {
		System.out.println("Before destruction tennisCoach");
	}
}
