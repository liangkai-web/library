package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.pojo.User;
import com.service.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserMapper userMapper;


	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.getUser(user);
	}

	@Override
	public int updateUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.userMapper.updateUser(map);
	}
	
	public void addUser(Map<String,Object> map) {		
		userMapper.insert(map);
	}	
	

	
	public int updateUser1(Map<String, Object> map) {
		return userMapper.update1(map);
	}	
	public int updateUser2(Map<String, Object> map) {
		return userMapper.update2(map);
	}	
	
	public int xgUser(Map<String, Object> map) {
		return userMapper.xgUser(map);
	}
	
	public User getUserInfo(User user) {
		return this.userMapper.getUserInfo(user);
	}
	
	public List<User> getUserList(){
		return this.userMapper.getUserList();
	}
	public int checkUsername(String username) {
		return userMapper.checkUsername(username);
	}

	@Override
	public int updateUser3(Map<String, Object> map) {
		return userMapper.update(map);
	}

	@Override
	public User getUser2(User user) {
		return userMapper.getUser2(user);
	}


}
