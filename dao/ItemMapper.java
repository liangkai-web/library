package com.dao;

import com.pojo.Item;
import java.util.List;
import java.util.Map;

public abstract interface ItemMapper
{
  public abstract List<Item> getItemList();
  
  public abstract Item getItemInfo(Item paramItem);
  
  public abstract int updateItemNum(Map<String, Object> paramMap);
  
  public Item getBookStatus(Item item);
  
  	//添加操作
	public int insert(Map<String,Object> map);
	
	//更新操作
	public int update(Map<String,Object> map);
	
	//查询单个书目
	public Item getItem(Item item);
}
