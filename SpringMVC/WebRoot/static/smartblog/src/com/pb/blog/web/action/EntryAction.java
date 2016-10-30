package com.pb.blog.web.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pb.blog.service.EntryService;

public class EntryAction extends BaseAction{
	private static Log logger = LogFactory.getLog(EntryAction.class);
	private EntryService entryService;
	public String addEntry(){
		
		return "list";
	}

	public EntryService getEntryService() {
		return entryService;
	}
	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}
	

}
