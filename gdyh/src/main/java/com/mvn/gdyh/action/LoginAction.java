package com.mvn.gdyh.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	Logger log = Logger.getLogger(LoginAction.class);
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
	public String checkUser() {
		String ret = "success";
		
		log.debug("===========checkUser===========");
		
		return ret;
	}
}
