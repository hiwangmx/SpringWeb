package com.star.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.star.config.ConfigProperties;

public class DateUtils {

	/**
	 * 格式化时间 date -> string
	 * @param date
	 * @param formater
	 * @return
	 */
	public static String formateDate(Date date, String formater){
		DateFormat dateFormat = new SimpleDateFormat(formater);
		String dateStr = dateFormat.format(date);
		return dateStr;
	}
	
	/**
	 * 默认格式化时间
	 * @param date
	 * @return
	 */
	public static String formateDate(Date date){
		return formateDate(date, ConfigProperties.getProperty(ConfigProperties.DEFAULT_DATE_FORMATER));
	}
	
	public static Date formateDate(String dateStr, String formater){
		DateFormat dateFormat = new SimpleDateFormat(formater);
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date formateDate(String dateStr){
		return formateDate(dateStr, ConfigProperties.getProperty(ConfigProperties.DEFAULT_DATE_FORMATER));
	}
}
