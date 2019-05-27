package com.daimabaike.biz.sys.cons;

public enum XueliEnum {

	aa(1, "aa"), bb(2, "bb");

	private final int value;

	private final String name;

	private XueliEnum(int code, String name) {
		this.value = code;
		this.name = name;
	}

	public static XueliEnum valueOf(int code) {
		for (XueliEnum status : values()) {
			if (status.value == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("XueliEnum, No matching constant for [" + code + "]");
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

}
