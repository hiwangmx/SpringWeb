package com.star.dao;

import java.util.List;

import com.star.bean.ZipData;

public interface ZipDataDao {

	List<ZipData> find();
	
	void add(ZipData zipData);
	
	void addBatch(List<ZipData> list);
	
	void exec3(List<ZipData> list);
	
	void addBatch1(List<ZipData> list);
}
