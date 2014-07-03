package com.star.quartz;

import java.util.Date;

import com.star.utils.DateUtils;


public class RemindJob {

	public void remind(){
		System.out.println("time is down " + DateUtils.formateDate(new Date()));
	}
	
}
