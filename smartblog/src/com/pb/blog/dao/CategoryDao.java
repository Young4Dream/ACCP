package com.pb.blog.dao;

import java.util.List;

import com.pb.blog.entity.Category;


public interface CategoryDao extends BaseDao<Category> {
	
	/**
	 * �õ�ȫ�������б�
	 * @return �����б�
	 */
	public List<Category> getCategories();
	
	/**���ݷ���������õ��������
	 * @param name ���������
	 * @return
	 */
	public Category getCategoryByName(String name);
}
