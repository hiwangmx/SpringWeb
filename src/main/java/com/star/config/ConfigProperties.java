package com.star.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.star.utils.CloseUtils;

public class ConfigProperties {

	private static Logger logger = Logger.getLogger(ConfigProperties.class);

	/** 过滤路径，其他路径为非法 */
	public static final String FILTER_URL = "FILTER_URL";
	public static final String NOT_FILTER_URL = "NOT_FILTER_URL";
	
	/** mail config */
	public static final String MAIL_SMTP_HOST = "mail.smtp.host";
	public static final String MAIL_SMTP_PORT = "mail.smtp.port";
	public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
	public static final String MAIL_SMTP_SOCKET_FACTORY_CLASS = "mail.smtp.socketFactory.class";
	public static final String MAIL_SMTP_ADDRESS = "mail.smtp.address";
	public static final String MAIL_SMTP_PASSWORD = "mail.smtp.password";
	
	/** 默认时间格式 */
	public static final String DEFAULT_DATE_FORMATER = "defult.date.formater";
	
	/**
	 * 获取配置文件
	 * @return
	 */
	public static Properties getConfigProperties() {
		InputStream inputStream = null;
		Properties properties = new Properties();
		try {
			logger.debug("start get config.properties informations");
			inputStream = ConfigProperties.class.getClassLoader()
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
	public static String[] getFilterUrl() {
		Properties properties =  getConfigProperties();
		String urls = properties.getProperty(FILTER_URL);
		String[] urlArray = urls.split(",");
		return urlArray;
	}
	
	/**
	 * 需要跟换的路径
	 * @return
	 */
	public static String[] getNotFilterUrl() {
		Properties properties =  getConfigProperties();
		String urls = properties.getProperty(NOT_FILTER_URL);
		String[] urlArray = urls.split(",");
		return urlArray;
	}
	
	/**
	 * 获取值
	 * @param key
	 * @return
	 */
	public static Object getVlueByKey(Object key){
		Properties properties =  getConfigProperties();
		return properties.get(key);
	}
	
	/**
	 * 获取值
	 * @param key
	 * @return
	 */
	public static String getProperty(String key){
		Properties properties =  getConfigProperties();
		return properties.getProperty(key);
	}
}
