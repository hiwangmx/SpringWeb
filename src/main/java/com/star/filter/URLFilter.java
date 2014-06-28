package com.star.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.star.config.ConfigProperties;

public class URLFilter implements Filter{

	private Logger logger = Logger.getLogger(this.getClass());
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest servletRquest = (HttpServletRequest)request;
		String url = servletRquest.getServletPath();
		logger.debug("start filter url : " + url);
		ConfigProperties properties = new ConfigProperties();
		String[] filterUrls =  properties.getFilterUrl();
		for(String urlType : filterUrls){
			if(url.endsWith(urlType)){
				url = url.substring(0, url.length() - urlType.length()) + "action";
				break;
			}
		}
		//servletRquest.getRequestDispatcher(url).forward(request, response);
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
