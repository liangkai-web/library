package com.pojo;

public class Page {
	private int pageSize;
	private int currentPage;
	private int startRow;
	private Integer puid;
	private Integer pbid;
	private int pbtype;
	private int totalPage;
	private int totalRows;
	private int turnPage;
	private String option;
	
	public Integer getPuid() {
		return puid;
	}
	public void setPuid(Integer puid) {
		this.puid = puid;
	}
	public Integer getPbid() {
		return pbid;
	}
	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}

	public int getPbtype() {
		return pbtype;
	}
	public void setPbtype(int pbtype) {
		this.pbtype = pbtype;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTurnPage() {
		return turnPage;
	}
	public void setTurnPage(int turnPage) {
		this.turnPage = turnPage;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}


}
