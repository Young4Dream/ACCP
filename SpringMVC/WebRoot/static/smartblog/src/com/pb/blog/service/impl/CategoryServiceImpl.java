package com.pb.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pb.blog.common.Constants;
import com.pb.blog.dao.CategoryDao;
import com.pb.blog.entity.Category;
import com.pb.blog.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private Log log = LogFactory.getLog(CategoryService.class);
	private CategoryDao categoryDao;
	private Map<String, Object> cache = new HashMap<String, Object>();

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public void deleteCategory(String id) {
		Category category = this.categoryDao.get(id);
		this.categoryDao.delete(category);
		clearCategoriesCache();

	}

	public List<Category> getCategories() {
		if(cache.get(Constants.CATEGORIES_CACHE_KEY)!=null) {
			if(log.isDebugEnabled()) {
				log.debug("[smartblog]:loading cached categories...");
			}
			return (List<Category>) cache.get(Constants.CATEGORIES_CACHE_KEY);
		}else{
			List<Category> categories = this.categoryDao.getCategories();
			cache.put(Constants.CATEGORIES_CACHE_KEY, categories);
			return categories;
		}
	}

	public Category getCategory(String id) {
		return categoryDao.get(id);
	}

	public Category getCategoryByName(String name) {
		return this.categoryDao.getCategoryByName(name);
	}

	public void saveOrUpdateCategory(Category category) {
		this.categoryDao.saveOrUpdate(category);
		clearCategoriesCache();

	}
	private void clearCategoriesCache(){
		cache.put(Constants.CATEGORIES_CACHE_KEY, null);
		if(log.isDebugEnabled()) {
			log.debug("[smartblog]:clear cached categories...");
		}
	}
	

}
