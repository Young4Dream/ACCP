package com.pb.blog.dao;


import com.pb.blog.entity.User;

public interface UserDao extends BaseDao<User> {
	/**
	 * �����û����õ��û�
	 * @param username �û���
	 * @return
	 */
	public User getUserByUsername(String username);
}
