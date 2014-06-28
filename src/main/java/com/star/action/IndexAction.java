package com.star.action;


public class IndexAction extends BaseAction{

	private static final long serialVersionUID = 1317995267656400289L;
	
	public String home(){
		System.out.println(request.getParameter("as"));
		return SUCCESS;
	}
	
	public String error404(){
		System.out.println(request.getParameter("as"));
		return SUCCESS;
	}

}
