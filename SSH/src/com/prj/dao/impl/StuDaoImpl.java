package com.prj.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.prj.dao.IStuDao;
import com.prj.entity.Stu;

public class StuDaoImpl extends HibernateDaoSupport implements IStuDao{

	
	
	
	
	@Override
	public List<Stu> queryStu() {
		//查询学生用的hql
		List<Stu> list= super.getHibernateTemplate().find("from Stu");
		return list;
	}

	@Override
	public boolean addStu(Stu stu) {
		try {
			super.getHibernateTemplate().save(stu);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
