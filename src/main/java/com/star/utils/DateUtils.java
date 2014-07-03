package com.star.utils;

import java.text.DateFormat;
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
	
}
