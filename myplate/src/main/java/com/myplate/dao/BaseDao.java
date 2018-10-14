package com.myplate.dao;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by Leon on 17/3/24.
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T>, ConditionMapper<T>, IdsMapper<T> {
}
