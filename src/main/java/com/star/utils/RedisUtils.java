package com.star.utils;

import java.util.ArrayList;
import java.util.List;

import com.star.bean.Chart;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {

	private static String ADDR = "127.0.0.1";
	private static int PORT = 6379;
	private static String AUTH = "admin";
	private static int MAX_ACTIVE = 1024;
	private static int MAX_IDLE = 200;
	private static int MAX_WAIT = 10000;
	private static int TIME_OUT = 10000;
	private static boolean TEST_ON_BORROW = true;
	private static JedisPool jedisPool = null;
	
	static{
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxActive(MAX_ACTIVE);
		jedisPoolConfig.setMaxIdle(MAX_IDLE);
		jedisPoolConfig.setMaxWait(MAX_WAIT);
		jedisPoolConfig.setTestOnBorrow(TEST_ON_BORROW);
		jedisPool = new JedisPool(jedisPoolConfig, ADDR, PORT, TIME_OUT, AUTH);
	}
	
	public synchronized static Jedis getJedis(){
		if(jedisPool != null){
			return jedisPool.getResource();
		}else{
			return null;
		}
	}
	
	public synchronized static void releaseJedis(final Jedis jedis){
		if(jedisPool != null){
			jedisPool.returnResource(jedis);
		}
	}
	
	public static void main(String[] args) {
		Jedis jedis =  RedisUtils.getJedis();
		
	}
	
}
