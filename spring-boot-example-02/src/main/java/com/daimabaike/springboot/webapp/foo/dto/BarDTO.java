package com.daimabaike.springboot.webapp.foo.dto;

public class BarDTO {

	private String name;

	private String enName;
	private String channelId;
	private int type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	@Override
	public String toString() {
		
		return String.format("name=%s,enName=%s,channelId=%s,type=%s", name,enName,channelId,type);
	}
}
