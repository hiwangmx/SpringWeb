package com.star.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.star.config.ConfigProperties;

public class URLFilter implements Filter{

	private Logger logger = Logger.getLogger(this.getClass());
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 只能使用对应的过滤url
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest servletRquest = (HttpServletRequest)request;
		String url = servletRquest.getServletPath();
		logger.info("start filter url : " + url);
		if(StringUtils.isEmpty(url) || url.equals("/")){
			url = "/index_home.html";
		}
		boolean isNotFilterFlag = false;
		String[] notFilterUrls = ConfigProperties.getNotFilterUrl();
		for(String urlType : notFilterUrls){
			if(url.endsWith(urlType)){
				servletRquest.getRequestDispatcher(url).forward(request, response);
				isNotFilterFlag = true;
				break;
			}
		}
		if(url.indexOf("websocket") >=0 ){
			isNotFilterFlag = true;
		}
		
		if(isNotFilterFlag){
			filterChain.doFilter(request, response);
		}else{
			boolean isReplaceUrl = false;
			String[] filterUrls =  ConfigProperties.getFilterUrl();
			for(String urlType : filterUrls){
				if(url.endsWith(urlType)){
					url = url.substring(0, url.length() - urlType.length()) + "action";
					isReplaceUrl = true;
					break;
				}
			}
			logger.info("start url : " + url);
			if(isReplaceUrl){
				servletRquest.getRequestDispatcher(url).forward(request, response);
			}else{
				servletRquest.getRequestDispatcher("index_error404.action").forward(request, response);
			}
		}
		
		//filterChain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
