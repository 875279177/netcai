package com.netcai.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.netcai.admin.entity.Goods;
import com.netcai.admin.entity.GoodsFormat;
import com.netcai.admin.entity.GoodsPicture;
import com.netcai.admin.entity.GoodsSeq;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.GoodsListVo;
import com.netcai.admin.vo.GoodsVo;
import com.netcai.admin.vo.SearchGoodsVo;

/**
 * 商品service
 * @author administrator
 */
public interface GoodsService {

	/**
	 * 分页查询商品信息
	 * @param currentPageNum
	 * @param currentPageSize
	 * @return
	 */
	public List<GoodsListVo> getAllGoods(SearchGoodsVo goods,int currentPageNum,int currentPageSize);

	/**
	 * 查询总记录数
	 * @return PageUtil
	 */
	public PageUtil getPageResult(SearchGoodsVo goods,int currentPageNum,int currentPageSize);
	
	/**
	 * 查询总记录数	常用清单;
	 */
	public PageUtil getPageResultByCommon(SearchGoodsVo goods,int currentPageNum,int currentPageSize);
	
	
	/**
	 * 新增商品信息
	 */
	public long insertGoods(Goods goods);

	/**
	 * 更新商品信息
	 */
	public int updateGoods(Goods goods,Long sysUserId);
	
	/**
	 * 根据id查找商品信息
	 */
	public Goods getGoodsById(int goodsId);
	
	/**
	 * 更新商品图片顺序
	 */
	public int updatePictureSeq(GoodsPicture goodsPicture);
	
	/**
	 * 搜索商品信息
	 */
	public List<GoodsVo> searchGoods(GoodsVo goodsVo);
	
	/**
	 * 修改商品规格
	 */
	public int updateGoodsFormat(GoodsFormat goodsFormat,Long sysUserId);
	
	/**
	 * 复制商品
	 */
	public int copyGoods(Long goodsId,Long sellerId,HttpServletRequest request);
	
	/**
	 * 删除商品
	 */
	public int deleteGoods(Long goodsId,HttpServletRequest request);
	
	/**
	 * 上架/下架商品
	 */
	public int updateGoodsStatus(String goodsIds,Short goodsStatus);
	
	/**
	 * 删除商品规格
	 */
	public int deleteGoodsFormat(Long formatId);
	
	/**
	 * 删除商品图片
	 */
	public int deleteGoodsPicture(Long picId,String picUrl,HttpServletRequest request);
	
	/**
	 * 批量修改商品顺序
	 */
	public int batchUpdateGoodsSeq(List<GoodsSeq> goodsSeqList);
	
	/**
	 * 根据商家id查询商品信息
	 */
	public List<Map<String, Object>> selectGoodsByUserId(Long userId);
	
	/**
	 * 根据商品id查询规格
	 */
	public List<GoodsFormat> getGoodsFormats(Long goodsId);
}
