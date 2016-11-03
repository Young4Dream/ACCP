package cn.sm.dao;

import java.util.List;

import cn.sm.pojo.User;

public interface UserMapper {
	public List<User> queryAll();
	public int update(User u);
	public int add(User u);
	public int delete(User u);
	public User query(User u);
}
