package com.example.demo;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogInfoAsspect {

	@Before("execution(* EmpService.*(..))")
	public void before(JoinPoint jp) {
		System.out.println("Before");
		System.out.println(jp.getSignature().getName());
		System.out.println(Arrays.toString(jp.getArgs()));
	}
	
	@Around("execution(* EmpService.*(..))")
	public void around(ProceedingJoinPoint point) throws Throwable {
	    long start = System.currentTimeMillis();
	    Object result = point.proceed();
	    long end = System.currentTimeMillis();
		System.out.println("Execution time = " +(end - start));

	 }
	@After("execution(* EmpService.*(..))")
	public void after(JoinPoint jp) {
		System.out.println("After");
		System.out.println(jp.getSignature().getName());
		
	}
	
}
