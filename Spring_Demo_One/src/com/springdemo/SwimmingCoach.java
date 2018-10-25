package com.springdemo;

public class SwimmingCoach implements Coach {

// define private field for dependency 
	private FortuneService fortuneService;
	
	//constructor for dependency injection
	public SwimmingCoach(FortuneService theFortuneService){
		fortuneService=theFortuneService;
	}
		
	@Override
	public String getDailyWorkout() {
		
		return "Freestyle for 10 mins";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
