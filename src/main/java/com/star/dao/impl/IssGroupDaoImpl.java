package com.star.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.star.base.BaseDao;
import com.star.bean.IssGroup;
import com.star.dao.IssGroupDao;

@Repository
public class IssGroupDaoImpl extends BaseDao implements IssGroupDao{

	public static final String ISS_GROUP = "com.star.bean.IssGroup";
	
	public List<IssGroup> findAll(){
		return (List<IssGroup>)finaAll(IssGroup.class);
	}
	
}
