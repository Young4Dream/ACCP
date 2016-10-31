package com.pb.blog.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.pb.blog.dao.UserDao;
import com.pb.blog.entity.User;
import com.pb.blog.exception.BlogException;

public class UserDaoHibernateImpl extends BaseHibernateDaoSupport<User>
		implements UserDao {
	
	@SuppressWarnings("unchecked")
	public User getUserByUsername(String username){
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", username));
		List<User> users = getHibernateTemplate().findByCriteria(criteria);
		if (users.isEmpty()) {
			return null;
		}else if (users.size()>1) {
			throw new BlogException("there are:" + users.size() + " found, but unique required!");
		}
		return users.get(0);
	}
}
