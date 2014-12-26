package com.mvn.gdyh.util;

import java.sql.Timestamp;

public class TextMessage {
	
	private String ToUserName;
	private String FromUserName;
	private Long CreateTime;
	private String MsgType;
	// 回复的消息内容
	private String Content;
	private int FuncFlag;

	public void setContent(String content) {
		Content = content;
	}
	
	public String getContent() {
		return Content;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public int getFuncFlag() {
		return FuncFlag;
	}

	public void setFuncFlag(int funcFlag) {
		FuncFlag = funcFlag;
	}

}
