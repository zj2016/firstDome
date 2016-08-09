package com.zj.book.service;

import java.util.List;

import com.zj.book.bean.Book;

public interface BookService {

	/**
	 * 查询全部书籍
	 * @return
	 */
	public List<Book> findBooks();
}
