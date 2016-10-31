package com.pb.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


import com.pb.blog.common.Constants;
import com.pb.blog.dao.EntryDao;
import com.pb.blog.entity.Entry;
import com.pb.blog.service.EntryService;
import com.pb.blog.util.PaginationSupport;

public class EntryServiceImpl implements EntryService {
	private Log log = LogFactory.getLog(EntryServiceImpl.class);
	private EntryDao entryDao;
	private Map<String, Object> cache = new HashMap<String, Object>();
	private int last_recent_entry_size = 0;

	public EntryDao getEntryDao() {
		return entryDao;
	}

	public void setEntryDao(EntryDao entryDao) {
		this.entryDao = entryDao;
	}

	public Entry getEntry(String id) {
		return this.entryDao.get(id);
	}

	public Entry getEntryByName(String name) {
		return this.entryDao.getEntryByName(name);
	}

	public Entry getNextEntry(String id) {
		return this.entryDao.getNextEntry(id);
	}

	public Entry getPreviousEntry(String id) {
		return this.entryDao.getPreviousEntry(id);
	}

	public List<Entry> getRecentEntries(int size) {
		if (size == last_recent_entry_size) {
			if(cache.get(Constants.RECENT_ENTRIES_CACHE_KEY)!=null){
				if(log.isDebugEnabled()) {
					log.debug("[smartblog]:loading cached recent entries....");
				}
				return (List<Entry>)cache.get(Constants.RECENT_ENTRIES_CACHE_KEY);
			}
		} else {
			last_recent_entry_size = size;
		}
		List<Entry> entries = this.entryDao.getRecentEntries(size);
		cache.put(Constants.RECENT_ENTRIES_CACHE_KEY, entries);
		return entries;
	}

	public Entry plusHits(String entryId) {
		Entry entry = this.entryDao.get(entryId);
		if(entry.getHits()==null) {
			entry.setHits(1);
		}else{
			entry.setHits(entry.getHits()+1);
		}
		this.entryDao.saveOrUpdate(entry);
		return entry;
	}

	public void saveOrUpdateEntry(Entry entry) {
		this.entryDao.saveOrUpdate(entry);
		clearRecentEntriesCache();
		clearMonthListCache();
		clearHotTagsCache();
	}
	private void clearRecentEntriesCache(){
		cache.put(Constants.RECENT_ENTRIES_CACHE_KEY, null);
		if(log.isDebugEnabled()) {
			log.debug("[smartblog]:clear cached recent entries....");
		}
	}
	private void clearMonthListCache() {
		cache.put(Constants.ARCHIVE_MONTH_LIST_CACHE_KEY, null);
		log.debug("[smartblog]:clear month list cache...");
	}
	private void clearHotTagsCache() {
		cache.put(Constants.HOT_TAGS_CACHE_KEY, null);
		log.debug("[smartblog]:clean hot tags cache..");
	}

	public PaginationSupport<Entry> getEntryPage(Entry entry, int pageSize,
			int startIndex, String order, Boolean isDesc) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Entry.class);
		if (StringUtils.isNotBlank(entry.getTitle())&& StringUtils.isNotBlank(entry.getContent())) {
			criteria.add(Restrictions.or(Restrictions.ilike("title", entry.getTitle(), MatchMode.ANYWHERE), Restrictions.ilike("content", entry.getContent(), MatchMode.ANYWHERE)));
		} else if (StringUtils.isNotBlank(entry.getTitle())){
			criteria.add(Restrictions.ilike("title", entry.getTitle(), MatchMode.ANYWHERE));
		} else if (StringUtils.isNotBlank(entry.getContent())) {
			criteria.add(Restrictions.ilike("content", entry.getContent()));
		}
		if(StringUtils.isNotBlank(entry.getEntryStatus())) {
			criteria.add(Restrictions.eq("entryStatus", entry.getEntryStatus()));
		}
		if(StringUtils.isNotBlank(entry.getType())) {
			criteria.add(Restrictions.eq("type", entry.getType()));
		}
		if (StringUtils.isNotBlank(order)) {
			if(isDesc==null || !isDesc){
				criteria.addOrder(Order.asc(order));
			}else{
				criteria.addOrder(Order.desc(order));
			}
		}else{
			criteria.addOrder(Order.desc("postTime"));
		}
		return this.entryDao.findPageByCriteria(criteria, pageSize, startIndex);
	}

	public List<Entry> getPublishedPages() {
		if(cache.get(Constants.PAGES_CACHE_KEY)!=null){
			if (log.isDebugEnabled()) {
				log.debug("[smartblog]:loading cached published pages..");
			}
			return (List<Entry>)cache.get(Constants.PAGES_CACHE_KEY);
		}
		List<Entry> pages = getPages(Entry.EntryStatus.PUBLISH);
		cache.put(Constants.PAGES_CACHE_KEY, pages);
		return pages;
	}

	public List<Entry> getPages(String entryStatus) {
		return this.entryDao.getPages(entryStatus);
	}
	

}
