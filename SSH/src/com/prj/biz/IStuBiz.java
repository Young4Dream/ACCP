package com.prj.biz;

import java.util.List;

import com.prj.entity.Stu;

public interface IStuBiz {
	public boolean addStu(Stu stu);//���ѧ��
	public List<Stu> queryStu();//��ѯѧ����Ϣ
}
