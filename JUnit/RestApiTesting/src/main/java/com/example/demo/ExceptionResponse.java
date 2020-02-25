package com.example.demo;

import java.util.Date;

public class ExceptionResponse {
	private String errorMessage;
	private String requestedURI;
	private Date excDate;
	private String status;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getRequestedURI() {
		return requestedURI;
	}
	
	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

	public Date getExcDate() {
		return excDate;
	}

	public void setExcDate(Date excDate) {
		this.excDate = excDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
