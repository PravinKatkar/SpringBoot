package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class EmpService {

	public void addEmp(String empname) {
		System.out.println("Emp Added : " + empname);
	}
	
	public void showEmp() {
		System.out.println("Emp1");
	}

	public String getEmp() {
		return "Emp2";
	}
}
