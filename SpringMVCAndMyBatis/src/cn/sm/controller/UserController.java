package cn.sm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.sm.pojo.User;
import cn.sm.service.UserService;

@Controller
@RequestMapping(value="/user")

public class UserController {
	
@Resource
private UserService userService;

@RequestMapping(value="/index")
public String index(){
	return "index";
}
@RequestMapping("/register")
public String register(){
	return "register";
}

@RequestMapping("/exit")
public String exit(){
	return "exit";
}

@RequestMapping("/login")
public String login(){
	return "login";
}
@RequestMapping("/loginSuccess")
public ModelAndView loginSuccess(User u){
	u=userService.query(u);
	return new ModelAndView("loginSuccess");
}
@RequestMapping("/registerSuccess")
public ModelAndView registerSuccess(User u){
	u=userService.query(u);
	return new ModelAndView("registerSuccess");
}
}
