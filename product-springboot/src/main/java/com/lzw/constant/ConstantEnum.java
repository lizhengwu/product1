package com.lzw.constant;

public enum ConstantEnum {

	APP1("1", "1"),
	APP2("2", "2");

	ConstantEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
