package com.star.service;

import com.star.bean.ZipData;

public interface ZipDataService {

	void add(ZipData zipData);

	void addBatch(String fileName);
}
