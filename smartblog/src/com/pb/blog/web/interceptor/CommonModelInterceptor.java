package com.pb.blog.web.interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.pb.blog.entity.Category;
import com.pb.blog.entity.Entry;
import com.pb.blog.entity.SiteConfig;
import com.pb.blog.service.BlogFacadeService;

public class CommonModelInterceptor extends AbstractInterceptor {
	private static Log logger = LogFactory.getLog(CommonModelInterceptor.class);
	private BlogFacadeService blogFacadeService;

	public BlogFacadeService getBlogFacadeService() {
		return blogFacadeService;
	}

	public void setBlogFacadeService(BlogFacadeService blogFacadeService) {
		this.blogFacadeService = blogFacadeService;
	}

	private Map<String,Object> modelMap = new HashMap<String,Object>();
	private SiteConfig siteConfig;
	private List<Category> categories;
	private List<Entry> pages;
	

	public List<Entry> getPages() {
		return pages;
	}

	public void setPages(List<Entry> pages) {
		this.pages = pages;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public SiteConfig getSiteConfig() {
		return siteConfig;
	}

	public void setSiteConfig(SiteConfig siteConfig) {
		this.siteConfig = siteConfig;
	}

	public Map<String, Object> getModelMap() {
		return modelMap;
	}

	public void setModelMap(Map<String, Object> modelMap) {
		this.modelMap = modelMap;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
//		siteConfig = blogFacadeService.getDatabaseSiteConfig();
//		categories = blogFacadeService.getCategories();
//		pages = blogFacadeService.getPublishedPages();
		return invocation.invoke();
	}

}
