package com.zhangsan.goods.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhangsan.goods.domain.Goods;

public interface GoodsService {

	
	   //增加
	    int insertSelective(Goods record);

	    //单查
	    Goods selectByPrimaryKey(Integer id);

	    //修改
	    int updateByPrimaryKeySelective(Goods record);
	    /**
	     * 
	     * @Title: selectGoodsList 
	     * @Description: TODO
	     * @param name
	     * @return
	     * @return: List<Map>
	     */
	    List<Map> selectGoodsList(@Param("name")String name);
	    
	    List<Map> selectBrandList();
	    
	    List<Map> selectGoodsKindList();

}
