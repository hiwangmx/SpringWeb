package com.star.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.star.utils.CloseUtils;

public class ConfigProperties {

	private Logger logger = Logger.getLogger(this.getClass());

	/** 过滤路径，其他路径为非法 */
	public static final String FILTER_URL = "FILTER_URL";
	/** mail config */
	public static final String MAIL_SMTP_HOST = "mail.smtp.host";
	public static final String MAIL_SMTP_PORT = "mail.smtp.port";
	public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
	public static final String MAIL_SMTP_SOCKET_FACTORY_CLASS = "mail.smtp.socketFactory.class";
	public static final String MAIL_SMTP_ADDRESS = "mail.smtp.address";
	public static final String MAIL_SMTP_PASSWORD = "mail.smtp.password";
	
	/**
	 * 获取配置文件
	 * @return
	 */
	public Properties getConfigProperties() {
		InputStream inputStream = null;
		Properties properties = new Properties();
		try {
			logger.debug("start get config.properties informations");
			inputStream = this.getClass().getClassLoader()
					.getResourceAsStream("config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseUtils.close(inputStream);
		}
		return properties;
	}

	/**
	 * 需要跟换的路径
	 * @return
	 */
	public String[] getFilterUrl() {
		Properties properties =  this.getConfigProperties();
		String urls = properties.getProperty(FILTER_URL);
		String[] urlArray = urls.split(",");
		return urlArray;
	}
	
	/**
	 * 获取值
	 * @param key
	 * @return
	 */
	public Object getVlueByKey(Object key){
		Properties properties =  this.getConfigProperties();
		return properties.get(key);
	}
	
	/**
	 * 获取值
	 * @param key
	 * @return
	 */
	public String getProperty(String key){
		Properties properties =  this.getConfigProperties();
		return properties.getProperty(key);
	}
}
