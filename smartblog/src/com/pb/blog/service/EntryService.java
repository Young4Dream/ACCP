package com.pb.blog.service;

import java.util.List;

import com.pb.blog.entity.Entry;
import com.pb.blog.util.PaginationSupport;


public interface EntryService {
	public Entry getEntry(String id);
	public Entry plusHits(String entryId);
	public Entry getNextEntry(String id);
	public Entry getPreviousEntry(String id);
	public List<Entry> getRecentEntries(int size);
	public Entry getEntryByName(String name);
	public void saveOrUpdateEntry(Entry entry);
	public PaginationSupport<Entry> getEntryPage(Entry entry, int pageSize, int startIndex, String order, Boolean isDesc);
	public List<Entry> getPublishedPages();
	public List<Entry> getPages(String entryStatus);
}
