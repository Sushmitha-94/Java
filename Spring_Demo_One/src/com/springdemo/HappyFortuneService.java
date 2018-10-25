package com.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService{

	private String[] randomFortune= { 
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	private Random randomnum=new Random();

	@Override
	public String getFortune() {
		int index=randomnum.nextInt(randomFortune.length);
		return randomFortune[index];
	}

}
