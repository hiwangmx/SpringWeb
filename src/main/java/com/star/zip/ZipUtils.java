package com.star.zip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.star.utils.FileUtils;

public class ZipUtils {

	public File getCloudSrever(String ipAddress, String startTime,
			String endTime, String[] uuids) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		File file = null;
		try {
			HttpPost httpPost = new HttpPost("http://" + ipAddress
					+ ":8080/cloud_server/get_data/");

			String jsonStr = "{\"start_time\":\"" + startTime + "\",\""
					+ endTime + "\":\"2014-11-05 10:20:00\"";
			if (uuids != null && uuids.length > 0) {
				jsonStr += ",uuids[";
				for (String str : uuids) {
					jsonStr += "\"" + str + "\",";
				}
				jsonStr = jsonStr.substring(0, jsonStr.length() - 1) + "]";
			}
			jsonStr += "}";
			HttpEntity re = new StringEntity(jsonStr, "UTF-8");
			httpPost.setEntity(re);
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity he = response.getEntity();
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				if (he.getContentType().getValue()
						.startsWith("application/octet-stream")) {
					InputStream is = he.getContent();
					String fileName = getClass()
							.getClassLoader()
							.getResource( File.separator + "temp" + File.separator
											+ "cloud_server" + File.separator)
							.getPath() + "cloud_server_" + UUID.randomUUID() + ".zip";
					FileUtils.writeFile(is, fileName);
					file = new File(fileName);
				} else {
					// 执行错误
					String errorInfo = EntityUtils.toString(he);
					JSONObject jsonObject = new JSONObject(errorInfo);
					throw new ClientProtocolException(
							jsonObject.getString("error"));
				}
			} else {
				// 访问错误
				throw new ClientProtocolException(response.getStatusLine()
						.toString());
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
		return file;
	}
	
	public void verifyCloudServer(String ipAddress, String endTime){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			HttpPost httpPost = new HttpPost("http://" + ipAddress
					+ ":8080/cloud_server/verify/");
			String jsonStr = "{\"" + endTime + "\":\"2014-11-05 10:20:00\"" + "}";
			HttpEntity re = new StringEntity(jsonStr, "UTF-8");
			httpPost.setEntity(re);
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity he = response.getEntity();
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 执行错误
				String info = EntityUtils.toString(he);
				JSONObject jsonObject = new JSONObject(info);
				if(StringUtils.isNotEmpty(jsonObject.getString("error"))){
					throw new ClientProtocolException(jsonObject.getString("error"));
				}
			} else {
				// 访问错误
				throw new ClientProtocolException(response.getStatusLine()
						.toString());
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

}
