package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	public DemoController() {
System.out.println("DemoController========================");
	}
	
	@GetMapping("/hello")
	public String getData() {
		return "hello";
	}

}
