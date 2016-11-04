package com.prj.biz.impl;

import java.util.List;

import com.prj.biz.IStuBiz;
import com.prj.dao.IStuDao;
import com.prj.entity.Stu;

public class StuBizImpl implements IStuBiz{
	private IStuDao studao;

	@Override
	public List<Stu> queryStu() {
		return studao.queryStu();
	}

	public IStuDao getStudao() {
		return studao;
	}

	public void setStudao(IStuDao studao) {
		this.studao = studao;
	}

	@Override
	public boolean addStu(Stu stu) {
		return studao.addStu(stu);
	}
	
}
