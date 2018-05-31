package com.netcai.admin.service;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.PriceReviseVo;

/**
 * 商品价格调整Service
 * @author administrator
 *
 */
public interface PriceReviseService {
	
	/**
	 * 分页查询商品价格调整记录
	 * 
	 * @param priceRevise
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAllPriceRevise(@Param("priceRevise") PriceReviseVo priceRevise, @Param("offset") int offset,
			@Param("pageSize") int pageSize);

}
