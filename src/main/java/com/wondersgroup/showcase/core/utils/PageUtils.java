package com.wondersgroup.showcase.core.utils;

public class PageUtils {

	private int currentPage;
	private int pageSize=8;
	private int start;
	private int end;
	
	public PageUtils(int currentPage){
		this.currentPage=currentPage;
	}
	public PageUtils(int currentPage,int pageSize){
		this.currentPage=currentPage;
		this.pageSize=pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStart() {
		this.start=(currentPage-1)*pageSize;
		return start;
	}
	public int getEnd() {
		this.end=currentPage*pageSize-1;
		return end;
	}
}
