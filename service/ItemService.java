package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.Item;

public interface ItemService {
	 public abstract List<Item> getItemList();
	  
	  public abstract Item getItemInfo(Item paramItem);
	  
	  public abstract int updateItemNum(Map<String, Object> paramMap);
	  
	  public Item getBookStatus(Item item);

	//添加书目
	public void addItem(Map<String,Object> map);

	//查询书目
	public Item getItem(Item item);
	
	//更新书目
	public int updateItem(Map<String,Object> map);
}
