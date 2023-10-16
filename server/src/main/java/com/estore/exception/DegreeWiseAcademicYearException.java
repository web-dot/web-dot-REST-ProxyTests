package com.estore.exception;

import java.util.UUID;

public class DegreeWiseAcademicYearException extends RuntimeException {
	
	private static final String serialVersionUID = UUID.randomUUID().toString();
	
	public static final String DEGREE_ID_CANNOT_BE_NULL = "Degree id can not be null";
	public static final String DEGREE_ID_CANNOT_BE_FOUND = "Degree id cannot be found";
	

	private final String message;
	
	public DegreeWiseAcademicYearException() {
		this.message = "Department Exception";
	}
	
	public DegreeWiseAcademicYearException(String message) {
		super(message);
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
