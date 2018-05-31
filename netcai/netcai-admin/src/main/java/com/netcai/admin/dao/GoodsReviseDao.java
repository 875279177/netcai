package com.netcai.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.GoodsRevise;
import com.netcai.admin.vo.GoodsReviseVo;

/**
 * 商品上下架监控Dao
 * @author administrator
 */
public interface GoodsReviseDao {

	/**
	 * 新增上下架调整记录
	 */
	public int insertGoodsRevise(GoodsRevise goodsRevise);
	
	/**
	 * 分页查询上下架格调整记录
	 * 
	 * @param goodsRevise
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<GoodsReviseVo> getAllGoodsRevise(@Param("goodsRevise") GoodsReviseVo goodsRevise, @Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getPageCount(@Param("goodsRevise") GoodsReviseVo goodsRevise);
}
