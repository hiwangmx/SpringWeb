package com.star.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipException;

import javax.annotation.Resource;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.star.bean.ZipData;
import com.star.dao.ZipDataDao;
import com.star.service.ZipDataService;
import com.star.utils.DateUtils;

@Repository
public class ZipDataServiceImpl implements ZipDataService {

	@Resource
	private ZipDataDao zipDataDao;

	public void add(ZipData zipData) {
		zipDataDao.add(zipData);
	}

	public List<ZipData> find(){
		return zipDataDao.find();
	}
	
	public void addBatch(String fileName) {

		try {
			File file = new File(fileName);
			ZipFile zipFile = new ZipFile(file, "gbk");
			Enumeration<ZipEntry> zipEntrys = zipFile.getEntries();
			List<ZipData> listZip = new ArrayList<ZipData>();
			while (zipEntrys.hasMoreElements()) {
				ZipEntry entry = zipEntrys.nextElement();
				System.out.println(entry.getName());
				if (!entry.isDirectory()) {
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(zipFile.getInputStream(entry)));
					String sb = "";
					while ((sb = bufferedReader.readLine()) != null) {
						String[] sigleStr = sb.split("\t");
						JSONObject jsonObject = new JSONObject(sigleStr[2]);
						JSONArray values = jsonObject.getJSONArray("value");
						for (int index = 0; index < values.length(); index++) {
							JSONObject value = values.getJSONObject(index);
							ZipData zipData = new ZipData();
							zipData.setId(UUID.randomUUID().toString());
							zipData.setCpu(new BigInteger(String.valueOf(value
									.getInt("cpu"))));
							zipData.setExtime(DateUtils
									.formateDate(sigleStr[3]));
							zipData.setMemory(new BigInteger(String
									.valueOf(value.getInt("memory"))));
							zipData.setName(value.getString("name"));
							zipData.setPid(String.valueOf(value.getInt("pid")));
							zipData.setState(value.getInt("state"));
							listZip.add(zipData);
						}
						if (listZip.size() == 50000) {
							//threadAdd(listZip);
							//zipDataDao.addBatch(listZip);
							zipDataDao.addBatch1(listZip);
							listZip = new ArrayList<ZipData>();
						}
					}
				}
			}
			//threadAdd(listZip);
			//zipDataDao.addBatch(listZip);
			zipDataDao.addBatch1(listZip);
		} catch (ZipException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void threadAdd(String fileName) {
		ExecutorService pool = Executors.newFixedThreadPool(1);
		for (int i = 0; i < 1; i ++) {
			MyThread tt = new MyThread(fileName);
			tt.start();
			pool.execute(tt);
		}
		pool.shutdown();
	}
	
	class MyThread extends Thread{
		
		private String fileName;
		
		public MyThread(String fileName) {
			this.fileName = fileName;
		}
		
		@Override
		public void run() {
			long startTime = System.currentTimeMillis();
			addBatch(fileName);
			long endTime = System.currentTimeMillis();
			System.out.println("运行时间：" + (endTime - startTime )/1000 + "s");
		}
		
	}

}
