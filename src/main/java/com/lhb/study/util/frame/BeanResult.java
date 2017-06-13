package com.lhb.study.util.frame;

import java.io.Serializable;

public class BeanResult<T> extends AbstractResult implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/** 返回对象信息**/
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
