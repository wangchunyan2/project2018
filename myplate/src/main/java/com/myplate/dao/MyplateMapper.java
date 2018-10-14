package com.myplate.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface MyplateMapper {
	public List<Map<String,String>> queryInfo(@Param("create_by")String createBy,@Param("female")String female,
			@Param("power_level")String power_level);
}
