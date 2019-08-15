package com.pojo;

import java.util.Date;


public class User {
	private int uid;
	private String username;
	private String password;
	private String name;
	private String phone;
	private int type;
	private Date regtime;
	private int isvalid;
	private int kjnum;
	private int yjnum;
	private float fine;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public int getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}
	public int getKjnum() {
		return kjnum;
	}
	public void setKjnum(int kjnum) {
		this.kjnum = kjnum;
	}
	public int getYjnum() {
		return yjnum;
	}
	public void setYjnum(int yjnum) {
		this.yjnum = yjnum;
	}
	public float getFine() {
		return fine;
	}
	public void setFine(float fine) {
		this.fine = fine;
	}
	

}
