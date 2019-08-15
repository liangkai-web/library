package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.BookType;

public interface BookTypeMapper {
	
	public List<BookType> getBookTypeList();

	//添加操作
	public int insert(Map<String,Object> map);
		
	//查询单个书类
	public BookType getBookType(BookType booktype);

}
