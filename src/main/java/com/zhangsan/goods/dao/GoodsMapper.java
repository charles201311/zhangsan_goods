package com.zhangsan.goods.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhangsan.goods.domain.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    /**
     * 
     * @Title: selectGoodsList 
     * @Description: TODO
     * @param name
     * @return
     * @return: List<Map>
     */
    List<Map> selectGoodsList(@Param("name")String name);
}