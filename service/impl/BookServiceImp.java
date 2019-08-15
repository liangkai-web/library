package com.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookMapper;
import com.pojo.Book;
import com.service.BookService;

@Service
public class BookServiceImp implements BookService {
	
	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public int updateBookStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.bookMapper.updateBookStatus(map);

	}

	@Override
	public void addBook(Map<String, Object> map) {
		bookMapper.insert(map);
	}

	@Override
	public int deleteBook(Map<String, Object> map) {
		return bookMapper.delete(map);
	}

	@Override
	public int updateBook(Map<String, Object> map) {
		return bookMapper.update(map);
	}

	@Override
	public Book getBook(Book book) {
		return bookMapper.getBook(book);
	}

}
