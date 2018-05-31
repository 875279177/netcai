package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.GoodsCartDao;
import com.netcai.admin.entity.GoodsCart;
import com.netcai.admin.service.GoodsCartService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.GoodsCartVo;

/**
 * @author administrator
 */
@Service
public class GoodsCartServiceImpl implements GoodsCartService {

	@Autowired
	private GoodsCartDao goodsCartDao;
	



	/**
	 * 修改review_status
	 * @param GoodsCart
	 */
	@Override
	public int updateGoodsNumber(GoodsCart GoodsCart) {
		return goodsCartDao.updateGoodsNumber(GoodsCart);
	}

	/**
	 * 添加
	 * @param GoodsCart
	 */
	@Override
	public Integer insertGoodsCart(GoodsCart goodsCart) {
		 return goodsCartDao.insertGoodsCart(goodsCart);
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
	public PageUtil getPageResultList(GoodsCart goodsCart, int currentPageNum, int currentPageSize) {
		
		int size = goodsCartDao.getPageCountList(goodsCart);

		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		
		List<GoodsCartVo> result = goodsCartDao.getGoodsCartList(goodsCart, offset, currentPageSize);
		
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		
		paginator.setObject(result);
		
		return paginator;
	}


	
}