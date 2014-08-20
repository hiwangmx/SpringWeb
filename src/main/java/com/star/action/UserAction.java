package com.star.action;

import java.util.List;

import javax.annotation.Resource;

import com.star.bean.User;
import com.star.service.UserService;

public class UserAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private List<User> userList;

	@Resource
	private UserService userService;

	public String userList() {
		userList = userService.listAll();
		return SUCCESS;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
