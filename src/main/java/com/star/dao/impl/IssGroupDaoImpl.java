package com.star.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.star.bean.IssGroup;
import com.star.dao.IssGroupDao;
import com.star.utils.CloseUtils;

public class IssGroupDaoImpl extends HibernateDaoSupport implements IssGroupDao{

	public static final String ISS_GROUP = "com.star.bean.IssGroup";
	
	public List<IssGroup> findAll(){
		Session session = getSessionFactory().openSession();
		String hql = "from " + ISS_GROUP;
		Query query = session.createQuery(hql);
		List<IssGroup> list = query.list();
		CloseUtils.close(session);
		return list;
	}
	
}
