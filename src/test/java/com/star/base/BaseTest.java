package com.star.base;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/*
 * 指定测试用例的运行器 这里是指定了Junit4
 * 
 * 如果累继承了AbstractJUnit4SpringContextTests， 不需要@RunWith(SpringJUnit4ClassRunner.class)，因为父类已经注解过了
 * 并且AbstractJUnit4SpringContextTests 实现 ApplicationContextAware
 * 
 * 如果自己实现 ApplicationContextAware， 需要 @RunWith(SpringJUnit4ClassRunner.class)，并要设置applicationContext
 */
//@RunWith(SpringJUnit4ClassRunner.class)

/* 
 * 不能使用/applicationContext*.xml
 * 指定Spring的配置文件 /为classpath下
 *  */
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:applicationContext-mail.xml",
		"classpath:applicationContext-hibernate.xml",
		"classpath:applicationContext-quertz.xml" })
public class BaseTest extends AbstractJUnit4SpringContextTests {

}
