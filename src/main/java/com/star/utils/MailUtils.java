package com.star.utils;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.star.base.BaseException;
import com.star.config.ConfigProperties;

/**
 * 发送邮件
 * @author 王明星 star
 *
 */
public class MailUtils {

	private static Logger logger = Logger.getLogger(MailUtils.class);
	
	/**
	 * 发送邮件
	 * @param subject
	 * @param html
	 * @param toAddressStr
	 * @param attachFiles
	 */
	public static void sendHtmlMail(String subject, String html, String[] toAddressStr, String[] attachFiles){
		logger.info("send mail : " + subject + " " + html);
		MailAuthenticator mailAuthenticator = null;
		try {
			Properties properties = getMailProperties();
			String address = properties.getProperty(ConfigProperties.MAIL_SMTP_ADDRESS);
			String password = properties.getProperty(ConfigProperties.MAIL_SMTP_PASSWORD);
			if(Boolean.valueOf(properties.getProperty(ConfigProperties.MAIL_SMTP_AUTH))){
				mailAuthenticator = new MailAuthenticator(address, password);
			}else{
				throw new BaseException("auth is needed");
			}
			Session session = Session.getDefaultInstance(properties, mailAuthenticator);
			//发送地址，可以为多个
			Address[] toAddress = new Address[toAddressStr.length];
			for(int index = 0;index < toAddressStr.length;index ++ ){
				logger.info("address : " + toAddressStr[index]);
				toAddress[index] = new InternetAddress(toAddressStr[index]);
			}
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(address));
			message.setRecipients(RecipientType.TO, toAddress);
			message.setSubject(subject);
			message.setSentDate(new Date()); 
			
			//添加内容
			Multipart mulitiPart = new MimeMultipart();
			BodyPart bodyPart = new MimeBodyPart();
			bodyPart.setContent(html, "text/html;charset=utf-8");
			mulitiPart.addBodyPart(bodyPart, 0);
			
			//添加附件
			for(int index = 0;attachFiles!=null && index<attachFiles.length;index++){
				logger.info("file : " + attachFiles[index]);
				BodyPart attachPart = new MimeBodyPart();
				File file = new File(attachFiles[index]);
				if(file.exists()){
					DataSource dataSource = new FileDataSource(file);
					attachPart.setDataHandler(new DataHandler(dataSource));
					attachPart.setFileName(attachFiles[index]);
					mulitiPart.addBodyPart(attachPart, index+1);
				}
			}
			
			message.setContent(mulitiPart);
			Transport.send(message);
			logger.info("end send mail ");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送邮件（单个地址，有附件）
	 * @param subject
	 * @param html
	 * @param toAddressStr
	 * @param attachFiles
	 */
	public static void sendHtmlMail(String subject, String html, String toAddressStr, String[] attachFiles){
		sendHtmlMail(subject, html, new String[]{toAddressStr}, attachFiles);
	}
	
	/**
	 * 发送邮件（单个地址，无附件）
	 * @param subject
	 * @param html
	 * @param toAddressStr
	 * @param attachFiles
	 */
	public static void sendHtmlMail(String subject, String html, String toAddressStr){
		sendHtmlMail(subject, html, new String[]{toAddressStr}, null);
	}
	
	/**
	 * 发送邮件（单个地址，单个附件）
	 * @param subject
	 * @param html
	 * @param toAddressStr
	 * @param filePath
	 */
	public static void sendHtmlMail(String subject, String html, String toAddressStr, String filePath){
		sendHtmlMail(subject, html, new String[]{toAddressStr}, new String[]{filePath});
	}
	
	/**
	 * 异步发送邮件
	 * @param subject
	 * @param html
	 * @param toAddressStr
	 * @param attachFiles
	 */
	public static void sendMailAsynchronous(final String subject, final String html, final String[] toAddressStr, final String[] attachFiles){
		new Thread(new Runnable() {
			
			public void run() {
				sendHtmlMail(subject, html, toAddressStr, attachFiles);
			}
		});
	}
	
	/**
	 * 异步发送邮件（单个地址，单个附件）
	 * @param subjec
	 * @param html
	 * @param toAddressStr
	 * @param attachFiles
	 */
	public static void sendMailAsynchronous(String subjec, String html, String toAddressStr, String attachFiles){
		sendMailAsynchronous(subjec, html, new String[]{toAddressStr}, new String[]{attachFiles});
	}
	
	/**
	 * 获取基本邮件Perperties
	 * @return
	 */
	public static Properties getMailProperties(){
		Properties properties = new Properties();
		ConfigProperties configProperties = new ConfigProperties();
		properties.setProperty(ConfigProperties.MAIL_SMTP_HOST, configProperties.getProperty(ConfigProperties.MAIL_SMTP_HOST));
		properties.setProperty(ConfigProperties.MAIL_SMTP_PORT, configProperties.getProperty(ConfigProperties.MAIL_SMTP_PORT));
		properties.setProperty(ConfigProperties.MAIL_SMTP_AUTH, configProperties.getProperty(ConfigProperties.MAIL_SMTP_AUTH));
		properties.setProperty(ConfigProperties.MAIL_TRANSPORT_PROTOCOL, configProperties.getProperty(ConfigProperties.MAIL_TRANSPORT_PROTOCOL));
		properties.setProperty(ConfigProperties.MAIL_SMTP_SOCKET_FACTORY_CLASS, configProperties.getProperty(ConfigProperties.MAIL_SMTP_SOCKET_FACTORY_CLASS));
		properties.setProperty(ConfigProperties.MAIL_SMTP_ADDRESS, configProperties.getProperty(ConfigProperties.MAIL_SMTP_ADDRESS));
		properties.setProperty(ConfigProperties.MAIL_SMTP_PASSWORD, configProperties.getProperty(ConfigProperties.MAIL_SMTP_PASSWORD));
		return properties;
	}
	 
	public static void main(String[] args) {
		sendMailAsynchronous("sdsd", "sdsd", "593415494@qq.com", "E:\\11.pdf");
	}
	
}
