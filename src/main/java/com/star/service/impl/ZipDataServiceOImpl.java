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
import java.util.zip.ZipException;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

import com.star.bean.ZipData;
import com.star.dao.ZipDataDaoO;
import com.star.service.ZipDataServiceO;
import com.star.utils.DateUtils;

public class ZipDataServiceOImpl implements ZipDataServiceO{

	private ZipDataDaoO zipDaoO;

	public ZipDataDaoO getZipDaoO() {
		return zipDaoO;
	}

	public void setZipDaoO(ZipDataDaoO zipDaoO) {
		this.zipDaoO = zipDaoO;
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
						if (listZip.size() == 10000) {
							//threadAdd(listZip);
							//zipDataDao.addBatch(listZip);
							zipDaoO.addBatch(listZip);
							listZip = new ArrayList<ZipData>();
						}
					}
				}
			}
			//threadAdd(listZip);
			//zipDataDao.addBatch(listZip);
			if(listZip != null && listZip.size() >0){
				zipDaoO.addBatch(listZip);
			}
		} catch (ZipException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
