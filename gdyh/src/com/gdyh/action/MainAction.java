package com.gdyh.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {
	
	private static Logger logger = Logger.getLogger(MainAction.class);  

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("debug infomation");
		return super.execute();
	}
}
