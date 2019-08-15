package com.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BMapperMapper;
import com.pojo.BMapper;
import com.service.BMapperService;

@Service
public class BMapperServiceImp implements BMapperService {
	
	@Autowired
	private BMapperMapper bMapperMapper;

	@Override
	public int updateBMapper(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.bMapperMapper.updateBMapper(map);

	}

	@Override
	public int deleteBMapper(Map<String, Object> map) {
		return bMapperMapper.delete(map);
	}

	@Override
	public BMapper getBMapper(BMapper bmapper) {
		return bMapperMapper.getBMapper(bmapper);
	}

}
