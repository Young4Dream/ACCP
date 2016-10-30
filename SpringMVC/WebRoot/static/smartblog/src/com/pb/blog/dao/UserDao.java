package com.pb.blog.dao;


import com.pb.blog.entity.User;

public interface UserDao extends BaseDao<User> {
	/**
	 * 根据用户名拿到用户
	 * @param username 用户名
	 * @return
	 */
	public User getUserByUsername(String username);
}
