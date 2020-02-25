package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmpService empService;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "hello mr";
	}

	@GetMapping("/show")
	public String showEmp() {
		empService.showEmp();
		return "Emp Showed";
	}
	
	@GetMapping("/add")
	public String addEmp() {
		empService.addEmp("Emp3");
		return "Emp3 added";
	}

}
