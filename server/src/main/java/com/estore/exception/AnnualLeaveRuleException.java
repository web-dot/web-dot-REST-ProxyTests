package com.estore.exception;

import java.util.UUID;

public class AnnualLeaveRuleException extends RuntimeException {
	private static final String serialVersionUID = UUID.randomUUID().toString();
	
	private final String message;
	
	public AnnualLeaveRuleException() {
		this.message = "Annual Leave Rule Exception";
	}
	
	public AnnualLeaveRuleException(String message) {
		super();
		this.message = message;
	}
	
	public AnnualLeaveRuleException(String message, Throwable e) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
