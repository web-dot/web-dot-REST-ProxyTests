package com.estore.exception;

public class StudentDataConfigurationException extends RuntimeException {
	private static final String PARAMETER_CAN_NOT_BE_NULL = "Parameters cannot be null";
	public static final String STUDENT_DATA_CONFIGURATIONS_CANNOT_BE_NULL = "StudentDataConfiguration cannot be null";
	private final String message;
	public StudentDataConfigurationException() {
		this.message = "StudentDataConfigurationException exception";
	}
	public StudentDataConfigurationException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
