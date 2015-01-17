package com.star.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.json.JSONArray;

import com.star.bean.Chart;
import com.star.service.ZipDataService;
import com.star.service.ZipDataServiceO;

public class DemoAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Resource
	private ZipDataService zipDataService;

	@Resource
	private ZipDataServiceO zipDataServiceO;

	private String type;

	private String data;

	private JSONArray jsonArray;

	private List<Chart> listChart;

	private Integer sss;

	public String extDemo() {
		return SUCCESS;
	};

	public String chartDemo() {
		// List<ZipData> list = zipDataService.find();
		// zipDataService.threadAdd("E://进程监控（服务，端口，进程）.zip");
		// long startTime = System.currentTimeMillis();
		// zipDataService.addBatch("E://进程监控（服务，端口，进程）.zip");
		/*
		 * List<ZipData> list = zipDataService.find(); long endTime =
		 * System.currentTimeMillis(); System.out.println("运行时间：" + (endTime -
		 * startTime )/1000 + "s");
		 */
		return SUCCESS;
	}

	public String todayChart() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getDefault());
		calendar.set(2014, 9, 31, 0, 0);
		System.out.println(calendar.getTimeInMillis());

		listChart = new ArrayList<Chart>();
		Chart chart = new Chart();
		chart.setName("data1");

		Chart chart1 = new Chart();
		chart1.setName("data2");

		sss = sss == null ? 20 : sss;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		for (int index = 0; index < sss; index++) {
			Map<String, Object> mapValue = new HashMap<String, Object>();
			Map<String, Object> mapValue1 = new HashMap<String, Object>();
			calendar.add(Calendar.MINUTE, 5);
			mapValue.put("x", calendar.getTimeInMillis());
			mapValue.put("y", Math.random() * 10);
			mapValue1.put("x", calendar.getTimeInMillis());
			mapValue1.put("y", Math.random() * 10);
			list.add(mapValue);
			list1.add(mapValue1);
		}
		chart.setData(list);
		chart1.setData(list1);

		listChart = new ArrayList<Chart>();
		listChart.add(chart);
		listChart.add(chart1);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public List<Chart> getListChart() {
		return listChart;
	}

	public void setListChart(List<Chart> listChart) {
		this.listChart = listChart;
	}

	public Integer getSss() {
		return sss;
	}

	public void setSss(Integer sss) {
		this.sss = sss;
	}

}
