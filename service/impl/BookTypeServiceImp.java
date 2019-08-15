package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookTypeMapper;
import com.pojo.BookType;
import com.service.BookTypeService;

@Service
public class BookTypeServiceImp implements BookTypeService {
	@Autowired
	private BookTypeMapper btMapper;

	@Override
	public List<BookType> getBookTypeList() {
		
		return this.btMapper.getBookTypeList();
	}

	@Override
	public void addBookType(Map<String, Object> map) {
		btMapper.insert(map);
	}

	@Override
	public BookType getBookType(BookType booktype) {
		return btMapper.getBookType(booktype);
	}

}
