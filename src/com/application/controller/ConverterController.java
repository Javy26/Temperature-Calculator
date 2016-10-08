package com.application.controller;

import com.application.model.ConverterModel;
import com.application.view.ConverterView;

public class ConverterController {
	private ConverterModel converterModel;
	private ConverterView controllerView;

	
	ConverterController(){
		
		converterModel = new ConverterModel();
		controllerView = new ConverterView(this);
	}
	
	public void convertTemp(String toConvert, String value) {		
		if(toConvert.equals("celsius")) {
			controllerView.updateResult(String.valueOf(converterModel.convertToCelsius(Double.parseDouble(value))));
		} else if(toConvert.equals("fahrenheit")){
			controllerView.updateResult(String.valueOf(converterModel.convertToFarenheit(Double.parseDouble(value))));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 new ConverterController();
	}

}
