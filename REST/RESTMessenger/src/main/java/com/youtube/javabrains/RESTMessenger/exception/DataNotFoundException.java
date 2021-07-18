package com.youtube.javabrains.RESTMessenger.exception;

public class DataNotFoundException extends RuntimeException{

	//runtime exception has a serialID
	private static final long serialVersionUID = -3468939208586483350L;
	
	public DataNotFoundException(String message) {
		super(message);
	}
}
