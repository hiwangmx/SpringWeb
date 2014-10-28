package com.star.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;
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
							threadAdd(listZip);
							//zipDataDao.addBatch(listZip);
							listZip = new ArrayList<ZipData>();
						}
					}
				}
			}
			threadAdd(listZip);
			//zipDataDao.addBatch(listZip);
		} catch (ZipException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void threadAdd(List<ZipData> listZip) {
		for (int i = 0; i < 50000; i += 100) {
			List<ZipData> temDatas = listZip.subList(i, i + 100);
			new MyThread(temDatas).run();
		}
	}
	
	class MyThread extends Thread{
		
		private List<ZipData> listZip;
		
		public MyThread(List<ZipData> listZip) {
			this.listZip = listZip;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			zipDataDao.addBatch(listZip);
		}
		
	}

}
