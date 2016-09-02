package com.zj.book.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zj.book.bean.Seckill;
import com.zj.book.cache.Cache;
import com.zj.book.mapper.SeckillMapper;
import com.zj.book.service.SeckillService;

@Service
public class SeckillServiceImpl implements SeckillService {

	@Autowired
	private SeckillMapper seckillMapper;
	
	@Autowired
	private Cache cache;
	
	public List<Seckill> getSeckillList() {
		
		ObjectMapper object = new ObjectMapper();
		
		String key = "seckills";
		List<Seckill> seckills = null;
		String json = null;
		if(cache.isEmpty(key)){
			seckills = seckillMapper.findList();
			
			try {
				json = object.writeValueAsString(seckills);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cache.put(key, json);
			
		}else{
			json = cache.get(key);
			try {
				seckills = object.readValue(json,List.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(json);
		return seckills;
	}

}
