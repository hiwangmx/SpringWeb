package com.star.service;

public interface SpringMailSender {

	public void sendMail(String fromAddress, String toAddress, String subject, String text);
	
}
