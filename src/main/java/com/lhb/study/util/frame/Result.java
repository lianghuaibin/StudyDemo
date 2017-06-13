package com.lhb.study.util.frame;

import java.io.Serializable;

public class Result extends AbstractResult implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String keyValue;

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
}
