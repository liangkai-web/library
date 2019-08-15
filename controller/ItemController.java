package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Item;
import com.pojo.User;
import com.service.BMapperService;
import com.service.BlogService;
import com.service.BookService;
import com.service.ItemService;
import com.service.UserService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private BookService bookService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private UserService userService;
	@Autowired
	private BMapperService bMapperService;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String getTime(Date date, long handleTime) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date afterDate = new Date(date.getTime() + handleTime * 24 * 60 * 60 * 1000);
		return sdf.format(afterDate);
	}
 
	@RequestMapping("/getItemInfo")
	@ResponseBody
	public List<Item> getItemInfo(Item item, Model model) {
		List<Item> detlist = new ArrayList<Item>();
		item = this.itemService.getItemInfo(item);
		detlist.add(item);


		return detlist;
	}
	
	public void updateBookStatus(Item item) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bid", item.getBook().getBid());
		this.bookService.updateBookStatus(map);
	}

	public void updateBlog(Item item, int uid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", Integer.valueOf(uid));
		map.put("bid", item.getBook().getBid());
		map.put("time", this.df.format(new Date()));
		this.blogService.updateBlog(map);
	}

	public void updateUser(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", user.getUid());
		map.put("yjnum", user.getYjnum());
		this.userService.updateUser(map);
	}

	public void updateBMapper(Item item, int uid) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", Integer.valueOf(uid));
		map.put("bid", item.getBook().getBid());
		map.put("deadline", getTime(new Date(), 30));
		this.bMapperService.updateBMapper(map);
	}
    public void getYjnum() {
    	
    }
	
	@RequestMapping("updateItemNum")
	public String updateItemNum(User user, Item item,Model model) throws ParseException {
		if(item.getKcnum()<=0) {
			model.addAttribute("msg", "该书库存未零无法借阅");
			return "forward:/user/showUpage";
		}
		if(user.getKjnum()<=user.getYjnum()) {
			model.addAttribute("msg", "您已达到最大可借书数，请先归还已借图书后再借书！");
			return "forward:/user/showUpage";
		}
		if(user.getFine()>0) {
			model.addAttribute("msg", "您有欠款，无法借书请至管理员处缴纳欠款");
			return "forward:/user/showUpage";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("itemid", item.getItemid());
		this.itemService.updateItemNum(map);
		Item item1 = this.itemService.getBookStatus(item);
		updateBookStatus(item1);
		updateUser(user);
		updateBMapper(item1, user.getUid());
		updateBlog(item1, user.getUid());
		return "forward:/user/showUpage";
	}
}
