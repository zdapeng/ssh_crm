package com.dapeng.utils;

import java.util.List;

public class PageBean {
	private Integer currentPage;
	private Integer totalCount;
	private Integer totalPage;
	private Integer pageSize;
	private List list;
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		if(this.currentPage == null) {
			this.currentPage = 1;
		}
		if(this.pageSize == null) {
			this.pageSize = 3;
		}
		this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;
		if(this.currentPage < 1) {
			this.currentPage = 1;
		}
		if(this.currentPage > totalPage) {
			this.currentPage = totalPage;
		}
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Integer getStartIndex() {
		return (this.currentPage-1)*pageSize;
	}
}
