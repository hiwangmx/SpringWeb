package com.star.utils;

import java.io.File;

import org.apache.commons.io.FileExistsException;
import org.apache.log4j.Logger;

public class FileUtils {

	private static Logger logger = Logger.getLogger(FileUtils.class);
	
	/**
	 * 根据文件夹路径删除svn文件
	 * @param foldPath
	 * @throws FileExistsException
	 */
	public static void deleteSvnFiles(String foldPath) throws FileExistsException{
		File file = new File(foldPath);
		if(!file.isDirectory()){
			throw new FileExistsException("file is not directory");
		}else{
			deleteSvnFiles(file);
		}
	}	
	
	/**
	 * 根据文件夹删除svn文件
	 * @param file
	 */
	public static void deleteSvnFiles(File file){
		File[] files = file.listFiles();
		if(files != null && files.length > 0){
			for (File fileTmp : files) {
				if(fileTmp.isDirectory() && fileTmp.getName().equals(".svn")){
					boolean isSuccess = deleteFile(fileTmp);
					logger.info("删除" + file.getName() + "下的  .svn 文件夹" + (isSuccess ? "成功" : "失败"));
				}else if(fileTmp.isDirectory()){
					deleteSvnFiles(fileTmp);
				}
			}
		}
	}
	
	/**
	 * 删除文件
	 * :先删除文件下的所有文件
	 * @param file
	 * @return
	 */
	public static boolean deleteFile(File file){
		boolean isSuccess = true;
		File[] files = file.listFiles();
		if(files != null && files.length > 0){
			for (File fileTmp : files) {
				if(fileTmp.isDirectory()){
					isSuccess = deleteFile(fileTmp);
				}else{
					isSuccess = fileTmp.delete();
				}
				if(!isSuccess){
					break;
				}
			}
		}
		if(isSuccess){
			file.delete();
		}
		return isSuccess;
	}
}
