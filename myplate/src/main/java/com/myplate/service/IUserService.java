package com.myplate.service;


import com.myplate.pojo.User;

public interface IUserService {
	public User getUserByUserName(String userName);
	public void save(User user);

}
