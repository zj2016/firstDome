package com.zj.book.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zj.book.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/getbooks/{title}")
	public String getBooks(@PathVariable("title") String title, ModelMap map){
		map.addAttribute("title", title);
		map.addAttribute("books", bookService.findBooks());
		return "result";
	}
	
	@RequestMapping("/getbook")
	@ResponseBody
	public String getBook(){
		return "result";
	}
	
}
