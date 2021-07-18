package com.youtube.javabrains.RESTMessenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorMessage;
	private int errorCode;	//this is our own custom error code, not HTTP code
	private String documentation;	//for documentation link, to let client view that page
	
	
	public ErrorMessage() {
		
	}
	public ErrorMessage(String errorMessage, int errorCode, String documentation) {
		super();		
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;		
		this.documentation = documentation;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getDocumentation() {
		return documentation;
	}
	
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
}
