package com.zhangsan.goods.dao;

import java.util.List;
import java.util.Map;

import com.zhangsan.goods.domain.Brand;

public interface BrandMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
    
    List<Map> selectBrandList();
}