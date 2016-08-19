package com.zj.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zj.book.bean.Seckill;
import com.zj.book.mapper.SeckillMapper;
import com.zj.book.service.SeckillService;

@Service
public class SeckillServiceImpl implements SeckillService {

	@Autowired
	private SeckillMapper seckillMapper;
	
	public List<Seckill> getSeckillList() {
		return seckillMapper.findList();
	}

}
