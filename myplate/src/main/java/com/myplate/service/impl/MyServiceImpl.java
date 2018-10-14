package com.myplate.service.impl;

import java.util.List;
import java.util.Map;

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

	public List<Map<String,String>> queryInfo(String createBy, String female,
			String power_level) {
		// TODO Auto-generated method stub
		return myplateMapper.queryInfo(createBy, female, power_level);
	}

}
