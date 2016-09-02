package com.zj.book.controller;


import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zj.book.bean.form.Role;
import com.zj.book.bean.form.RoleList;
import com.zj.book.cache.Cache;
import com.zj.book.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	

	@Autowired
	private BookService bookService;
	
	@Autowired
	private Cache cache;
	
	@RequestMapping("/getbooks/{title}")
	public String getBooks(@PathVariable("title") String title, ModelMap map){
		map.addAttribute("title", title);
		cache.put("title", title);
		map.addAttribute("books", bookService.findBooks());
		return "result";
	}
	
	@RequestMapping("/getbook")
	@ResponseBody
	public String getBook(){
		return "result";
	}
	
	@RequestMapping("/boxList")
	@ResponseBody
	public String checkBoxList(RoleList role){
		System.out.println("size = " + role.getRoles().size());
		
		for(Integer i : role.getRoles()){
			if(i != null){
				System.out.println(i);
			}
		}
		
		return "sum";
	}
	@RequestMapping("/boxMap")
	@ResponseBody
	public String checkBoxMap(Role role){
		System.out.println("size = " + role.getRole().size());
		
		for(Entry<String, Integer> e : role.getRole().entrySet()){
			System.out.println(e.getKey() + "   " + e.getValue());
		}
		
		return "sum";
	}
	
}
