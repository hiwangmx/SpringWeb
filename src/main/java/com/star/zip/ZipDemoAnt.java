package com.star.zip;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

public class ZipDemoAnt {

	public static void unzipFile(String fileName) throws Exception{
		
		File file = new File(fileName);
		ZipFile zipFile = new ZipFile(file, "gbk");
		Enumeration<ZipEntry> zipEntrys =  zipFile.getEntries();
		while( zipEntrys.hasMoreElements() ){
			ZipEntry entry = zipEntrys.nextElement();
			System.out.println(entry.getName());
			if(!entry.isDirectory()){
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entry)));
				String sb = "";
				while(( sb = bufferedReader.readLine()) != null){
					String[] sigleStr = sb.split("\t");
					for(String tmpStr : sigleStr){
						System.out.println(tmpStr);
					}
					//System.out.println(sb);
					sb = "";
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();
			unzipFile("E://进程监控（服务，端口，进程）.zip");
			long endTime = System.currentTimeMillis();
			System.out.println("运行时间：" + (endTime - startTime )/1000 + "s");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//ZipUtils.unZipFile("E://workdoc//软考.zip", "E://是的");
	}
	
}
