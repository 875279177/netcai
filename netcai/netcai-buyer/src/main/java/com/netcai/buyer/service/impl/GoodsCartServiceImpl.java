package com.netcai.buyer.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.GoodsCartDao;
import com.netcai.buyer.dao.GoodsFormatDao;
import com.netcai.buyer.entity.GoodsCart;
import com.netcai.buyer.entity.GoodsFormat;
import com.netcai.buyer.service.GoodsCartService;
import com.netcai.buyer.vo.GoodsCartVo;
import com.netcai.buyer.vo.ProductVo;

/**
 * @author administrator
 */
@Service
public class GoodsCartServiceImpl implements GoodsCartService {

	@Autowired
	private GoodsCartDao goodsCartDao;
	
	@Autowired
	private GoodsFormatDao goodsFormatDao;
	
	/**
	 *修改  or 删除  单个数据;
	 * @param GoodsCart
	 */
	@Override
	public int updateAndInsertGoodsCart(GoodsCart goodsCart) {
		
		Long formatId = goodsCart.getFormatId();
		Long methodId = goodsCart.getMethodId();
		Long buyerId = goodsCart.getBuyerId();
		
		Long cartId = goodsCartDao.getByFormatIdAndUserId(formatId,methodId, buyerId);
		
		if (cartId == null) {
			//新增;
			return goodsCartDao.insertGoodsCart(goodsCart);
		}
		
		if (null == goodsCart.getGoodsNumber() || BigDecimal.ZERO == goodsCart.getGoodsNumber()) {
			//删除;
			return goodsCartDao.deleteGoodsCart(cartId);
		}
		//修改;
		return goodsCartDao.updateGoodsNumber(goodsCart,cartId);
	}

	/**
	 * 先查再新增
	 * @param GoodsCart
	 */
	@Override
	public Integer insertGoodsCart(GoodsCart goodsCart) {
		 return goodsCartDao.insertGoodsCartSelect(goodsCart);
	}

	/**
	 *   根据Id删除
	 * @param id
	 * @return 
	 */
	@Override
	public int deleteGoodsCart(Long id) {
		
		return goodsCartDao.deleteGoodsCart(id);
	}

	@Override
	public List<GoodsCart> getGoodsCart( Long buyerId) {
		
		return goodsCartDao.getGoodsCartList( buyerId);
	}

	@Override
	public int commitCart(List<GoodsCart> lists,Long userId) {
		
		goodsCartDao.deleteGoodsCartByBuyerId(userId);
		
		if (lists.size()<1) {
			return 0;
		}
		//查询未下架商品;
		List<GoodsFormat> goodsFormats = goodsFormatDao.getByIdAndFormatStatus(lists);
		Map<Long,GoodsFormat> gfMap = new HashMap<Long,GoodsFormat>();
		for (int i = 0; i < goodsFormats.size(); i++) {
			GoodsFormat goodsFormat = goodsFormats.get(i);
			Long formatId = goodsFormat.getFormatId();
			gfMap.put(formatId, goodsFormat);
		}
		//未下架商品新增;
		for (int i = 0; i < lists.size(); i++) {
			GoodsCart goodsCart = lists.get(i);
			Long formatId = goodsCart.getFormatId();
			if(gfMap.containsKey(formatId)){
			goodsCart.setCreateTime(new Date());
			}else {
				lists.remove(i);
			}
		}
		int result = goodsCartDao.insertGoodsCartBatch(lists);
		return result;
	}

	@Override
	public int updateGoodsCart(GoodsCart goodsCart) {
		return goodsCartDao.updateGoodsNumber(goodsCart, goodsCart.getCartId());
	}

	@Override
	public List<GoodsCartVo> getGoodsCartBuyerId(Long buyerId) {
		return goodsCartDao.getGoodsCartListByBuyerId(buyerId);
	}

	@Override
	public List<ProductVo> getGoodsCartListBySellerId(Long buyerId, Long sellerId) {
		return goodsCartDao.getGoodsCartListBySellerId(buyerId, sellerId);
	}

	@Override
	public int commitCartByBuyerIdSellerId(List<GoodsCart> lists,Long buyerId, Long sellerId) {
		
		 goodsCartDao.deleteGoodsCartByBuyerIdSellerId(buyerId, sellerId);
		
		 if (lists.size()<1) {
				return 0;
			}
			//查询未下架商品;
			List<GoodsFormat> goodsFormats = goodsFormatDao.getByIdAndFormatStatus(lists);
			Map<Long,GoodsFormat> gfMap = new HashMap<Long,GoodsFormat>();
			for (int i = 0; i < goodsFormats.size(); i++) {
				GoodsFormat goodsFormat = goodsFormats.get(i);
				Long formatId = goodsFormat.getFormatId();
				gfMap.put(formatId, goodsFormat);
			}
			//未下架商品新增;
			for (int i = 0; i < lists.size(); i++) {
				GoodsCart goodsCart = lists.get(i);
				Long formatId = goodsCart.getFormatId();
				if(gfMap.containsKey(formatId)){
				goodsCart.setCreateTime(new Date());
				}else {
					lists.remove(i);
				}
			}
			int result = goodsCartDao.insertGoodsCartBatch(lists);
			return result;
		
	}
	
}