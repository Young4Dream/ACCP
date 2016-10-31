package com.pb.blog.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.pb.blog.util.PaginationSupport;

public interface BaseDao<T> {
	
	/**
	 * Save or update the domain
	 * 保存或更新实体
	 * @param domain Domain to saveOrUpdate
	 */
	public void saveOrUpdate(T domain);
	
	/**
	 * delete the domain from database
	 * @param domain domain to remove
	 */
	public void delete(T domain);

	/**
	 * @param id
	 * @return
	 */
	public T get(Serializable id);
	
	/**
	 * find object by pagination supprot
	 * @param detachedCriteria 
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	public PaginationSupport<T> findPageByCriteria(DetachedCriteria detachedCriteria, int pageSize, int startIndex);
	
	/**
	 * Get list by criteria
	 * @param detachedCriteria the domain query criteria, include condition and the orders.
	 * @return
	 */
	public List<T> getListByCriteria(DetachedCriteria detachedCriteria);
	
	/**
	 * Get list by criteria
	 * @param detachedCriteria
	 * @param offset
	 * @param size
	 * @return
	 */
	public List<T> getListByCriteria(DetachedCriteria detachedCriteria, int offset, int size);
}
