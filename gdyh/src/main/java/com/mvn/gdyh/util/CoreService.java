package com.mvn.gdyh.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class CoreService {
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			respContent = BaseUtil.getMainMenu();
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				String Content = requestMap.get("Content");
				// 创建图文消息
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
				newsMessage.setFuncFlag(0);
				if (Content.equals("1")) {
					respContent = "<a href=\"http://www.baidu.com/\">百度</a>";
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
				if (Content.equals("2")) {
					List<Article> articleList = new ArrayList<Article>();
					Article article = new Article();
					article.setTitle("我能开发微信啦");
					article.setDescription("努力的程序员—钟仁，历时三天，成功开发微信...");
					article.setPicUrl("http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26%3Bt%3Dgif/sign=3bb6b7b60db30f242197e451a9fcba26/64380cd7912397dde17b84d35b82b2b7d1a287e2.jpg");
					article.setUrl("http://baike.baidu.com/view/5160047.htm?fr=aladdin");
					articleList.add(article);
					Article article2 = new Article();
					article2.setTitle("第一天");
					article2.setDescription("");
					article2.setPicUrl("http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26%3Bt%3Dgif/sign=3bb6b7b60db30f242197e451a9fcba26/64380cd7912397dde17b84d35b82b2b7d1a287e2.jpg");
					article2.setUrl("http://baike.baidu.com/view/5160047.htm?fr=aladdin");
					articleList.add(article2);
					Article article3 = new Article();
					article3.setTitle("第二天");
					article3.setDescription("");
					article3.setPicUrl("http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26%3Bt%3Dgif/sign=3bb6b7b60db30f242197e451a9fcba26/64380cd7912397dde17b84d35b82b2b7d1a287e2.jpg");
					article3.setUrl("http://baike.baidu.com/view/5160047.htm?fr=aladdin");
					articleList.add(article3);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
				if (BaseUtil.isQqFace(Content)) {
					respContent = Content;
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "谢谢您的关注！";
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
					String eventKey = requestMap.get("EventKey");
					if (eventKey.equals("11")) {
						respContent = "百度菜单项被点击！";
					} else if (eventKey.equals("12")) {
						respContent = "公交查询菜单项被点击！";
					} else if (eventKey.equals("13")) {
						respContent = "周边搜索菜单项被点击！";
					} else if (eventKey.equals("14")) {
						respContent = "历史上的今天菜单项被点击！";
					} else if (eventKey.equals("21")) {
						respContent = "最新动态！";
					} else if (eventKey.equals("22")) {
						respContent = "我要专接本！";
					}
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
}