package com.lenovo.advancedJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lenovo.advancedJava.PackageModel;
import com.lenovo.advancedJava.serviceImpl.PriceCalculatorServiceImpl;

@RestController
public class CalculatePackagePrice {
	
	@Autowired
	PriceCalculatorServiceImpl service;
	
	@PostMapping("/calculatePrice")
	public double calculatePrice(@RequestBody PackageModel pckg) throws Exception {
		if(pckg.getHeight() <= 0) {
			throw new Exception("Height is less than or equal to zero!");
		}
		
		return service.calculatePackagePrice(pckg);
	}
}
