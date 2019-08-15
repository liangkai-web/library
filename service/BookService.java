package com.service;

import java.util.Map;

import com.pojo.Book;


public interface BookService {
	public int updateBookStatus(Map<String, Object> map);

	//添加图书
		public void addBook(Map<String,Object> map);
		
		//删除图书
		public int deleteBook(Map<String,Object> map);
		
		//更新图书
		public int updateBook(Map<String,Object> map);
		
		//查询单个图书
		public Book getBook(Book book);

}
