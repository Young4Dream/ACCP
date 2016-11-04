package com.prj.biz;

import java.util.List;

import com.prj.entity.Stu;

public interface IStuBiz {
	public boolean addStu(Stu stu);//添加学生
	public List<Stu> queryStu();//查询学生信息
}
