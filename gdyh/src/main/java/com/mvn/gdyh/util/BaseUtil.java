package com.mvn.gdyh.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BaseUtil {
	public static String getMainMenu() {  
		   StringBuffer buffer = new StringBuffer();  
		   buffer.append("您好，我是SISO，请回复数字选择服务：").append("\n\n");  
		   buffer.append("1  百度搜索").append("\n");  
		   buffer.append("2  最新活动").append("\n");  
		   buffer.append("3  课程查询").append("\n");  
		   buffer.append("4  成绩查询").append("\n\n");  
		   buffer.append("回复“?”显示此帮助菜单");  
		   return buffer.toString();  
		}  
	
	public static boolean isQqFace(String content) {  
	    boolean result = false;  
	  
	    // 判断QQ表情的正则表达式  
	    String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";  
	    Pattern p = Pattern.compile(qqfaceRegex);  
	    Matcher m = p.matcher(content);  
	    if (m.matches()) {  
	        result = true;  
	    }  
	    return result;  
	}
}
