package com.zj.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zj.book.service.SeckillService;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

	@Autowired
	private SeckillService seckillService;
	
	@RequestMapping("/list")
	public String list(ModelMap map){
		map.addAttribute("seckillList", seckillService.getSeckillList());
		return "result";
	}
	
}
