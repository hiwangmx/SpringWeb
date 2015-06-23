package com.star.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class UnitCalcilatorImpl implements UnitCalculator{

	public double kilogramToPound(double kilogram) {
		double result = kilogram * 2.2;
		System.out.println(kilogram + " kilogram = " + result + " Pound");
		return result;
	}

	public double kilometerToMile(double kilometer) {
		double result = kilometer * 0.62;
		System.out.println(kilometer + " kilometer = " + result + " Mile");
		return result;
	}

}
