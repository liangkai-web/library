package com.service;

import java.util.List;
import java.util.Map;


import com.pojo.Blog;
import com.pojo.Page;



public interface BlogService {
	
	public List<Blog> getBorrowHistory(int uid);
	
	public int updateBlog(Map<String, Object> paramMap);

	//添加借阅日志
	public void addBLog(Map<String,Object> map);
	
	//查询日志列表
	public List<Blog> getBLogList(Page page);
	
	public Integer searchTotalCount(Page page);
}
