package com.star.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.star.base.BaseDao;
import com.star.bean.ZipData;
import com.star.dao.ZipDataDao;
import com.star.utils.CloseUtils;

@Repository
public class ZipDataDaoImp extends BaseDao implements ZipDataDao {

	public void add(ZipData zipData) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(zipData);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			tx.commit();
			CloseUtils.close(session);
		}
	}

	public void addBatch(List<ZipData> list) {
		if(list == null || list.size() == 0){
			return;
		}
		StatelessSession session = getSessionFactory().openStatelessSession();
		Transaction tx = session.beginTransaction();
		try {
			for(ZipData zipData : list){
				session.insert(zipData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			tx.commit();
			CloseUtils.close(session);
		}
	}

}
