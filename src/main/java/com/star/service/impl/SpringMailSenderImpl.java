package com.star.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;

import com.star.service.SpringMailSender;

@Repository
public class SpringMailSenderImpl implements SpringMailSender {

	private Logger logger = Logger.getLogger(getClass());

	@Resource
	private MailSender mailSender;

	public void sendMail(String fromAddress, String toAddress, String subject,
			String text) {
		logger.info("spring send mail");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(fromAddress);
		simpleMailMessage.setTo(toAddress);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setSentDate(new Date());
		simpleMailMessage.setText(text);
		mailSender.send(simpleMailMessage);
	}

}
