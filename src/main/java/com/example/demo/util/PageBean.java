package com.example.demo.util;

import java.util.List;

public class PageBean<T> {
	private Integer currentPage = 1;
	private Integer pageSize = 10;
	private Integer totalNum;
	private Integer isMore;
	private Integer totalPage;
    private Integer startIndex;
	private List<T> items;
	
	public PageBean() {
	    super();
	}
	
	public PageBean(Integer currentPage, Integer pageSize, Integer totalNum) {
	        super();
		    this.currentPage = currentPage;
		   this.pageSize = pageSize;
		     this.totalNum = totalNum;
		   this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
	         this.startIndex = (this.currentPage-1)*this.pageSize;
		    this.isMore = this.currentPage >= this.totalPage?0:1;
		   }
		
}
