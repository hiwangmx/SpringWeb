package com.star.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import junit.framework.TestCase;

public class DateUtilsTest extends TestCase{

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	public void testFormatDate(){
		String str = DateUtils.formateDate(new Date());
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		TimeZone time = TimeZone.getTimeZone("GMT-8");
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-8"));
		cal.setTimeZone(TimeZone.getTimeZone("GMT-8"));
		System.out.println(time.getID() + "");
	}
	
}
