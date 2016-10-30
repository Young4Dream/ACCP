
package com.pb.blog.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.pb.blog.dao.CategoryDao;
import com.pb.blog.entity.Category;



public class CategoryDaoHibernateImpl extends BaseHibernateDaoSupport<Category>
		implements CategoryDao {
	private static final Log log = LogFactory.getLog(CategoryDaoHibernateImpl.class);
	@SuppressWarnings("unchecked")
	public List<Category> getCategories() {
		return getHibernateTemplate().find("from Category");
	}
	/**
	 * 根据分类的名字获取分类对象
	 * @param name:分类名
	 */
	@SuppressWarnings("unchecked")
	public Category getCategoryByName(String name) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Category.class);
		criteria.add(Restrictions.eq("name", name));
		List result = getHibernateTemplate().findByCriteria(criteria);
		if(result.isEmpty()){
			return null;
		}else if(result.size()>1) {
			log.error("[smarmtblog]:there are " + result.size() + " categories found with name:" + name + ", but unique required!");
		}
		return (Category) result.get(0);
	}
	
	
	public void move(String id, String from, String to) {
		Category cate = get(id);
		//move out
		Category parent = get(from);
		parent.getChildren().remove(cate);
		saveOrUpdate(parent);
		cate.setParent(null);
		//move in
		cate.setParent(get(to));
		saveOrUpdate(cate);
		Category newParent = get(to);
		newParent.getChildren().add(cate);
		saveOrUpdate(newParent);
	}
}
