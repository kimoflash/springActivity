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

		//Other way to write the exceptions
		/*
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
		*/
		
		//try and catch method
		try {
			if (pckg.getLength() <= 0) {
				throw new ValidationException("Invalid input. Length should be greater than 0!");
			}
			
			if (pckg.getWidth() <= 0) {
				throw new ValidationException("Invalid input. Width should be greater than 0!");
			}
			
			if (pckg.getHeight() <= 0) {
				throw new ValidationException("Invalid input. Height should be greater than 0!");
			}
			
			if (pckg.getWeight() <= 0) {
				throw new ValidationException("Invalid input. Weight should be greater than 0!");
			}
			
			return service.calculatePackagePrice(pckg);
		} catch (ValidationException validationException) {
			throw validationException;
		} catch (Exception e) {
			throw new Exception("An error occurred during package price calculation.", e);
		}

		 
	}
}
