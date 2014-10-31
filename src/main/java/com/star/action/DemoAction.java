package com.star.action;

import javax.annotation.Resource;

import com.star.service.ZipDataService;
import com.star.service.ZipDataServiceO;

public class DemoAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Resource
	private ZipDataService zipDataService;
	
	@Resource
	private ZipDataServiceO zipDataServiceO;
	
	public String extDemo(){
		return SUCCESS;
	};
	
	public String chartDemo(){
		
		//zipDataService.threadAdd("E://进程监控（服务，端口，进程）.zip");
		/*long startTime = System.currentTimeMillis();
		zipDataServiceO.addBatch("E://进程监控（服务，端口，进程）.zip");
		long endTime = System.currentTimeMillis();
		System.out.println("运行时间：" + (endTime - startTime )/1000 + "s");*/
		return SUCCESS;
	}

	
}
