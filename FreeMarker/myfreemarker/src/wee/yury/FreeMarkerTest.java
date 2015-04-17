package wee.yury;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.pop.project.myftl.test.bean.UserInfo;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FreeMarkerTest {
	

	
	public static void main(String[] args) throws IOException {
		FreeMarkerUtil util = new FreeMarkerUtil();

//	        Template template = util.getTemplate();  
	        // 创建数据模型  
		UserInfo userInfo = new UserInfo();
		userInfo.setAddr("shaanxi baoji") ;
		userInfo.setAge(25) ;
		userInfo.setSigninTime(new Date()) ;
		userInfo.setQq("") ;
//		userInfo.setQq("77276575") ;
		List<String> books = new ArrayList<String>();
		books.add("Thinking in Java");
		books.add("禅意花园");
		books.add("敏捷编程");
		books.add("代码大全");
		userInfo.setBooks(books);
		Map root = new HashMap();
		root.put("userInfo", userInfo);
		root.put("username", "wee");
		root.put("password", "wee");
		util.print("Copy of profile.ftl", root);

	        

	}
    
}
