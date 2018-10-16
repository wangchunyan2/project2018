package com.myplate.service;

import java.util.List;
import java.util.Map;

import com.myplate.pojo.QueryConsumer;


public interface IMyplateService {
	List<QueryConsumer> queryInfo(String createBy,String female,
			String power_level);
}
