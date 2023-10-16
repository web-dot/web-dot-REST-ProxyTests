package com.estore.builder;

import javax.ws.rs.core.Response.Status;

public class SuccessMessage {
	private Status statusCode;
	private String message;
	
	public SuccessMessage(Status statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public Status getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}
	
	public static SuccessMessageBuilder statusCode(Status httpStatus) {
		return new SuccessMessageBuilder(httpStatus);
	}
	
}
