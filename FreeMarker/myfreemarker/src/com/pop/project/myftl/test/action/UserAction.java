package com.pop.project.myftl.test.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pop.project.myftl.test.bean.UserInfo;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private UserInfo userInfo;
	/**
	 * 首页
	 * @return
	 */
	public String index() {
		return "index";
	}
	/**
	 * 登录
	 * @return
	 */
	public String login()
	{
		userInfo = new UserInfo() ;
		userInfo.setAddr("shaanxi baoji") ;
		userInfo.setAge(25) ;
		userInfo.setSigninTime(new Date()) ;
//		userInfo.setQq("77276575") ;
		List<String> books = new ArrayList<String>() ;
		books.add("Thinking in Java") ;
		books.add("禅意花园") ;
		books.add("敏捷编程") ;
		books.add("代码大全") ;
		userInfo.setBooks(books) ;
		return "profile" ;
	}
	// setters and getters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
