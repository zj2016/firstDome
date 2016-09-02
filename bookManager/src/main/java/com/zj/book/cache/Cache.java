package com.zj.book.cache;

import java.util.List;

public interface Cache {

	/**
	 * 初始化redis
	 * @param url
	 * @param database
	 */
	public void init(String url, Integer database);
	
	public void put(String key, String value);
	
	public void putList(String key,List<Object> objects);
	
	public List<Object> getList(String key);
	
	public String get(String key);
	
	public boolean isEmpty(String key);
}
