package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import exception.UserException;

import pojo.User;

@Controller
@RequestMapping("user/")
public class UserController {
	Map<Integer,User> userList=new HashMap<Integer, User>();

	public UserController() {
		userList.put(1, new User(1,"闫伟", "111"));
		userList.put(2, new User(2,"晗晗", "111"));
		userList.put(3, new User(3,"admin", "111"));
	}
	@RequestMapping(value="list",method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("userList", userList);
		mv.setViewName("user/list");
		return mv;
	}
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(@ModelAttribute("user") User u){//这里的model是用来接受页面的封装参数的
		System.out.println("跳转至添加页面");
//		model.addAttribute(new User());
		return "user/add";
	}
	@RequestMapping(value="add1",method=RequestMethod.POST)
	public String add1(@Validated User user,BindingResult b){
		if(b.hasErrors()) return "user/add";
		userList.put(user.getId(), user);
		System.out.println("添加成功");
		return "redirect:list";
	}
	@RequestMapping(value="view/{id}",method=RequestMethod.GET)
	public String view(@PathVariable int id,Model model){
		model.addAttribute(userList.get(id));
		System.out.println("正在查看"+userList.get(id).getName()+"的信息");
		return "user/view";
	}
	@RequestMapping(value="update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model){//这里的model是用来接受页面的封装参数的
		model.addAttribute(userList.get(id));//返回的是一个User类型，可以用${user}来取值
		System.out.println("跳转至修改页面");
		return "user/update";
	}
	@RequestMapping(value="update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated User user,BindingResult b){
		if(b.hasErrors()) return "user/update";//这里不需要用REST风格
		userList.put(user.getId(), user);
		System.out.println("添加成功");
		return "redirect:/user/list";
	}
	//删除
	@RequestMapping(value="delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		String s=userList.get(id).getName();
		System.out.println("准备删除"+s+"的信息");
		userList.remove(id);
		System.out.println(s+"的信息已删除");
		return "redirect:/user/list";
	}
	//登录
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@RequestParam String name,@RequestParam String pwd,HttpSession session,HttpServletRequest r) throws Exception{
		//首先遍历userList
			for(User u:userList.values()){
				if(u.getName().equals(name)&&u.getPwd().equals(pwd)){
					session.setAttribute("currentUser", u);
					return "redirect:/user/list";
				}
			}
			throw new UserException("登录出错~");
	}
}
