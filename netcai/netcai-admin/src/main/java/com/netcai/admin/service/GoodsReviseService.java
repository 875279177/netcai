package com.netcai.admin.service;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.GoodsReviseVo;

/**
 * 商品上下架调整Service
 * @author administrator
 *
 */
public interface GoodsReviseService {

	/**
	 * 分页查询商品上下架调整记录
	 * @param goodsRevise
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAllGoodsRevise(@Param("goodsRevise") GoodsReviseVo goodsRevise, @Param("offset") int offset,
			@Param("pageSize") int pageSize);
}
