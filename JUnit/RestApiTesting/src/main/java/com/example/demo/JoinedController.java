package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinedController {

	@Autowired
	JoinedService js;
	
	@GetMapping("/hello1")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/getAllBk")
	public List<String> getAllBrackets() {
		return js.getAllBrackets();		
	}

}
