package com.star.aspect;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

import com.star.annotation.LogAnnotation;

@Component
@Aspect
public class CalculatorLoggingAspect {

	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * 前置通知
	 * * 表示匹配任何修饰符（public、protected和private）和任何返回类型
	 * 两个点表示匹配任何数量的参数
	 */
	@Before("execution(* com.star.pojo.ArithmeticCalculator.add(..))")
	public void logBefore(){
		//log.info("the method add() begins"); 
	}
	
	/**
	 * 前置通知
	 * @param joinPoint
	 */
	@Before("execution(* com.star.pojo.ArithmeticCalculator.*(..))")
	public void logBefore(JoinPoint joinPoint){
		Object object = joinPoint.getTarget();
		Class<?> clazz = object.getClass();
		try {
			Method method = clazz.getDeclaredMethod(joinPoint.getSignature().getName(), double.class, double.class);
			LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
			System.out.println(logAnnotation.value());
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
		}
		log.info("the method " + joinPoint.getSignature().getName() + "() begins  @Before"); 
	}
	
	/**
	 * 后置通知
	 * @param joinPoint
	 */
	@After("execution(* com.star.pojo.ArithmeticCalculator.*(..))")
	public void logAfter(JoinPoint joinPoint){
		log.info("the method " + joinPoint.getSignature().getName() + "() begins  @After"); 
	}
	
	/**
	 * 后置通知
	 * @param joinPoint
	 */
	@AfterReturning("execution(* com.star.pojo.ArithmeticCalculator.*(..))")
	public void logAfterReturing(JoinPoint joinPoint){
		log.info("the method " + joinPoint.getSignature().getName() + "() end @AfterReturning"); 
	}
	
}
