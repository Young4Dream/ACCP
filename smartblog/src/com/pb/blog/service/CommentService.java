package com.pb.blog.service;

import java.util.List;

import com.pb.blog.entity.Comment;
import com.pb.blog.util.PaginationSupport;

public interface CommentService {
	
	public Comment getComment(String id);
	public List<Comment> getRecentComments(int size);
	public PaginationSupport<Comment> getCommentPageByEntryId(String entryId, int pageSize, int startIndex, String order, Boolean isDesc);
	public List<Comment> getCommentListByEntryId(String entryId);
	public List<Comment> getCommentListByEntryIdAndStatus(String entryId, String status);
	
}
