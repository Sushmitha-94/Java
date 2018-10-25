package com.springdemo;

public class TrackCoach implements Coach {
    // define private field for dependency 
	private FortuneService fortuneService;
	
	// inject literal
	private String team;
	private String emailAdd;
	
	//no-arg constructor
	public TrackCoach() {
		
	}
	//constructor for dependency injection
	public TrackCoach(FortuneService theFortuneService){
		fortuneService=theFortuneService;
	}		
	
	public void setTeam(String team) {
		this.team = team;
	}
	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}
	
	public String getTeam() {
		return team;
	}
	public String getEmailAdd() {
		return emailAdd;
	}
	//setter method for setter injection
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return ": Run 5 Kms..";
	}

	@Override
	public String getDailyFortune() {
		// use fortuneService to get fortune
		return fortuneService.getFortune();
	}

	// add an init method
	public void doMyStartupStuff() {
		System.out.println("Do my start up");
	}
	
	// add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("Do my clean up");
	}
}
