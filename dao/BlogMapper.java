package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.Blog;
import com.pojo.Page;



public interface BlogMapper {
	
	public List<Blog> getBorrowHistory(int uid);
	
	public int updateBlog(Map<String, Object> map);

	//插入操作
	public int insert(Map<String,Object> map);
	
	//获得日志列表
	public List<Blog> getBLogList(Page page);
    
	public Integer searchTotalCount(Page page);//搜索总数量

}
