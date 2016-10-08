package com.application.model;

import java.util.Scanner;

public class ConverterModel {

	public double convertToCelsius(double farenheit) {
		double celsius = (farenheit-32) * (5.0/9.0);
		return celsius;
	}

	public double convertToFarenheit(double celsius) {
		double farenheit = ((celsius * (9.0/5.0)) + 32);
		return farenheit;

	}

}
