package com.star.bean;

import java.util.List;
import java.util.Map;

public class Chart {

	private String name;
	private Long pointInterval;
	private Long pointStart;
	private List<Map<String, Object>> data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

	public Long getPointInterval() {
		return pointInterval;
	}

	public void setPointInterval(Long pointInterval) {
		this.pointInterval = pointInterval;
	}

	public Long getPointStart() {
		return pointStart;
	}

	public void setPointStart(Long pointStart) {
		this.pointStart = pointStart;
	}
	
}
