package com.pb.blog.dao;

import java.util.List;

import com.pb.blog.entity.Comment;

public interface CommentDao extends BaseDao<Comment> {

	/**
	 * get the recent comments,the status is approved.
	 * @param size the comment's size
	 * @return the comments
	 */
	public List<Comment> getRecentComments(int size);
	
	/**
	 * get the comment list by entry's id
	 * @param entryId the entry's id
	 * @return the entry's comment list
	 */
	public List<Comment> getCommentListByEntryId(String entryId);
	
	
	
	/**
	 * 
	 * @param entryId
	 * @param status
	 * @return
	 */
	public List<Comment> getCommentListByEntryIdAndStatus(String entryId, String status);
	
	/**
	 * get the distinct email about the entry's subscribe comment.
	 * @param entryId
	 * @return
	 */
	public List<String> getSubscribeEntryCommentEmails(String entryId);
}