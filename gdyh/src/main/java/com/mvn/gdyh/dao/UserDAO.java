package com.mvn.gdyh.dao;

import com.mvn.gdyh.po.TblGdyhUserInf;

public interface UserDAO extends CommonDAO<TblGdyhUserInf> {

	public String findUserInfByUsername(String username);
}
