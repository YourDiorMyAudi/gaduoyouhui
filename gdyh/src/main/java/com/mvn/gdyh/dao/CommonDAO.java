package com.mvn.gdyh.dao;

import java.util.List;

public interface CommonDAO<T> {

	public List<T> findByHql(String hql);
	public List<T> findAllRecords();
}
