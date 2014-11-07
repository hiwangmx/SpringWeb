package com.star.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.star.utils.FileUtils;

public class HttpTest{

	//@Test
	public void ddd(){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			HttpPost httpPost = new HttpPost(
					"http://192.168.1.40:8080/cloud_server/get_data/");
			String jsonStr = "{\"start_time\":\"2014-10-27 10:20:00\",\"end_time\":\"2014-11-05 10:20:00\"";
			jsonStr += "}";
			HttpEntity re = new StringEntity(jsonStr, HTTP.UTF_8);
			httpPost.setEntity(re);
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity he = response.getEntity();
			
			System.out.println(he.getContentType().getValue());
			InputStream is = he.getContent();
			
			
			
			//FileUtils.writeFile(is, "E://1.zip");
			
			FileUtils.writeFile(is, "E://1.zip");
			
			File file = new File("E://1.zip");
			ZipFile zipFile = new ZipFile(file);
			ZipInputStream input = new ZipInputStream(new FileInputStream(file));
			
			ZipEntry entity = null;
			while((entity = input.getNextEntry()) != null){
				BufferedReader buffered = new BufferedReader(new InputStreamReader( zipFile.getInputStream(entity)));
				String str = new String();
				while((str = buffered.readLine()) != null){
					System.out.println(buffered.readLine());
				}
				System.out.println(entity.getName());
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}
	
	//@Test
	public void JsonTest(){
		
	}
	
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1970, 1, 1, 0, 0, 0);
		
		
		System.out.println(calendar.getTimeInMillis());
		
		System.out.println(ArrayUtils.toString(TimeZone.getAvailableIDs(8)) );
		System.out.println(calendar.getTimeZone().getDisplayName());
		
		calendar.setTimeInMillis(2678400000l);
		System.out.println(calendar.getTimeInMillis());
		System.out.println(calendar.getTime());
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.append("name", "data1");

		System.out.println(jsonObject.toString());
	}
	
}
