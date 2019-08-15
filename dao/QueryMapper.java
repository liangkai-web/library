package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.Item;

public interface QueryMapper {
	
	public List<Item> getBookList(Map<String,Object> map);
}
