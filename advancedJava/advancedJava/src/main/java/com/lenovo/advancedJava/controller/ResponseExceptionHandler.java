package com.lenovo.advancedJava.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lenovo.advancedJava.exceptions.ValidationException;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{
	
//	@ExceptionHandler(SuccessException.class)
//    public ResponseEntity<SuccessResponse> handleCustomSuccessException(SuccessException exception) {
//        SuccessResponse successResponse = new SuccessResponse(exception.getMessage());
//        return new ResponseEntity<>(successResponse, HttpStatus.OK);
//    }
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("This is sample error");
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ValidationException.class)
	public final ResponseEntity<ExceptionResponse> handle(ValidationException exception, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	public record ExceptionResponse(String message) {
		
	}

}
