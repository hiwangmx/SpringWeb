package com.star.utils;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

public class ZipUtils {

	/**
	 * 解压文件 根据编码
	 * @param fileName
	 * @param toDirectory
	 */
	public static void unZipFile(String fileName, String toDirectory, String encoding){
		ZipFile zipFile = null;
		try {
			File file = new File(fileName);
			zipFile = new ZipFile(file, encoding);
			Enumeration<?> zipEntrys =  zipFile.getEntries();
			while( zipEntrys.hasMoreElements() ){
				ZipEntry entry = (ZipEntry) zipEntrys.nextElement();
				System.out.println(entry.getName());
				if(!entry.isDirectory()){
					FileUtils.writeFile(zipFile.getInputStream(entry), toDirectory + File.separator + entry.getName());
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			CloseUtils.close(zipFile);
		}
		
	}
	
	/**
	 * 解压文件，默认编码 gbk
	 * @param fileName
	 * @param toDirectory
	 */
	public static void unZipFile(String fileName, String toDirectory){
		unZipFile(fileName, toDirectory, "gbk");
	}
	
}
