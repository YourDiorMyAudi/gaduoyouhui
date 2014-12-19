package com.mvn.gdyh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mvn.gdyh.po.TblGdyhUserInf;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();
		
		SessionFactory sf = conf.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		TblGdyhUserInf po = new TblGdyhUserInf();
		po.setUsername("jiwei");;
		po.setPassword("jiwei");
		po.setAddr("address");;
		
		session.persist(po);
		
		tx.commit();
		session.close();
		sf.close();
	}

}
