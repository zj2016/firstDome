package com.zj.book.cache.impl;

import java.util.List;

import com.zj.book.cache.Cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisCache implements Cache{

	private JedisPool jedisPool;
	
	public void init(String url, Integer database) {

		String[] hostStuff = url.split(":");
		
		String hostName = hostStuff[0];
		Integer hostPort = Integer.valueOf(hostStuff[1]);
		
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(100);
		jedisPoolConfig.setMinIdle(10);
		jedisPoolConfig.setMaxIdle(20);
		jedisPoolConfig.setMaxWaitMillis(1500);
		jedisPoolConfig.setTestOnBorrow(true);
		jedisPoolConfig.setTestWhileIdle(true);
		
		jedisPool = new JedisPool(jedisPoolConfig, hostName, hostPort, 3000, null, database);
	}

	public void put(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(key, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(jedis != null){
				jedis.close();
			}
		}
		
	}

	public String get(String key) {
		
		Jedis jedis = null;
		
		try {
			jedis = getJedis();
			return jedis.get(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
		
		return null;
	}

	private Jedis getJedis(){
		return jedisPool.getResource();
	}

	public void putList(String key, List<Object> objects) {
		
	}

	public List<Object> getList(String key) {
		return null;
	}

	public boolean isEmpty(String key) {
		Jedis jedis = null;
		
		try {
			jedis = getJedis();
			return jedis.exists(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
		return false;
	}
}
