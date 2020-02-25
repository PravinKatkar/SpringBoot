package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JoinedService {


	public String getBracket(int income) {
		if(income < 10000) { return "LOW";}
		else if(income < 50000) { return "MEDIUM";}
		else return "HIGH";
	}

	public List<String> getAllBrackets(){
		return Arrays.asList("LOW", "MEDIUM", "HIGH");
	}
}
