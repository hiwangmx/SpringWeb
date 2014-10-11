package com.star.lucene;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileExistsException;

import com.star.utils.FileUtils;



public class TestIndexFile {

	public static void main(String[] args) {
		/*Long size = 164278272L + 1024*1024*1024 + 1024*1024*1024 +1;
		Long formatSize = size / (1024L * 1024L * 1024L);
		System.out.println(formatSize);
		
		Double memory = Double.valueOf("1023") / 1024;
		System.out.println(memory);
		
		BigDecimal bigD = new BigDecimal(memory);
		
		memory = bigD.setScale(0, BigDecimal.ROUND_DOWN).doubleValue();
		
		System.out.println(memory.intValue());
		
		//System.out.println(new Random().nextInt(10) + new Random().nextInt(10) + new Random().nextInt(10));
		
		//System.out.println(System.getProperty("file.encoding"));*/
		
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		
		
		
		String str = "2014-09-23T02:12:16.000000";
		System.out.println(str.length());
		str = str.substring(0, 19) + "UTC";
		System.out.println(str);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");  
		try {
			Date dt = sdf.parse(str);
			System.out.println(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		/*Calendar cal = Calendar.getInstance();
		System.out.println(cal.toString());
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, -15);
        System.out.println(cal);
        System.out.println(cal.compareTo(Calendar.getInstance()));*/
		
		try {
			FileUtils.deleteSvnFiles("E://新建文件夹");
		} catch (FileExistsException e) {
			e.printStackTrace();
		}
		
	}
	
}
