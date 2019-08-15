package com.pojo;

public class Item {
	private int itemid;
	private String iname;
	private int typeid;
	private int jcnum;
	private int kcnum;
	private String description;
	private String author;
	private String publish;
	
	private BookType booktype;
	
	private Book book;
	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookType getBooktype() {
		return booktype;
	}
	public void setBooktype(BookType booktype) {
		this.booktype = booktype;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getJcnum() {
		return jcnum;
	}
	public void setJcnum(int jcnum) {
		this.jcnum = jcnum;
	}
	public int getKcnum() {
		return kcnum;
	}
	public void setKcnum(int kcnum) {
		this.kcnum = kcnum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	

}
