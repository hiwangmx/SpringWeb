package com.star.utils;

import java.util.Date;

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
		DateUtils.formateDate(new Date());
	}
	
}
