package com.estore.builder;

import java.util.Objects;

import javax.ws.rs.core.Response.Status;

public class SuccessMessageBuilder {
	private Status statusCode;
	private String message;
	// constructor
	public SuccessMessageBuilder(Status statusCode) {
		super();
		this.statusCode = statusCode;
	}
	// utility method
	public static SuccessMessageBuilder statusCode(Status httpStatus) {
		return new SuccessMessageBuilder(httpStatus);
	}
	// instance method
	public SuccessMessageBuilder message(String message) {
		this.message = message;
		return this;
	}
	// instance method
	public SuccessMessage build() {
		Objects.requireNonNull(this.statusCode, "Staus Code must not be null");
		return new SuccessMessage(this.statusCode, this.message);
	}
}
