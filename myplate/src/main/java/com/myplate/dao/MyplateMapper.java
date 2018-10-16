package com.myplate.dao;

import java.util.List;
import java.util.Map;

import com.myplate.pojo.QueryConsumer;
import org.apache.ibatis.annotations.Param;


public interface MyplateMapper {
	 List<QueryConsumer> queryInfo(@Param("userName")String userName, @Param("userSex")String userSex, @Param("powerLevel")String powerLevel);
}
