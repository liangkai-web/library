package com.dao;

import java.util.Map;

import com.pojo.BMapper;


public interface BMapperMapper {
	
	public int updateBMapper(Map<String, Object> paramMap);

	
	//删除操作
	public int delete(Map<String,Object> map);
	
	//查询单个映射表
	public BMapper getBMapper(BMapper bmapper);

}
