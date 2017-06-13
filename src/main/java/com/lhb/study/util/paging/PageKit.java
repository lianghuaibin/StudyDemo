package com.lhb.study.util.paging;

import java.io.Serializable;

/**
 * 分页组件
 * @author lianghuaibin
 * @since 2017/3/21
 */
public class PageKit implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 public PageKit(int pageNo, int itemCount, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.itemCount = itemCount;
		this.pageCount = (int) Math.ceil(((double) itemCount / (double) pageSize));
    }
	 
	/**
     *  每页条目数量
     */
	private int pageSize;
	
	/**
     * @return 当前页码
     */
	private int pageNo;
	
	/**
     *  条目总数
     */
	private int itemCount;
	
	/**
	 * 总页数
	 */
	private int pageCount;
	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
}
