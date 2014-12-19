package com.mvn.gdyh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.mvn.gdyh.dao.CommonDAO;

public class CommonDAOImpl<T> extends HibernateDaoSupport implements CommonDAO<T>{

	@Override
	public List<T> findByHql(String hql) {
		return (List<T>) getHibernateTemplate().find(hql);
	}
	
	@Override
	public List<T> findAllRecords() {
		
		return null;
	}
}
