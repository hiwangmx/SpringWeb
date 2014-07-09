package com.star.utils;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class NumberUtils {

	/** 接近正无穷大的舍入模式。*/
	private static final String ROUND_CEILING = "roundCeiling";
	
	/** 接近零的舍入模式。*/
	private static final String ROUND_DOWN = "roundDown";
	
	/** 接近负无穷大的舍入模式。*/
	private static final String ROUND_FLOOR = "roundFloor";
	
	/** 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为上舍入的舍入模式。*/
	private static final String ROUND_HALF_DOWN = "roundHalfDown";
	
	/** 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。*/
	private static final String ROUND_HALF_EVEN = "roundHalfEven";
	
	/** 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式。*/
	private static final String ROUND_HALF_UP = "roundHalfUp";
	
	/** 断言请求的操作具有精确的结果，因此不需要舍入。*/
	private static final String ROUND_UNNECESSARY = "roundUnnecessary";
	
	/** 舍入远离零的舍入模式。*/
	private static final String ROUND_UP = "roundUp";
	
	
	/**
	 * 格式化数字，小数点2位 
	 * @param number
	 * @return
	 */
	public static BigDecimal formateNumber(BigDecimal number){
		return number.setScale(2, BigDecimal.ROUND_DOWN);
	}
	
	public static BigDecimal formateNumber(BigDecimal number, String type, int scale){
		if(StringUtils.isNotEmpty(type) && type.equals(ROUND_CEILING)){
			return number.setScale(scale, BigDecimal.ROUND_DOWN);
		}else if(StringUtils.isNotEmpty(type) && type.equals(ROUND_DOWN)){
			return number.setScale(scale, BigDecimal.ROUND_DOWN);
		}else if(StringUtils.isNotEmpty(type) && type.equals(ROUND_FLOOR)){
			return number.setScale(scale, BigDecimal.ROUND_DOWN);
		}else if(StringUtils.isNotEmpty(type) && type.equals(ROUND_HALF_DOWN)){
			return number.setScale(scale, BigDecimal.ROUND_DOWN);
		}else if(StringUtils.isNotEmpty(type) && type.equals(ROUND_HALF_EVEN)){
			return number.setScale(scale, BigDecimal.ROUND_DOWN);
		}else if(StringUtils.isNotEmpty(type) && type.equals(ROUND_HALF_UP)){
			return number.setScale(scale, BigDecimal.ROUND_DOWN);
		}else if(StringUtils.isNotEmpty(type) && type.equals(ROUND_UNNECESSARY)){
			return number.setScale(scale, BigDecimal.ROUND_DOWN);
		}else if(StringUtils.isNotEmpty(type) && type.equals(ROUND_UP)){
			return number.setScale(scale, BigDecimal.ROUND_DOWN);
		}else{
			return number.setScale(scale, BigDecimal.ROUND_DOWN);
		}
	}
	
}
