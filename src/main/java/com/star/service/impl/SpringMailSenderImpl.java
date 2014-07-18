package com.star.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import com.star.service.SpringMailSender;
import com.star.utils.DateUtils;

@Repository
public class SpringMailSenderImpl implements SpringMailSender {

	private Logger logger = Logger.getLogger(getClass());

	@Resource
	private MailSender mailSender;
	@Resource
	private JavaMailSender javaMailSender;

	@Resource
	private SimpleMailMessage remindMailMessage;

	/**
	 * 根据信息发送
	 */
	public void sendMail(String fromAddress, String toAddress, String subject, String text) {
		logger.info("spring send mail");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(fromAddress);
		simpleMailMessage.setTo(toAddress);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setSentDate(new Date());
		simpleMailMessage.setText(text);
		mailSender.send(simpleMailMessage);
	}

	/**
	 * 根据原有的Message发送
	 * 
	 * @param simpleMailMessageTemple
	 */
	public void sendMail(SimpleMailMessage simpleMailMessageTemple) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage(simpleMailMessageTemple);
		mailSender.send(simpleMailMessage);
	}

	public void remindMailMessage(String userName, String toAddress) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage(remindMailMessage);
		if(StringUtils.isNotEmpty(toAddress)){
			simpleMailMessage.setTo(toAddress);
		}
		simpleMailMessage.setText(String.format(simpleMailMessage.getText(), userName, DateUtils.formateDate(new Date())));
		mailSender.send(simpleMailMessage);
	}

	public void remindMailMessage(String userName, String[] toAddress) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage(remindMailMessage);
		if(toAddress != null && toAddress.length > 0){
			simpleMailMessage.setTo(toAddress);
		}
		simpleMailMessage.setText(String.format(simpleMailMessage.getText(), userName, DateUtils.formateDate(new Date())));
		mailSender.send(simpleMailMessage);
	}

	public void sendMimeMail(String fromAddress, String toAddress, String subject, String text, String fileName, String filePath) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(fromAddress);
			helper.setTo(toAddress);
			helper.setSentDate(new Date());
			helper.setSubject(subject);
			helper.setText(text);
			ClassPathResource resource = new ClassPathResource(filePath);
			helper.addAttachment(fileName, resource);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		javaMailSender.send(mimeMessage);
	}
	
	

}
