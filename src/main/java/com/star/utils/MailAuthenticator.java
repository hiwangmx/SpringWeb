package com.star.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 邮箱用户名和密码认证
 * @author Administrator
 *
 */
public class MailAuthenticator extends Authenticator{

	private String userName;
	private String password;
	
	public MailAuthenticator() {
		// TODO Auto-generated constructor stub
	}
	
	public MailAuthenticator(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	
	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(this.userName, this.password);
	}
	
}
