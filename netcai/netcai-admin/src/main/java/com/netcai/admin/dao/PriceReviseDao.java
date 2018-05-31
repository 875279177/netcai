package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.PriceRevise;
import com.netcai.admin.vo.PriceReviseVo;

/**
 * 商品价格调整Dao
 * @author administrator
 */
public interface PriceReviseDao {

	/**
	 * 新增价格调整记录
	 */
	public int insertPriceRevise(PriceRevise priceRevise);
	
	/**
	 * 分页查询商品价格调整记录
	 * 
	 * @param priceRevise
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<PriceReviseVo> getAllPriceRevise(@Param("priceRevise") PriceReviseVo priceRevise, @Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getPageCount(@Param("priceRevise") PriceReviseVo priceRevise);
}
