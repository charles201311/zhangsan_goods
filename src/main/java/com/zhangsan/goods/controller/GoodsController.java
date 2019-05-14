package com.zhangsan.goods.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangsan.goods.domain.Goods;
import com.zhangsan.goods.service.GoodsService;
import com.zhangsan.goods.utils.PageUtil;

@Controller
public class GoodsController {

	@Resource
	private GoodsService goodsService;

	@RequestMapping("list")
	public String list(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "") String name) {
		Integer pageSize = 8;
		PageHelper.startPage(page, pageSize);
		List<Map> list = goodsService.selectGoodsList(name);

		PageInfo<Map> info = new PageInfo<>(list);
		// 分页信息
		PageUtil.page(request, "/list?name=" + name, pageSize, list, (int) info.getTotal(), page);
		request.setAttribute("name", name);// 查询条件
		request.setAttribute("list", list);// 查询的结果集

		return "list";

	}

	@RequestMapping("toAdd")
	public String toAdd() {

		return "add";

	}

	@ResponseBody
	@RequestMapping("add")
	public boolean add(MultipartFile pic, Goods goods) {
		
		try {
			
	
		if (null != pic && !pic.isEmpty()) {
			// 上传的原始文件名称 1.jpg
			String filename = pic.getOriginalFilename();
			// 为了防止文件重名
			String newFileName = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
			String path = "d:/pic/";// 文件的存储地址
			File f = new File(path + newFileName);
			pic.transferTo(f);//把文件写入硬盘
//设置文件地址			
			goods.setUrl(newFileName);
			goodsService.insertSelective(goods);
			
			return true;

		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	@ResponseBody
	@RequestMapping("getBrandList")
	public List<Map> getBrandList() {
		return goodsService.selectBrandList();

	}

	@ResponseBody
	@RequestMapping("getKindList")
	public List<Map> getKindList() {
		return goodsService.selectGoodsKindList();

	}
	
	@RequestMapping("test")
	public void test1() {

		System.out.println("def");

		System.out.println("abc");
	}
}
