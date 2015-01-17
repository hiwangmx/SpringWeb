package com.star.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

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
	 List<ZipData> zipData = zipDataService.find();

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
