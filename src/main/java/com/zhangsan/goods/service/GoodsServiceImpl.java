package com.zhangsan.goods.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangsan.goods.dao.BrandMapper;
import com.zhangsan.goods.dao.GoodsKindMapper;
import com.zhangsan.goods.dao.GoodsMapper;
import com.zhangsan.goods.domain.Goods;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsMapper goodsMapper;
	
	@Resource
	private BrandMapper brandMapper;
	
	@Resource
	private GoodsKindMapper goodsKindMapper;
	@Override
	public int insertSelective(Goods record) {
		// TODO Auto-generated method stub
		return goodsMapper.insertSelective(record);
	}

	@Override
	public Goods selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return goodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Goods record) {
		// TODO Auto-generated method stub
		return goodsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map> selectGoodsList(String name) {
		// TODO Auto-generated method stub
		return goodsMapper.selectGoodsList(name);
	}

	@Override
	public List<Map> selectBrandList() {
		// TODO Auto-generated method stub
		return brandMapper.selectBrandList();
	}

	@Override
	public List<Map> selectGoodsKindList() {
		// TODO Auto-generated method stub
		return goodsKindMapper.selectGoodsKindList();
	}

}
