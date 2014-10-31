package com.star.base;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BatisBaseDao extends SqlSessionDaoSupport{
	
	public int insert(String method,Object entity){  
        return this.getSqlSession().insert(method, entity);  
    }  
}
