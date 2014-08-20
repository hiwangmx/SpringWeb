package com.star.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.star.bean.User;
import com.star.dao.UserDAO;
import com.star.service.UserService;

@Repository
public class UserServiceImpl implements UserService{

	@Resource
	private UserDAO userDao;
	
	public List<User> listAll() {
		return userDao.finaAll();
	}

}
