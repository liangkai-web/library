package com.service;

import java.util.Map;

import com.pojo.BMapper;


public interface BMapperService {
	
	public int updateBMapper(Map<String, Object> map);


	//删除借阅表
	public int deleteBMapper(Map<String,Object> map);
	
	//查询单个借阅表
	public BMapper getBMapper(BMapper bmapper);


}
