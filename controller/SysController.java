package com.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.User;
import com.service.UserService;

@Controller
@RequestMapping("/granduser")
public class SysController {
 
	@Autowired
	UserService userService;
		
	@RequestMapping("/add")
	public String addUser() {
		return "addUser";
	}
	
	@RequestMapping("/up")
	public String up(){
		return "isvalid";
	}
	
	@RequestMapping("/can")
	public String can(){
		return "kjnum";
	}
	
	@RequestMapping("/frmtop")
	public String frmtop(){
		return "frmtop";
	}
	@RequestMapping("/frmleft")
	public String frmleft(){
		return "adminfrmleft";
	}
	@RequestMapping("/frmcon")
	public String frmcontext(){
		return "adminfrmcon";
	}

	
	@RequestMapping("/addUser")
	public String addUser(User user,@RequestParam("username")String username,Model model) {//�����û�
		int count = userService.checkUsername(username);
		
		if(count==0) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("username",username);
		if(username == "" || username.equals(null)){
			model.addAttribute("msg", "用户名不能为空"); 
			return "addUser";
		}else {
			map.put("password", user.getPassword());
			map.put("uid", user.getUid());
			map.put("phone", user.getPhone());
			map.put("type", user.getType());
			map.put("regtime", new Date());
			map.put("isvalid", 1);
			map.put("kjnum", 5);
			map.put("yjnum", 0);
			map.put("fine", 0);
			this.userService.addUser(map);
			model.addAttribute("msg", "注册成功");
			return "addUser";
		}
		}else {
			model.addAttribute("msg", "用户名已存在");
			return "addUser";
		}
	}
	
	@RequestMapping("/updateUser")
	String updateUser(User user,@RequestParam("username")String username,Model model) {
		int count = userService.checkUsername(username);
		if(count!= 0) {
		Map<String,Object> map = new HashMap<String,Object>();
	
		map.put("username", user.getUsername());
		if(username == "" || username.equals(null)){
			model.addAttribute("msg", "用户名不能为空"); 
			return "isvalid";
		}else {
		map.put("isvalid", user.getIsvalid());
		this.userService.updateUser2(map);
		model.addAttribute("msg", "修改成功");
		return "isvalid";
	   }
		}else {
		model.addAttribute("msg", "用户名不存在");
		return "isvalid";
	}
}
	
	@RequestMapping("/cankj")
	String cankj(User user,@RequestParam("username")String username,Model model) {
		int count = userService.checkUsername(username);
		if(count!=0) {
		Map<String,Object> map = new HashMap<String,Object>();
	
		map.put("username", user.getUsername());
		if(username == "" || username.equals(null)){
			model.addAttribute("msg", "用户名不能为空"); 
			return "kjnum";
		}else {
		map.put("kjnum", user.getKjnum());
		this.userService.updateUser1(map);
		model.addAttribute("msg", "修改成功");
		return "kjnum";
	}
		}else {
			model.addAttribute("msg", "用户名不存在");
			return "kjnum";
		}
	}
	

	
	}	
	

	
	


	
	




