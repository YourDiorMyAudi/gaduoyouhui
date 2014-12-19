package com.mvn.gdyh.action;

import org.apache.log4j.Logger;

import com.mvn.gdyh.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	Logger log = Logger.getLogger(LoginAction.class);
	UserService userService;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
	public String checkUser() {
		String ret = "success";
		
		String rel = userService.findUserInfByUsername("jiwei");
		
		log.debug("===========checkUser===========" + rel);
		
		return ret;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}	
}
