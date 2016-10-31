package com.pb.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;

import com.pb.blog.common.Constants;
import com.pb.blog.dao.SiteConfigDao;
import com.pb.blog.entity.SiteConfig;
import com.pb.blog.service.SiteConfigService;

public class SiteConfigServiceImpl implements SiteConfigService {
	private Log log = LogFactory.getLog(SiteConfigService.class);
	private Map<String, Object> cache = new HashMap<String, Object>();
	private SiteConfigDao siteConfigDao;

	public SiteConfigDao getSiteConfigDao() {
		return siteConfigDao;
	}

	public void setSiteConfigDao(SiteConfigDao siteConfigDao) {
		this.siteConfigDao = siteConfigDao;
	}

	public SiteConfig getDatabaseSiteConfig() {
		if(cache.get(Constants.SITECONFIG_CACHE_KEY)!=null) {
			if(log.isDebugEnabled()) {
				log.debug("[smartblog]:loading cached siteconfig....");
			}
			return (SiteConfig)cache.get(Constants.SITECONFIG_CACHE_KEY);
		}
		DetachedCriteria criteria = DetachedCriteria.forClass(SiteConfig.class);
		List<SiteConfig> result = this.siteConfigDao.getListByCriteria(criteria);
		if (result.isEmpty()) {
			return null;
		}
		SiteConfig siteConfig = result.get(0);
		cache.put(Constants.SITECONFIG_CACHE_KEY, siteConfig);
		return siteConfig;
	}

}
