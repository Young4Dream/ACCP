package com.prj.dao;

import java.util.List;

import com.prj.entity.Stu;

public interface IStuDao {
	public boolean addStu(Stu stu);//添加学生
	public List<Stu> queryStu();//查询学生信息
}
