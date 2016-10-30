package com.pb.blog.web.action;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pb.blog.common.Constants;
import com.pb.blog.entity.User;
import com.pb.blog.exception.InvalidPasswordException;
import com.pb.blog.exception.InvalidUsernameException;
import com.pb.blog.service.UserService;
import com.pb.blog.util.CookieUtil;
import com.pb.blog.util.SHA;


public class UserAction extends BaseAction {
	private static Log logger = LogFactory.getLog(UserAction.class);
	private UserService userService;
	private User user;
	private String username;
	private String password;
	private String code;
	private String rememberme;
	public String getRememberme() {
		return rememberme;
	}
	public void setRememberme(String rememberme) {
		this.rememberme = rememberme;
	}
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String login(){
		return INPUT;
	}
	/**
	 * 数据库验证
	 * @return
	 */
	public String checkLogin(){
		try {
			user = userService.login(username, password);
			getSession().put(Constants.AUTH_USER, user);
			if (logger.isDebugEnabled()) {
				logger.debug("User:" + user.getUsername() + "Logined.");
			}
		} catch (InvalidUsernameException ex) {
			addActionError(getText("errors.invalid.usernameorpassword"));
		} catch (InvalidPasswordException e) {
			addActionError(getText("errors.invalid.usernameorpassword"));
		}
		if (hasActionErrors()){
			return INPUT;
		}

		return SUCCESS;
		
	}
	/**
	 * 界面验证，用户名、密码为空、验证码不正确给出相应提示信息
	 */
	public void validateCheckLogin(){
		clearErrors();
		if (StringUtils.isBlank(username)) {
			addFieldError("login.username",getText("errors.required",new String[] { getText("login.username") }));
		}
		if (StringUtils.isBlank(password)) {
			addFieldError("login.code",getText("errors.required",new String[] { getText("login.password") }));
		}
		String sessionCode = (String)getSession().get(Constants.IDENTIFYING_CODE_SESSION_NAME);
		if (StringUtils.isBlank(code)) {
			addFieldError("login.code",getText("errors.required",new String[] { getText("login.code") }));
		}else {
			if (!code.equals(sessionCode)) {
				addFieldError("login.code",getText("errors.codeerror"));
			}
		}
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
