package com.star.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.star.base.BaseDao;
import com.star.bean.User;
import com.star.dao.UserDAO;

@Repository
public class UserDAOImpl extends BaseDao implements UserDAO{

	public List<User> finaAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) finaAll(User.class);
		return userList;
	}

}
