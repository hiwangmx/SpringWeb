package com.star.base;

import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.star.utils.CloseUtils;

public class BaseDao extends HibernateDaoSupport {

	public List<?> finaAll(Class<?> clazz) {
		List<?> list = null;
		Session session = getSessionFactory().openSession();
		try {
			if (clazz == null) {
				throw new Exception("clazz is null");
			}
			String hql = "from " + clazz.getName();
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			CloseUtils.close(session);
		}
		return list;
	}
	
	public List<?> finaByField(Class<?> clazz, Field filed, String value){
		List<?> list = null;
		Session session = getSessionFactory().openSession();
		try {
			if (clazz == null) {
				throw new Exception("clazz is null");
			}
			String hql = "FROM" + clazz.getName();
			hql += " WHERE " + filed.getName() + " = " + value;
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			CloseUtils.close(session);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findByField(Class<T> clazz, String fieldName, String fieldValue){
		List<T> list = null;
		Session session = getSessionFactory().openSession();
		try {
			if (clazz == null) {
				throw new Exception("clazz is null");
			}
			String hql = "FROM " + clazz.getName();
			hql += " WHERE " + fieldName + " = " + fieldValue;
			Query query = session.createQuery(hql);
			list = query.list();
			CloseUtils.close(session);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			CloseUtils.close(session);
		}
		return list;
	}
	
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
