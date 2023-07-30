package com.lenovo.advancedJava.serviceImpl;

import org.springframework.stereotype.Service;

import com.lenovo.advancedJava.PackageModel;
import com.lenovo.advancedJava.service.PriceCalculatorService;

@Service
public class PriceCalculatorServiceImpl implements PriceCalculatorService{

	@Override
	public double calculatePackagePrice(PackageModel pckg) {
		double price = 0;
		double volume = pckg.getLength() * pckg.getWidth() * pckg.getHeight();
		
		if(volume >= 100) {
			price = volume * 40;
		} else {
			price = pckg.getWeight() * 100; 
		}
		
		return price;
	}

}
