package com.myplate.service.impl;

import java.util.List;
import java.util.Map;

import com.myplate.pojo.QueryConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myplate.dao.MyplateMapper;
import com.myplate.service.IMyplateService;
@Transactional
@Service("imyplateService")
public class MyServiceImpl implements IMyplateService{
	@Autowired
	private MyplateMapper myplateMapper;

	public List<QueryConsumer> queryInfo(String userName, String userSex,
										 String powerLevel) {
		// TODO Auto-generated method stub
		return myplateMapper.queryInfo(userName, userSex, powerLevel);
	}

}
