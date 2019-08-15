package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.Item;

public interface QueryBookService {
	
	public List<Item> getBookList(Map<String,Object> map);

}
