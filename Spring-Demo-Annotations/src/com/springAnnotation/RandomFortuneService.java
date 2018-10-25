package com.springAnnotation;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	/*// create array of strings
	private String[] data= {
			"Good Luck",
			"All the best",
			"Keep a check"
	};*/
	
	// read string[] from file
	private String fileName = "E:/Program Files/Spring Hibernate/fortune-data.txt";
	private List<String> data;
	
	public RandomFortuneService() {
		File theFile=new File(fileName);
		data=new ArrayList<String>();
		
		try{
			FileReader fileRead=new FileReader(theFile);
			BufferedReader bufferRead=new BufferedReader(fileRead);
			String line;
			while((line=bufferRead.readLine())!=null) {
				data.add(line);
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private Random randomNum=new Random();
	
	@Override
	public String getFortune() {
		//pick a random string from array
		int index=randomNum.nextInt(data.size());
		
		return data.get(index);
	}

}
