package com.star.action;


public class IndexAction extends BaseAction{

	private static final long serialVersionUID = 1317995267656400289L;
	
	public String home(){
		return INDEX;
	}
	
	public String error404(){
		return ERROR_404;
	}
	
	public String error500(){
		return ERROR_500;
	}

}
