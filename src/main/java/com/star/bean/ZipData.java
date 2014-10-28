package com.star.bean;

import java.math.BigInteger;
import java.util.Date;

public class ZipData {

	private String id;
	private Integer state;
	private BigInteger memory;
	private String pid;
	private BigInteger cpu;
	private String name;
	private Date extime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public BigInteger getMemory() {
		return memory;
	}

	public void setMemory(BigInteger memory) {
		this.memory = memory;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public BigInteger getCpu() {
		return cpu;
	}

	public void setCpu(BigInteger cpu) {
		this.cpu = cpu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getExtime() {
		return extime;
	}

	public void setExtime(Date extime) {
		this.extime = extime;
	}

}
