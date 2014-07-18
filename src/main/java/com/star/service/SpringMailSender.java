package com.star.service;

import org.springframework.mail.SimpleMailMessage;

public interface SpringMailSender {

	public void sendMail(String fromAddress, String toAddress, String subject, String text);
	public void sendMail(SimpleMailMessage simpleMailMessageTemple);
	public void remindMailMessage(String userName, String toAddress);
	public void remindMailMessage(String userName, String[] toAddress);
	
}
