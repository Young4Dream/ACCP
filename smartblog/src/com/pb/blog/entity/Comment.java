/**
 * created on 2005-10-4
 */
package com.pb.blog.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;




public class Comment extends BaseDomain{

	private static final long serialVersionUID = 5768255536761337291L;

	private String authorName;

	private String authorSite;

	private String userId;
	
	private String authorMail;

	private Date postTime;

	private String postIP;

	private Entry entry;



	private String content;
	
	private String status;

	
	public String getStatus() {
		return status;
	}

	/**
	 * set the comment's status, if parameter status is not in <strong>Status.COMMENT_STATUS</strong>, then set the
	 * status to <strong>Status.WAIT_FOR_APPROVE</strong>.
	 * 
	 * @param status
	 * @see Status
	 */
	public void setStatus(String status) {
		if (Status.COMMENT_STATUS.contains(status)) {
			this.status = status;
		} else {
			this.status = Status.WAIT_FOR_APPROVE;
		}
	}
	
	/**
	 * The comment status.
	 * 
	 */
	public final static class Status {
		private Status() {
		}

		/**
		 * the comment is approved.<br />
		 * <code><strong>approved</strong></code>
		 */
		public static final String APPROVED = "approved";

		/**
		 * the comment is wait for approve.<br />
		 * <code><strong>wait_for_approve</strong></code>
		 */
		public static final String WAIT_FOR_APPROVE = "wait_for_approve";

		/**
		 * the comment is a spam.<br />
		 * <code><strong>spam</strong></code>
		 */
		public static final String SPAM = "spam";

		/**
		 * all of the comment's status.<br />
		 * <code><strong>approved</strong></code>&nbsp;<code><strong>wait_for_approve</strong></code>&nbsp;<code><strong>spam</strong></code>
		 */
		public static final List<String> COMMENT_STATUS = Arrays
				.asList(new String[] { APPROVED, WAIT_FOR_APPROVE, SPAM });
	}
	
	public final static class Type {
		/**
		 * the comment type is trackback.<br />
		 * <code><strong>trackback</strong></code>
		 */
		public static final String TRACKBACK = "trackback";
	}
	
	

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Comment(){
    }
    
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthorMail() {
		return authorMail;
	}

	public void setAuthorMail(String authorMail) {
		this.authorMail = authorMail;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorSite() {
		return authorSite;
	}

	public void setAuthorSite(String authorSite) {
		this.authorSite = authorSite;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}


	public String getPostIP() {
		return postIP;
	}

	public void setPostIP(String postIP) {
		this.postIP = postIP;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.authorName + " says:" + this.content;
	}
}