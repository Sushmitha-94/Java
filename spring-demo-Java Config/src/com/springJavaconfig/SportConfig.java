package com.springJavaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.springJavaconfig")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	@Bean FortuneService badfortuneservice() {
		return new BadFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		SwimCoach mySwimCoach = new SwimCoach (badfortuneservice());
		return mySwimCoach;
	}
}
