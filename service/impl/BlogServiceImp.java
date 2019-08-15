package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BlogMapper;
import com.pojo.Blog;
import com.pojo.Page;
import com.service.BlogService;

@Service
public class BlogServiceImp implements BlogService {
	@Autowired
	private BlogMapper blogMapper;

	@Override
	public List<Blog> getBorrowHistory(int uid) {
		// TODO Auto-generated method stub
		return blogMapper.getBorrowHistory(uid);
	}

	@Override
	public int updateBlog(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.blogMapper.updateBlog(map);

	}

	@Override
	public void addBLog(Map<String, Object> map) {
		blogMapper.insert(map);
	}

	@Override
	public List<Blog> getBLogList(Page page) {
		return blogMapper.getBLogList(page);
	}
	
	@Override
	public Integer searchTotalCount(Page page) {
        return blogMapper.searchTotalCount(page);
    }

}
