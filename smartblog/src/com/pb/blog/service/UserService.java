package com.pb.blog.service;

import com.pb.blog.entity.User;
import com.pb.blog.exception.InvalidPasswordException;
import com.pb.blog.exception.InvalidUsernameException;

public interface UserService {
	public User getUserByUsername(String userName);
	public User login(String username, String password) throws InvalidUsernameException, InvalidPasswordException;

}
