package com.star.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.star.utils.CloseUtils;

public class ConfigProperties {

	private Logger logger = Logger.getLogger(this.getClass());

	public static final String FILTER_URL = "FILTER_URL";

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
}
