package com.pb.blog.dao;

import java.util.List;

import com.pb.blog.entity.Category;


public interface CategoryDao extends BaseDao<Category> {
	
	/**
	 * 得到全部分类列表
	 * @return 分类列表
	 */
	public List<Category> getCategories();
	
	/**根据分类的名字拿到分类对象
	 * @param name 分类的名字
	 * @return
	 */
	public Category getCategoryByName(String name);
}
