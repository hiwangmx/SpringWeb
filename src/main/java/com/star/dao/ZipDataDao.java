package com.star.dao;

import java.util.List;

import com.star.bean.ZipData;

public interface ZipDataDao {

	void add(ZipData zipData);
	
	void addBatch(List<ZipData> list);
	
}
