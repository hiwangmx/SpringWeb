package com.star.utils;

import java.io.IOException;
import java.io.InputStream;

import org.hibernate.Session;

public class CloseUtils {

	/**
	 * close inputstream
	 * @param inputStream
	 */
	public static void close(InputStream inputStream){
		if(inputStream != null){
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭hibernate session
	 * @param session
	 */
	public static void close(Session session){
		if(session != null){
			session.close();
		}
	}
	
}
