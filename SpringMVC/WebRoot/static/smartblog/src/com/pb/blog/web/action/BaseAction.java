/**
 * 
 */
package com.pb.blog.web.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pb.blog.common.Constants;
import com.pb.blog.entity.User;


public class BaseAction extends ActionSupport {
	protected Map getSession(){
		ActionContext actionContext = ActionContext.getContext();
		return actionContext.getSession();
	}
	protected Map getRequest(){
		ActionContext actionContext = ActionContext.getContext();
		Map request = (Map)actionContext.get("request");
		return request;
	}
	protected User getLoginUser(){
		if (getSession().get(Constants.AUTH_USER)==null){
			return null;
		}else{
			return (User)getSession().get(Constants.AUTH_USER);
		}
	}
	public String getInputForm(){
		return INPUT;
	}
	
}
