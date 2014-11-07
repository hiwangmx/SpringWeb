package com.star.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.star.base.BaseTest;
import com.star.bean.ZipData;

public class ZipDataTest extends BaseTest {

	@Resource
	private ZipDataService zipDataService;

	@Before
	public void init() {
		/*
		 * 这里使用了注解方式，不用注解可以使用下面
		 */
		// springMailSender =
		// (SpringMailSender)applicationContext.getBean("springMailSender");
	}

	@After
	public void destory() {

	}

	public void add() {
		ZipData zipData = new ZipData();
		zipData.setId("1");
		zipData.setCpu(new BigInteger("1111"));
		zipData.setExtime(new Date());
		zipData.setMemory(new BigInteger("2222"));
		zipData.setName("sadsd");
		zipData.setPid("12");
		zipData.setState(1);
		zipDataService.add(zipData);
	}

	@Test
	public void addBatch() {
		// List<ZipData> zipData = zipDataService.find();

		// zipDataService.threadAdd("E://进程监控（服务，端口，进程）.zip");

	}

	class MyThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			long startTime = System.currentTimeMillis();
			zipDataService.addBatch("E://进程监控（服务，端口，进程）.zip");
			long endTime = System.currentTimeMillis();
			System.out.println("运行时间：" + (endTime - startTime) / 1000 + "s");
		}

	}

}
