package com.pojo;

import java.util.Date;



public class Book {
	private int bid;
	private String bname;
	private int itemid;
	private Date rktime;
	private int status;
	
	private Item item;//一本书对应一个数目
    
    private User user;//一本书对应一个用户
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public Date getRktime() {
		return rktime;
	}
	public void setRktime(Date rktime) {
		this.rktime = rktime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
