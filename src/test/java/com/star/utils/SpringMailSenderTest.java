package com.star.utils;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.star.base.BaseTest;
import com.star.service.SpringMailSender;


public class SpringMailSenderTest extends BaseTest{

	@Resource
	private SpringMailSender springMailSender;
	
	@Before
	public void init(){
		//springMailSender = (SpringMailSender)applicationContext.getBean("springMailSender");
	}
	
	@After
	public void destory(){
		
	}
	
	@Test
//	@Transactional  //使用该注释会使用事务，而且在测试完成之后会回滚事务，也就是说在该方法中做出的一切操作都不会对数据库中的数据产生任何影响  
//  @Rollback(false) //这里设置为false，就让事务不回滚
	public void testSend(){
		springMailSender.sendMail("553613627@qq.com", "593415494@qq.com", "welcome", "sss");
	}
	
	
}
