package com.prj.dao;

import java.util.List;

import com.prj.entity.Stu;

public interface IStuDao {
	public boolean addStu(Stu stu);//���ѧ��
	public List<Stu> queryStu();//��ѯѧ����Ϣ
}
