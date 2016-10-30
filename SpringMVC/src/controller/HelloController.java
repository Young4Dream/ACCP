package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller//class="controller.HelloController"
public class HelloController{
@RequestMapping("/hello")//name="/hello"
public String hello(String name,Model model){
	System.out.println("Hello Spring MVC"+name);
	model.addAttribute("message","yanwei");
	return "hello";
}
@RequestMapping("/hello1")//name="/hello"
public ModelAndView hello1(Integer name){
	ModelAndView mav=new ModelAndView();
	mav.addObject("message","yanwei");
	mav.setViewName("hello");
	mav.addObject(name);
	System.out.println("Hello Spring MVC"+name);
	return mav;
}
}
