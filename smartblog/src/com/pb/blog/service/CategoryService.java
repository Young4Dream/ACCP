package com.pb.blog.service;

import java.util.List;

import com.pb.blog.entity.Category;

public interface CategoryService {
	public void saveOrUpdateCategory(Category category);
	public void deleteCategory(String id);
	public Category getCategory(String id);
	public Category getCategoryByName(String name);
	public List<Category> getCategories();

}
