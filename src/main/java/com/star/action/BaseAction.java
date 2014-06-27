package com.star.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	protected HttpServletRequest request = ServletActionContext.getRequest();
	protected HttpSession session = request.getSession();
	protected HttpServletResponse response = ServletActionContext.getResponse();
	
	protected static final String USER_ERROR_404 = "userErro404";
	protected static final String USER_ERROR_500 = "userErro500";

}
