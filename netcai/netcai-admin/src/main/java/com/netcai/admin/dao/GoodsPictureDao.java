package com.netcai.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Goods;
import com.netcai.admin.entity.GoodsPicture;

/**
 * 商品图片Dao
 * @author administrator
 */
public interface GoodsPictureDao {

	/*
	 * 批量添加商品图片
	 */
	public int batchInsertGoodsPicture(Goods goods);
	
	/*
	 * 更新商品图片顺序
	 */
	public int updatePictureSeq(GoodsPicture goodsPicture);
	
	/*
	 * 删除商品图片
	 */
	public int deleteGoodsPicture(@Param("goodsId") Long goodsId);
	
	/*
	 * 取得商品图片信息
	 */
	public List<GoodsPicture> getGoodsPicture(@Param("goodsId") Long goodsId);
	
	/*
	 * 删除商品单张图片
	 */
	public int deletePictureById(@Param("picId") Long picId);
}
