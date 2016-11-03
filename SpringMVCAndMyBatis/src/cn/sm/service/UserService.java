package cn.sm.service;

import java.util.List;

import cn.sm.pojo.User;

public interface UserService {
	public List<User> queryAll();
	public int update(User u);
	public int add(User u);
	public int delete(User u);
	public User query(User u);
}
