package com.daimabaike.biz.sys.cons;

public enum XueliEnum {

	GZ(1, "高中"), ZK(1, "专科"), BK(2, "本科");

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
