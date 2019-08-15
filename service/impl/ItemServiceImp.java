package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ItemMapper;
import com.pojo.Item;
import com.service.ItemService;

@Service
public class ItemServiceImp implements ItemService {
	
	@Autowired
	public ItemMapper itemMapper;


	@Override
	public List<Item> getItemList() {
		// TODO Auto-generated method stub
		return this.itemMapper.getItemList();

	}

	@Override
	public Item getItemInfo(Item item) {
		// TODO Auto-generated method stub
		return this.itemMapper.getItemInfo(item);
	}

	@Override
	public int updateItemNum(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.itemMapper.updateItemNum(map);
	}

	@Override
	public Item getBookStatus(Item item) {
		// TODO Auto-generated method stub
		return this.itemMapper.getBookStatus(item);
	}

	@Override
	public void addItem(Map<String, Object> map) {
		itemMapper.insert(map);
	}

	@Override
	public Item getItem(Item item) {
		return itemMapper.getItem(item);

	}

	@Override
	public int updateItem(Map<String, Object> map) {
		return itemMapper.update(map);
	}

}
