package com.prj.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.prj.biz.IStuBiz;
import com.prj.entity.Stu;



public class StuAction extends ActionSupport{
	private IStuBiz stuBiz;
	HttpServletRequest request;//��ȡ������request
	private Stu stu;
	
	
	//���ѧ��
	public String addStu(){
		boolean bool=stuBiz.addStu(stu);
		if(bool){
			return SUCCESS;
		}
		return INPUT;
	}
	
	//��ѯѧ��
	public String queryList(){
		request=ServletActionContext.getRequest();
		request.setAttribute("stulist", stuBiz.queryStu());//biz�в��������Ϣ
		return SUCCESS;
	}

	public IStuBiz getStuBiz() {
		return stuBiz;
	}

	public void setStuBiz(IStuBiz stuBiz) {
		this.stuBiz = stuBiz;
	}



	public HttpServletRequest getRequest() {
		return request;
	}



	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Stu getStu() {
		return stu;
	}

	public void setStu(Stu stu) {
		this.stu = stu;
	}
	
}
