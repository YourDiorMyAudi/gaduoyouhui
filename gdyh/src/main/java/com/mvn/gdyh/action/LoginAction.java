package com.mvn.gdyh.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.mvn.gdyh.service.UserService;
import com.mvn.gdyh.util.CoreService;
import com.mvn.gdyh.util.SignUtil;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	Logger log = Logger.getLogger(LoginAction.class);
	UserService userService;
	Map<String, String> jsonMap = new HashMap<String, String>();
	
	public String checkUser() {
		String ret = "success";
		
		String rel = userService.findUserInfByUsername("jiwei");
		
		log.info("===========checkUser===========" + rel);
		
		return ret;
	}
	
	public String testJson() {
		String ret = "success";
		
		jsonMap.put("jw", "jw");
		
		return ret;
	}
	
	public String connWX() {

		String ret = "success";
		try {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
	      HttpServletRequest request = ServletActionContext.getRequest();
	      HttpServletResponse response = ServletActionContext.getResponse();
	      request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      // 接收参数微信加密签名、 时间戳、随机数
	      String signature = request.getParameter("signature");
	      log.info("signature:" + signature);
	      String timestamp = request.getParameter("timestamp");
	      log.info("timestamp:" + timestamp);
	      String nonce = request.getParameter("nonce");
	      log.info("nonce:" + nonce);
	      // 随机字符串
	      String echostr = request.getParameter("echostr");
	      log.info("echostr:" + echostr);
	      // System.out.println(signature+"111");
	      PrintWriter out = response.getWriter();
	      // 请求校验
	      if (SignUtil.checkSignature(signature, timestamp, nonce)) {
	        String method = ServletActionContext.getRequest().getMethod();
	        log.info("请求方式:" + method);
	        if (method.equals("POST")) {
	            // 调用核心服务类接收处理请求
	            String respXml = CoreService.processRequest(request);
	            log.info("respXml" + respXml);
	            out.print(respXml);
	        } else {
	            out.print(echostr);
	        }
	      }
	      out.close();
	      out = null;
		} catch (Exception e) {
			e.printStackTrace();
			ret = "false";
		}
		
		log.info("ret:" + ret);
		
		return null;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Map<String, String> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, String> jsonMap) {
		this.jsonMap = jsonMap;
	}
}
