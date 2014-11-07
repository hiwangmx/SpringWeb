package com.star.service;

import java.util.List;

import com.star.bean.ZipData;

public interface ZipDataService {

	List<ZipData> find();
	
	void add(ZipData zipData);

	void addBatch(String fileName);
	
	 void threadAdd(String fileName);
}
