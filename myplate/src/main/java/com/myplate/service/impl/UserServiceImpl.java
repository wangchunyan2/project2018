package com.myplate.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myplate.dao.UserMapper;
import com.myplate.pojo.User;
import com.myplate.service.IUserService;
@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService{
	@Resource
	UserMapper userMapper;
	@Autowired
	private UserMapper userDao;
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserName(userName);
	}
	public void save(User user){
		userDao.save(user);
	}

}
