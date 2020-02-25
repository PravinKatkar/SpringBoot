package com.example.demo;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(Long id) {
		super("User id not found : " + id);
	}

	public UserNotFoundException(String msg) {
		super(msg);
	}

}
