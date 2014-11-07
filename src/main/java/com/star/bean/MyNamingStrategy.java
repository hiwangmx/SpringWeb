package com.star.bean;

import org.hibernate.cfg.DefaultNamingStrategy;

public class MyNamingStrategy extends DefaultNamingStrategy {

	private static final long serialVersionUID = 1L;

	public static final MyNamingStrategy INSTANCE = new MyNamingStrategy();

	private String vmUUID;

	public String getVmUUID() {
		return vmUUID;
	}

	public void setVmUUID(String vmUUID) {
		this.vmUUID = vmUUID;
	}

	public static final MyNamingStrategy getInstance() {
		return INSTANCE;
	}

	@Override
	public String classToTableName(String className) {
		System.out.println(className + this.getVmUUID());
		return super.classToTableName(className);
	}

	@Override
	public String tableName(String tableName) {
		System.out.println(tableName + this.getVmUUID());
		return super.tableName(tableName);
	}

}
