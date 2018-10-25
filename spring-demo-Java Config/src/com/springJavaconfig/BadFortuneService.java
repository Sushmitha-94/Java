package com.springJavaconfig;

public class BadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your bad Day";
	}

}
