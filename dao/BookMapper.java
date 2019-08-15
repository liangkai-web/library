package com.dao;

import java.util.Map;

import com.pojo.Book;


public interface BookMapper {
	
	public int updateBookStatus(Map<String, Object> map);

	//添加操作
	public int insert(Map<String,Object> map);
	
	//删除操作
	public int delete(Map<String,Object> map);
	
	//更新操作
	public int update(Map<String,Object> map);
	
	//获取单本书
	public Book getBook(Book book);

}
