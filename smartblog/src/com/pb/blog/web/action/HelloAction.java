package com.pb.blog.web.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	private String userName;
	private String password;
	private Map<String,String> root = new HashMap<String,String>();
	public Map<String, String> getRoot() {
		return root;
	}

	public void setRoot(Map<String, String> root) {
		this.root = root;
	}

	public String execute(){
		root.put("message", "this is message");
		return SUCCESS;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
