package com.pb.blog.service.impl;

import com.pb.blog.dao.UserDao;
import com.pb.blog.entity.User;
import com.pb.blog.exception.InvalidPasswordException;
import com.pb.blog.exception.InvalidUsernameException;
import com.pb.blog.service.UserService;
import com.pb.blog.util.SHA;

public class UserServiceImpl implements UserService{
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getUserByUsername(String userName) {
		return this.userDao.getUserByUsername(userName);
	}
	
	public User login(String username, String password) throws InvalidUsernameException, InvalidPasswordException {
		User user = this.userDao.getUserByUsername(username);
		if (user == null) {
			throw new InvalidUsernameException("Invalid Username!,no user with username:" + username);
		}
		if (!user.getPassword().equals(SHA.hashPassword(password))) {
			throw new InvalidPasswordException("Invalid password!");
		}
		return user;
	}
	
}
