package com.star.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.star.bean.IssGroup;
import com.star.dao.IssGroupDao;

public class IndexAction extends BaseAction {

	private static final long serialVersionUID = 1317995267656400289L;

	@Autowired
	private IssGroupDao issGroupDao;

	private List<IssGroup> listGroup;

	public String home() {
		listGroup = issGroupDao.findAll();
		return INDEX;
	}

	public String error404() {
		return ERROR_404;
	}

	public String error500() {
		return ERROR_500;
	}

	public List<IssGroup> getListGroup() {
		return listGroup;
	}

	public void setListGroup(List<IssGroup> listGroup) {
		this.listGroup = listGroup;
	}
	
	public IssGroupDao getIssGroupDao() {
		return issGroupDao;
	}

	public void setIssGroupDao(IssGroupDao issGroupDao) {
		this.issGroupDao = issGroupDao;
	}

}
