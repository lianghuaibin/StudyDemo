package com.lhb.study.util.paging;


import com.lhb.study.util.frame.ListResult;

import java.io.Serializable;

/**
 * 分页集合结果返回类
 * @author lianghuaibin
 * @since 2017/3/21
 */
public class PageListResult<T> extends ListResult<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private PageKit pageKit;

	public PageKit getPageKit() {
		return pageKit;
	}

	public void setPageKit(PageKit pageKit) {
		this.pageKit = pageKit;
	}
}
