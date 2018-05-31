package com.netcai.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Goods;
import com.netcai.admin.entity.GoodsSeq;
import com.netcai.admin.vo.GoodsListVo;
import com.netcai.admin.vo.GoodsVo;
import com.netcai.admin.vo.SearchGoodsVo;

/**
 * 商品Dao
 * @author administrator
 */
public interface GoodsDao {

	/**
	 * 分页查询商品信息
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<GoodsListVo> getAllGoods(@Param("goods") SearchGoodsVo goods,@Param("offset") int offset,
			@Param("pageSize") int pageSize);
	
	/**
	 * 分页查询商品信息
	 */
	public List<GoodsListVo> getAllGoodsByCommon(@Param("goods") SearchGoodsVo goods,@Param("offset") int offset,@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 */
	public int getPageCount(@Param("goods") SearchGoodsVo goods);
	
	/**
	 * 查询总记录数
	 */
	public int getPageCountByCommon(@Param("goods") SearchGoodsVo goods);
	
	/**
	 * 新增商品信息
	 */
	public long insertGoods(Goods goods);

	/**
	 * 更新商品信息
	 */
	public int updateGoods(Goods goods);
	
	/**
	 * 根据id查找商品信息
	 */
	public Goods getGoodsById(@Param("goodsId") int goodsId);
	
	/**
	 * 搜索商品信息
	 */
	public List<GoodsVo> searchGoods(@Param("goodsVo") GoodsVo goodsVo);
	
	/**
	 * 查询商品最大的顺序号
	 */
	public int getMaxGoodsSeq(@Param("userId") Long userId);
	
	/**
	 * 上架/下架商品
	 */
	public int updateGoodsStatus(@Param("goodsIds") String goodsIds,@Param("goodsStatus") Short goodsStatus);
	
	/**
	 * 复制商品
	 */
	public int copyGoods(Goods goods);
	
	/**
	 * 判断商品是否可以删除
	 */
	public Integer checkGoods(@Param("goodsId") Long goodsId);
	
	/**
	 * 删除商品
	 */
	public int deleteGoods(@Param("goodsId") Long goodsId);
	
	/**
	 * 批量修改商品顺序
	 */
	public int batchUpdateGoodsSeq(@Param("goodsSeqList") List<GoodsSeq> goodsSeqList);
	
	/**
	 * 根据商家id查询商品信息
	 */
	public List<Map<String, Object>>selectGoodsByUserId(Long userId);
}
