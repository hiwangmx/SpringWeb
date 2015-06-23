package com.star.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.star.base.BaseTest;
import com.star.pojo.ArithmeticCalculator;
import com.star.pojo.UnitCalculator;

public class AspectTest extends BaseTest{

	@Resource
	private ArithmeticCalculator arithmeticCalculator;
	@Resource
	private UnitCalculator unitCalculator;
	
	@Test
	public void calculatorTest() throws IllegalAccessException{
		arithmeticCalculator.add(1, 2);
		arithmeticCalculator.mul(1, 2);
		arithmeticCalculator.div(1, 2);
		arithmeticCalculator.sub(1, 2);
		
		unitCalculator.kilogramToPound(10);
		unitCalculator.kilometerToMile(11);
	}
	
}
