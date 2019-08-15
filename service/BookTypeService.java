package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.BookType;


public interface BookTypeService {
	
	public List<BookType> getBookTypeList();

	//添加书类
	public void addBookType(Map<String,Object> map);

	//查询单个书类
	public BookType getBookType(BookType booktype);
}
