package com.zhangsan.goods.dao;

import java.util.List;
import java.util.Map;

import com.zhangsan.goods.domain.GoodsKind;

public interface GoodsKindMapper {
    int deleteByPrimaryKey(Integer kid);

    int insert(GoodsKind record);

    int insertSelective(GoodsKind record);

    GoodsKind selectByPrimaryKey(Integer kid);

    int updateByPrimaryKeySelective(GoodsKind record);

    int updateByPrimaryKey(GoodsKind record);
    
    List<Map> selectGoodsKindList();
}