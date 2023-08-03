package com.lenovo.advancedJava.exceptions;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ValidationException(String exception) {
		super(exception);
	}
}
