package com.cognixia.jump.jdbcproject;

public class CustomException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CustomException(String msg) {
		super("Invalid input due to: " + msg);
	}
}
