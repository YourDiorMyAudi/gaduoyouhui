package com.mvn.gdyh.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.mvn.gdyh.dao.UserDAO;
import com.mvn.gdyh.po.TblGdyhUserInf;
import com.mvn.gdyh.service.UserService;

public class UserServiceImpl implements UserService {
	
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	UserDAO userDAO;
	
	@Override
	public String findUserInfByUsername(String username) {
		List<TblGdyhUserInf> list = userDAO.findAllRecords();//userDAO.findByHql("from TblGdyhUserInf t where t.username='jiwei'");
		TblGdyhUserInf po = list.get(0);
		return po.getAddr();
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
