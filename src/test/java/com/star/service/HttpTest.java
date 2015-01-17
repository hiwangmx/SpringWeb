package com.star.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.star.utils.FileUtils;

public class HttpTest {

	// @Test
	public static void ddd() {
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

			// FileUtils.writeFile(is, "E://1.zip");

			FileUtils.writeFile(is, "E://1.zip");

			File file = new File("E://1.zip");
			ZipFile zipFile = new ZipFile(file);
			ZipInputStream input = new ZipInputStream(new FileInputStream(file));

			ZipEntry entity = null;
			while ((entity = input.getNextEntry()) != null) {
				BufferedReader buffered = new BufferedReader(
						new InputStreamReader(zipFile.getInputStream(entity)));
				String str = new String();
				while ((str = buffered.readLine()) != null) {
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

	public static void sss() {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			HttpPost httpPost = new HttpPost(
					"http://192.168.1.40:8080/cloud_server/get_disk_info/");
			String jsonStr = "{\"uuid\":\"1c9ae1f1-d0da-4259-9f15-309db8dcde3b \"";
			jsonStr += "}";
			HttpEntity re = new StringEntity(jsonStr, HTTP.UTF_8);
			httpPost.setEntity(re);
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity he = response.getEntity();
			System.out.println(EntityUtils.toString(he));
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

	public static void sssdd() {

		System.out.println(HttpTest.class.getClass().getResource("/"));
	}

	// @Test
	public void JsonTest() {

	}

	public static void main(String[] args) throws Exception {
		/*
		 * sssdd(); List<String> list = new ArrayList<String>();
		 * list.add("1c9ae1f1-d0da-4259-9f15-309db8dcde3b");
		 * 
		 * JSONObject jsonObject = new JSONObject();
		 * 
		 * jsonObject.put("end_time", "2014-11-21 15:56:08");
		 * jsonObject.put("uuids", list);
		 * 
		 * System.out.println(jsonObject.toString());
		 */

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(
				"http://172.16.1.127:8080/cloud_server/verify/");
		String jsonStr = "{\"end_time\":\"2014-11-21 15:56:08\"}";

		HttpEntity re = new StringEntity(jsonStr, "UTF-8");
		httpPost.setEntity(re);
		HttpResponse response = httpClient.execute(httpPost);
		HttpEntity he = response.getEntity();

	}

}
