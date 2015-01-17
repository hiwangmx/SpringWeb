package com.star.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import com.star.base.BaseDao;
import com.star.bean.ZipData;
import com.star.dao.ZipDataDao;
import com.star.utils.CloseUtils;
import com.star.utils.DateUtils;

@Repository
public class ZipDataDaoImp extends BaseDao implements ZipDataDao {

	private String o_url = "jdbc:mysql://localhost:3306/spring_web";
	private Connection conn = null;
	private String userName = "root";
	private String password = "root";
	private static String insertSQL = "INSERT INTO zip_data (id , state, memory, pid, cpu,name,extime) VALUES (?,?,?,?,?,?,?)";
	
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
		Connection con = session.connection();

		try {
			for(int i=0;i<list.size();i++){
				//session.insert(zipData);
				ZipData zipData = list.get(i);
				String procedure = "";
				if((i+1)>5){
					procedure = "{call zip_data_"+(((i+1)%5) + 1)+"(?,?,?,?,?,?,?) }";
				}else{
					procedure = "{call zip_data_"+((i+1))+"(?,?,?,?,?,?,?) }";
				}
				CallableStatement cstmt = con.prepareCall(procedure);
				cstmt.setString(1, zipData.getId());
				cstmt.setInt(2,zipData.getState()); 
				cstmt.setInt(3,(new Integer(zipData.getMemory()+"")));
				cstmt.setString(4, zipData.getPid());
				cstmt.setInt(5,new Integer(zipData.getCpu()+"")); 
				cstmt.setString(6,zipData.getName()); 
				//cstmt.setDate(7, new Date(new java.util.Date().getTime()));
				cstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			tx.commit();
			CloseUtils.close(session);
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void exec3(List<ZipData> list) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(o_url, userName, password);
			conn.setAutoCommit(false);
			StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO zip_data (id , state, memory, pid, cpu,name,extime) VALUES ");
			PreparedStatement pst = conn.prepareStatement(insertSQL);
			for(int i=0;i<list.size();){
				//session.insert(zipData);
				ZipData zipData = list.get(i);
				i++;
				if(i % 10000 != 0 && i !=1){
					sb.append(",");    
				}
				if(i % 10000 == 0){
					pst.executeUpdate(sb.toString());
					conn.commit();
					sb.setLength(0);
					sb.append("INSERT INTO zip_data (id , state, memory, pid, cpu,name,extime) VALUES ('" +zipData.getId()+ "',"+zipData.getState()
							+","+zipData.getMemory()+",'"+zipData.getPid()+"',"+zipData.getCpu()+",'"
							+zipData.getName()+"','"+DateUtils.formateDate(zipData.getExtime())+"')");
                }else{
                	sb.append("('" +zipData.getId()+ "',"+zipData.getState()
							+","+zipData.getMemory()+",'"+zipData.getPid()+"',"+zipData.getCpu()+",'"
							+zipData.getName()+"','"+DateUtils.formateDate(zipData.getExtime())+"')");
                } 
			}
			pst.executeUpdate(sb.toString());
			conn.commit();
			//pst.executeUpdate(sb.toString());
			//Long endTime = System.currentTimeMillis();
			//System.out.println("pst+batch：" + (endTime - beginTime) + "毫秒");
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			
		}

	}
	
	public void addBatch1(List<ZipData> list) {
		if(list == null || list.size() == 0){
			return;
		}
		SessionFactory sf = getSessionFactory();
		StatelessSession session = getSessionFactory().openStatelessSession();
		StringBuilder sb = new StringBuilder();
		 sb.append("INSERT INTO zip_data (id , state, memory, pid, cpu,name,extime) VALUES ");
		try {
			for(int i=0;i<list.size();){
				
				ZipData zipData = list.get(i);
				i++;
				if(i % 10000 != 0 && i !=1){
					sb.append(",");    
				}
				if(i % 10000 == 0){
					SQLQuery sql1 = session.createSQLQuery(sb.toString());
					sql1.executeUpdate();
					sb.setLength(0);
					sb.append("INSERT INTO zip_data (id , state, memory, pid, cpu,name,extime) VALUES ('" +zipData.getId()+ "',"+zipData.getState()
							+","+zipData.getMemory()+",'"+zipData.getPid()+"',"+zipData.getCpu()+",'"
							+zipData.getName()+"','"+DateUtils.formateDate(zipData.getExtime())+"')");
                }else{
                	sb.append("('" +zipData.getId()+ "',"+zipData.getState()
							+","+zipData.getMemory()+",'"+zipData.getPid()+"',"+zipData.getCpu()+",'"
							+zipData.getName()+"','"+DateUtils.formateDate(zipData.getExtime())+"')");
                } 
			}
			SQLQuery sql1 = session.createSQLQuery(sb.toString());
			sql1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			CloseUtils.close(session);
		}
	}

	public List<ZipData> find() {
		Session session = getSessionFactory().openSession();
		ZipData zipData = new ZipData();
		zipData.setId("2");
		zipData.setExtime(new Date());
		//SQLQuery sql1 = session.createSQLQuery("insert into zip_data_zz(id,extime) values('"+ zipData.getId()+"','"+DateUtils.formateDate(zipData.getExtime())+"') ");
		//sql1.executeUpdate();
		
		//sql1 = session.createSQLQuery("insert into zip_data_zz(id,extime) values('"+ zipData.getId()+"','"+DateUtils.formateDate(zipData.getExtime())+"') ");
		
		SQLQuery sql = session.createSQLQuery("Select a.* From zip_data as a,zip_data as b where a.id = b.id ");
		List<ZipData> list = sql.list();
		return list;
	}

}
