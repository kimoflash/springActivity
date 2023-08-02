package com.lenovo.advancedJava.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lenovo.advancedJava.exception.ValidationException;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("Server error");
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ValidationException.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(ValidationException exception, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse("Validation error");
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(ValidationException.class)
//	public final ResponseEntity<ExceptionResponse> handleExceptions(ValidationException exception, WebRequest request) {
//		
//		ExceptionResponse exceptionResponse = new ExceptionResponse("Validation error");
//		
//		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
//	}
	
	//SHOULD I CREATE A CLASS W/ A LIST OF VALIDATION?
	public record ExceptionResponse(String message) {
		
	}

}
