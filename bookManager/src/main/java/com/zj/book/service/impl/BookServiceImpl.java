package com.zj.book.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zj.book.bean.Book;
import com.zj.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	public List<Book> findBooks() {
		List<Book> books = new ArrayList<Book>();
		
		//
		Book book1 = new Book(1,"大秦帝国",46);
		Book book2 = new Book(2,"亮剑",35);
		
		books.add(book1);
		books.add(book2);
		
		return books;
	}

}
