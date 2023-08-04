package com.lenovo.advancedJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lenovo.advancedJava.PackageModel;
import com.lenovo.advancedJava.controller.ResponseExceptionHandler.ExceptionResponse;
import com.lenovo.advancedJava.exceptions.ValidationException;
import com.lenovo.advancedJava.serviceImpl.PriceCalculatorServiceImpl;

@RestController
public class CalculatePackagePrice {
	
	@Autowired
	PriceCalculatorServiceImpl service;
	
	@PostMapping("/calculatePrice")
	public double calculatePrice(@RequestBody PackageModel pckg) throws Exception {
		
		
//		if (isEmpty(pckg.getHeight()) && isEmpty(pckg.getLength()) && isEmpty(pckg.getWeight()) && isEmpty(pckg.getWidth())) {
//		    throw new ValidationException("Invalid input. Height, length, weight, and width should be greater than 0!");
//		}
//		
//		if((pckg.getHeight() <0) && (pckg.getLength() <= 0) && (pckg.getWeight() <= 0) && (pckg.getWidth() <= 0)) {
//			throw new ValidationException("Invalid input. Values should not be empty!");
//		}

		
		if(pckg.getLength() <= 0) {
			throw new ValidationException("Invalid input. Length should be greater than 0!");
		}
		
		if(pckg.getWidth() <= 0) {
			throw new ValidationException("Invalid input. Width should be greater than 0!");
		}
		
		if(pckg.getHeight() <= 0) {
			throw new ValidationException("Invalid input. Height should be greater than 0!");
		}
		
		if(pckg.getWeight() <= 0) {
			throw new ValidationException("Invalid input. Weight should be greater than 0!");
		}
		
		return service.calculatePackagePrice(pckg);
		
//		double result = 0;
//		
//		try {
//			result = service.calculatePackagePrice(pckg);
//		} catch(Exception e) {
//			throw e;
//		}
//		
//		return result;
		 
	}
}
