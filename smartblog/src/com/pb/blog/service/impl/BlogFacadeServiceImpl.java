package com.pb.blog.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pb.blog.entity.Category;
import com.pb.blog.entity.Entry;
import com.pb.blog.entity.SiteConfig;
import com.pb.blog.service.BlogFacadeService;
import com.pb.blog.service.CategoryService;
import com.pb.blog.service.EntryService;
import com.pb.blog.service.SiteConfigService;

public class BlogFacadeServiceImpl implements BlogFacadeService {
	private Log log = LogFactory.getLog(BlogFacadeServiceImpl.class);
	private SiteConfigService siteConfigService;
	private EntryService entryService;
	private CategoryService categoryService;
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public EntryService getEntryService() {
		return entryService;
	}
	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}
	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}
	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}
	public SiteConfig getDatabaseSiteConfig(){
		return siteConfigService.getDatabaseSiteConfig();
		
	}
	public List<Entry> getPublishedPages() {
		return entryService.getPublishedPages();
		
	}
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}

}
