package com.star.pojo;

import org.springframework.stereotype.Repository;

import com.star.annotation.LogAnnotation;

@Repository
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@LogAnnotation("正在执行计算器添加操作")
	public double add(double a, double b) {
		double result = a + b;
		System.out.println("a + b = " + result);
		return result;
	}

	@LogAnnotation("正在执行计算器减操作")
	public double sub(double a, double b) {
		double result = a - b;
		System.out.println("a - b = " + result);
		return result;
	}

	public double mul(double a, double b) {
		double result = a * b;
		System.out.println("a * b = " + result);
		return result;
	}

	public double div(double a, double b) throws IllegalAccessException {
		if (b == 0) {
			throw new IllegalAccessException("Division by zero");
		}
		double result = a / b;
		System.out.println("a / b = " + result);
		return result;
	}

}
