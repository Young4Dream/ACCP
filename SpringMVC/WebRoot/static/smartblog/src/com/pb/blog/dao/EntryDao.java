package com.pb.blog.dao;

import java.util.Date;
import java.util.List;

import com.pb.blog.entity.Entry;

public interface EntryDao extends BaseDao<Entry> {
	/**
	 * get entry by entry's name
	 * @param name the entry's name
	 * @return Entry
	 */
	public Entry getEntryByName(String name);
	
	/**
	 * get the recent entries.
	 * @param size
	 * @return the entry list
	 */
	public List<Entry> getRecentEntries(int size);
	
	/**
	 * get the next entry by the current entry's id ,it's means older than the current entry.
	 * @param id the current entry's id
	 * @return the nexe entry
	 */
	public Entry getNextEntry(String id);
	
	/**
	 * get the previous entry by the current entry's id, it's means newer than the current entry.
	 * @param id the current entry's id
	 * @return the previous entry
	 */
	public Entry getPreviousEntry(String id);
	
	/**
	 * get the related entries.
	 * @param entry
	 * @return
	 */
	public List<Entry> getRelatedEntries(Entry entry, int size);
	
	/**
	 * get all of the pages.<br/>
	 * Entry's type is <i>page</i>
	 * @param entryStatus the entryStatus.if null got all of the pages.
	 * @return
	 */
	public List<Entry> getPages(String entryStatus);
	
	/**
	 * get the month list for archive.
	 * @return
	 */
	public List<Date> getMonthList();
}
