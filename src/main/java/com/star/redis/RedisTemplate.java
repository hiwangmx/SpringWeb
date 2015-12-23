package com.star.redis;

import java.util.Map;
import java.util.Set;

import com.star.redis.utils.RedisUtils;
import com.star.utils.ClassUtils;

import redis.clients.jedis.Jedis;

/**
 *
 * @author: 王明星(WangMingXing)
 * @En_Name: Star.Wang
 * @E-mail: hiwangmx@gmail.com
 * @version: normal
 * @Created Time: 2015年12月23日 上午10:34:09
 * @Description:
 *
 **/

public class RedisTemplate {
	
	private static final RedisTemplate redisTemplate = new RedisTemplate();
	public Jedis jedis;
	
	private String REDIS_HOST = "127.0.0.1";
	private int REDIS_PORT = 6379;
	
	private RedisTemplate(){
		jedis = new Jedis(REDIS_HOST, REDIS_PORT);
	}
	
	public static RedisTemplate getInstance(){
		return redisTemplate;
	}
	
	public void add(Object object) throws IllegalArgumentException, IllegalAccessException{
		Map<String, String> map = RedisUtils.getMap(object);
		jedis.hmset(RedisUtils.gecKey(object), map);
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		RedisTemplate redisTemplate = RedisTemplate.getInstance();
		User user = new User();
		user.setUserName("nnn");
		user.setPassword("sdsd");
		user.setMail("ass@qq.com");
		user.setMobile("121212");
		user.setQq("5566464646");
		//redisTemplate.add(user);
		
		Set<String> set = redisTemplate.jedis.keys("star:user:*");
		System.out.println(set);
		
		
	}

}
