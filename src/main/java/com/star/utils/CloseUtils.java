package com.star.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.lucene.index.IndexWriter;
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
	
	/**
	 * 关闭BufferedReader
	 * @param reader
	 */
	public static void close(BufferedReader reader){
		if(reader != null){
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭InputStreamReader
	 * @param inputStreamReader
	 */
	public static void close(InputStreamReader inputStreamReader){
		if(inputStreamReader != null){
			try {
				inputStreamReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭 IndexWriter
	 * @param indexWriter
	 */
	public static void close(IndexWriter indexWriter){
		if(indexWriter != null){
			try {
				indexWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
