package com.pb.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.pb.blog.common.Constants;
import com.pb.blog.dao.CommentDao;
import com.pb.blog.entity.Comment;
import com.pb.blog.service.CommentService;
import com.pb.blog.util.PaginationSupport;

public class CommentServiceImpl implements CommentService {
	private Log log = LogFactory.getLog(CommentServiceImpl.class);
	private Map<String, Object> cache = new HashMap<String, Object>();
	private CommentDao commentDao;
	

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public Comment getComment(String id) {
		return this.commentDao.get(id);
	}

	public List<Comment> getCommentListByEntryId(String entryId) {
		return this.commentDao.getCommentListByEntryId(entryId);
	}

	public List<Comment> getCommentListByEntryIdAndStatus(String entryId,
			String status) {
		return this.commentDao.getCommentListByEntryIdAndStatus(entryId, status);
	}

	public PaginationSupport<Comment> getCommentPageByEntryId(String entryId,
			int pageSize, int startIndex, String order, Boolean isDesc) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Comment.class);
		criteria.createCriteria("entry").add(Restrictions.eq("id", entryId));
		return this.commentDao.findPageByCriteria(criteria, pageSize, startIndex);
	}

	public List<Comment> getRecentComments(int size) {
		if(cache.get(Constants.RECENT_COMMENTS_CACHE_KEY)!=null){
			if(log.isDebugEnabled()) {
				log.debug("[smartblog]:loading cached recent comments....");
			}
			return (List<Comment>)cache.get(Constants.RECENT_COMMENTS_CACHE_KEY);
		}else{
			List<Comment> comments = this.commentDao.getRecentComments(size);
			cache.put(Constants.RECENT_COMMENTS_CACHE_KEY, comments);
			return comments;
		}
	}

}
