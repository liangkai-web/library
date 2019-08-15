package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.User;

public interface UserMapper {
	public  User getUser(User paramUser);

	public  int updateUser(Map<String, Object> paramMap);
	
	public int insert(Map<String,Object> map);
	public int update2(Map<String,Object> map);
	public int update1(Map<String,Object> map);
	public int delete(Map<String,Object> map);
	
	public User getUserInfo(User user);
	public List<User> getUserList();
	public int checkUsername(String username);

	//更新操作
	public int update(Map<String,Object> map);

	//查询单个用户
	public User getUser2(User user);
	
	public int xgUser(Map<String,Object> map);
}
