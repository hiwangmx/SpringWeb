package com.star.processor;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.InitializingBean;

public class InitDataProcessor implements InitializingBean,SessionAware{

	private Map<String, Object> session;
	
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
