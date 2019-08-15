package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.User;

public interface UserService {
	public User getUser(User user);


	public int updateUser(Map<String, Object> map);
	
	public void addUser(Map<String,Object> map);


	public int updateUser1(Map<String, Object> map);
	public int updateUser2(Map<String, Object> map);
	public User getUserInfo(User user);
	public List<User> getUserList();
	public int checkUsername(String username);

	//修改用户
	public int updateUser3(Map<String,Object> map);
	
	//查询单个用户
	public User getUser2(User user);
	
	public int xgUser(Map<String,Object> map);
}
