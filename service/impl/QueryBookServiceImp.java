package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.QueryMapper;
import com.pojo.Item;
import com.service.QueryBookService;

@Service
public class QueryBookServiceImp implements QueryBookService{
	@Autowired
	private QueryMapper queryMapper;

	@Override
	public List<Item> getBookList(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return queryMapper.getBookList(map);
	}

}
