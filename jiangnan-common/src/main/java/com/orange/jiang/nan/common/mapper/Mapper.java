package com.orange.jiang.nan.common.mapper;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.rowbounds.SelectRowBoundsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

@RegisterMapper
public interface Mapper<T> extends BaseMapper<T>, SelectRowBoundsMapper<T>, IdsMapper<T>, InsertListMapper<T> {
}