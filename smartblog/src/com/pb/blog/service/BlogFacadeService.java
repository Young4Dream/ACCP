package com.pb.blog.service;

import java.util.List;

import com.pb.blog.entity.Category;
import com.pb.blog.entity.Entry;
import com.pb.blog.entity.SiteConfig;

public interface BlogFacadeService {
	public SiteConfig getDatabaseSiteConfig();
	public List<Entry> getPublishedPages();
	public List<Category> getCategories();

}
