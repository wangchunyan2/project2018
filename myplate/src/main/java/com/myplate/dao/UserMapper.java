package com.myplate.dao;

import org.apache.ibatis.annotations.Param;

import com.myplate.pojo.User;

public interface UserMapper {
	public User getUserByUserName(@Param("userName")String userName);
	public void save(User user);

}
