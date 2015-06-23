package com.star.action;

import java.util.List;

import javax.annotation.Resource;

import com.star.bean.IssGroup;
import com.star.dao.IssGroupDao;
import com.star.pojo.ArithmeticCalculator;
import com.star.pojo.UnitCalculator;

public class IndexAction extends BaseAction {

	private static final long serialVersionUID = 1317995267656400289L;

	@Resource
	private IssGroupDao issGroupDao;
	
	@Resource
	private ArithmeticCalculator arithmeticCalculator;
	@Resource
	private UnitCalculator unitCalculator;

	private List<IssGroup> listGroup;

	public String home() {
		
		arithmeticCalculator.add(1, 2);
		arithmeticCalculator.mul(1, 2);
		arithmeticCalculator.sub(1, 2);
		
		unitCalculator.kilogramToPound(10);
		unitCalculator.kilometerToMile(11);
		
		listGroup = issGroupDao.findAll();
		return INDEX;
	}

	public String error404() {
		return ERROR_404;
	}

	public String error500() {
		return ERROR_500;
	}
	
	public String websocket(){
		return SUCCESS;
	}

	public List<IssGroup> getListGroup() {
		return listGroup;
	}

	public void setListGroup(List<IssGroup> listGroup) {
		this.listGroup = listGroup;
	}
	

}
