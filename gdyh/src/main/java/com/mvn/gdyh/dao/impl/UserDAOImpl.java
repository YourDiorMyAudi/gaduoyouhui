package com.mvn.gdyh.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.mvn.gdyh.dao.UserDAO;
import com.mvn.gdyh.po.TblGdyhUserInf;

public class UserDAOImpl extends CommonDAOImpl<TblGdyhUserInf> implements UserDAO {


//	private HibernateTemplate ht = null;
//	private SessionFactory sessionFactory;
	@Override
	public String findUserInfByUsername(String username) {
		String hql = "from TblGdyhUserInf t where t.username='" + username + "'";
		
		List<TblGdyhUserInf> list = (List<TblGdyhUserInf>)getHibernateTemplate().find(hql);
		if (0 < list.size())
			return list.get(0).getAddr();
		
		return null;
	}
	
/*	private HibernateTemplate getHibernateTemplate() {
		if (null == ht)
			ht = new HibernateTemplate(sessionFactory);
		
		return ht;
	}


	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
}
