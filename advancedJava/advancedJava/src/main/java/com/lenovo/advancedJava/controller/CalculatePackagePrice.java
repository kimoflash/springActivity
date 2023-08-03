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
		if(pckg.getHeight() <= 0) {
			throw new ValidationException("Invalid input. Height should be greater than 0!");
		}
		
		if(pckg.getLength() <= 0) {
			throw new ValidationException("Invalid input. Length should be greater than 0!");
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
