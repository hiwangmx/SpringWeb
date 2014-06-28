package com.star.utils;

import java.io.IOException;
import java.io.InputStream;

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
	
}
