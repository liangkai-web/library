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
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Blog;
import com.pojo.BookType;
import com.pojo.Item;
import com.pojo.User;
import com.service.BlogService;
import com.service.BookTypeService;
import com.service.QueryBookService;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private BookTypeService btService;
	@Autowired
	private QueryBookService qbService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showUpage")
	public String showUhpage(Model model) {
		List<BookType> list = this.btService.getBookTypeList();
		model.addAttribute("btList",list);
		return "upage";
	}
	@RequestMapping("/showReg")
	public String showRegU(Model model) {
		return "reg";
	}
	@RequestMapping("/showxgPwd")
	public String showXgPwd(Model model) {
		return "xgpwd";
	}
	
	@RequestMapping({ "/validateUser" })
	public String login(User user, HttpSession session,Model model) {
		user = this.userService.getUser(user);
		if (user == null) {
			model.addAttribute("msg", "登陆失败");
			return "forward:/login.jsp";
		}
		if (user.getIsvalid() == 0) {
			model.addAttribute("msg", "该账户已失效！请联系管理员");
			return "forward:/login.jsp";
		}
		session.setAttribute("user", user);
		switch (user.getType()) {
		case 1:
			return "adminpage";
		case 2:
			return "bookadminpage";
		case 3:
			return "forward:/user/showUpage";
		}
		return "forward:/user/showUpage";
	}

	
	
	@RequestMapping(value="/queryBook")
	@ResponseBody
	public List<Item> queryBook(int typeid,String iname,
			String author) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("typeid", typeid);
		map.put("iname", iname);
		map.put("author", author);
		List<Item> list = qbService.getBookList(map);
		return list;
	}
	
	@RequestMapping(value="/history")
	@ResponseBody
	public List<Blog> BorrowHistory(int uid) {
		List<Blog> list = blogService.getBorrowHistory(uid);
		return list;
	}
    
	@RequestMapping("/addUser")
	public String addUser(User user,@RequestParam("username")String username,Model model) {//新增用户
		int count = userService.checkUsername(username);
		if(count==0) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("username",username);
		if(username == "" || username.equals(null)){
			model.addAttribute("msg", "用户名不能为空"); 
			return "reg";
		}else {
		map.put("password", user.getPassword());
		map.put("uid", user.getUid());
		map.put("type", 3);
		map.put("regtime", new Date());
		map.put("isvalid", 1);
		map.put("kjnum", 5);
		map.put("yjnum", 0);
		map.put("fine", 0);
		map.put("phone", user.getPhone());
		this.userService.addUser(map);
		return "forward:/login.jsp";
		}
		}else {
			model.addAttribute("msg", "用户名已存在，请重新输入用户名");
			return "reg";
		}


	}	

	@RequestMapping("/updateUser")
	public String updateUser(User user, @RequestParam("username") String username, Model model) {
		int count = userService.checkUsername(username);
		if (count != 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("username", user.getUsername());
			map.put("password", user.getPassword());
			map.put("phone", user.getPhone());
			this.userService.xgUser(map);
			model.addAttribute("msg", "修改成功");
			return "forward:/login.jsp";
		} else {
			model.addAttribute("msg", "用户名不存在，请重新输入用户名");
			return "xgpwd";

		}
	}
	
}
