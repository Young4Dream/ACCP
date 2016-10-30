package com.pb.blog.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.views.freemarker.FreemarkerManager;

import com.pb.blog.common.Constants;
import com.pb.blog.entity.Category;
import com.pb.blog.entity.Entry;
import com.pb.blog.entity.SiteConfig;
import com.pb.blog.service.BlogFacadeService;
import com.pb.blog.service.EntryService;
import com.pb.blog.util.PaginationSupport;

public class IndexAction extends BaseAction {
	private static final Log log = LogFactory.getLog(IndexAction.class);
	private EntryService entryService;
	private BlogFacadeService blogFacadeService;
	private SiteConfig siteConfig;
	private List<Category> categories;
	private List<Entry> pages;
	

	public BlogFacadeService getBlogFacadeService() {
		return blogFacadeService;
	}

	public void setBlogFacadeService(BlogFacadeService blogFacadeService) {
		this.blogFacadeService = blogFacadeService;
	}
	PaginationSupport<Entry> ps ;
	public PaginationSupport<Entry> getPs() {
		return ps;
	}
	public void setPs(PaginationSupport<Entry> ps) {
		this.ps = ps;
	}
	public String execute(){
		String currentPage = (String)getRequest().get("p");
		int intPage = 1;
		if(StringUtils.isNotBlank(currentPage)){
			try {
				intPage = Integer.parseInt(currentPage);
			} catch (Exception e) {
				log.error("parameter error: page must a number", e);
			}
		}
		if(intPage<1){
			intPage = 1;
		}
		Entry entry = new Entry();
		entry.setEntryStatus(Entry.EntryStatus.PUBLISH);
		entry.setType(Entry.Type.POST);
		ps = entryService.getEntryPage(entry, Constants.DEFAULT_PAGE_SIZE, (intPage-1) * Constants.DEFAULT_PAGE_SIZE, null, null);
		siteConfig = blogFacadeService.getDatabaseSiteConfig();
		categories = blogFacadeService.getCategories();
		pages = blogFacadeService.getPublishedPages();
		return SUCCESS;
	}
	public EntryService getEntryService() {
		return entryService;
	}
	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}

	public SiteConfig getSiteConfig() {
		return siteConfig;
	}

	public void setSiteConfig(SiteConfig siteConfig) {
		this.siteConfig = siteConfig;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Entry> getPages() {
		return pages;
	}

	public void setPages(List<Entry> pages) {
		this.pages = pages;
	}
	

}
