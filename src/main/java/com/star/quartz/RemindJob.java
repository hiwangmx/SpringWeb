package com.star.quartz;

import java.util.Date;

import org.apache.log4j.Logger;

import com.star.utils.DateUtils;


public class RemindJob {

	private Logger logger = Logger.getLogger(this.getClass());
	
	public void remind(){
		logger.info("remind job");
		System.out.println("time is down " + DateUtils.formateDate(new Date()));
	}
	
}
