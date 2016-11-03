package cn.sm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sm.dao.UserMapper;
import cn.sm.pojo.User;
@Service
public class UserServiceImpl implements UserService{
	@Resource
private UserMapper userMapper;

@Override
public List<User> queryAll() {
	// TODO Auto-generated method stub
	return userMapper.queryAll();
}

@Override
public int update(User u) {
	// TODO Auto-generated method stub
	return userMapper.update(u);
}

@Override
public int add(User u) {
	// TODO Auto-generated method stub
	return userMapper.add(u);
}

@Override
public int delete(User u) {
	// TODO Auto-generated method stub
	return userMapper.delete(u);
}

@Override
public User query(User u) {
	// TODO Auto-generated method stub
	return userMapper.query(u);
}

}
