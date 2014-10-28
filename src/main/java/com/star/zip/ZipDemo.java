package com.star.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

public class ZipDemo {

	public static void unzipFile(String fileName) throws ZipException, IOException{
		File file = new File(fileName);
		ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file), Charset.forName("UTF-8"));
		ZipEntry entry = null;
		while((entry = zipInput.getNextEntry()) != null){
			System.out.println(entry.getName());
		}
	}
	
	public static void main(String[] args) {
		try {
			unzipFile("E://workdoc//openStack.zip");
		} catch (ZipException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
