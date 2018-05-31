package com.netcai.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.GoodsReviseDao;
import com.netcai.admin.service.GoodsReviseService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.GoodsReviseVo;

/**
 * 商品上下架调整ServiceImpl
 * @author administrator
 */
@Service
public class GoodsReviseServiceImpl implements GoodsReviseService {

	@Autowired
	private GoodsReviseDao goodsReviseDao;

	/**
	 * 分页查询
	 */
	@Override
	public PageUtil getAllGoodsRevise(GoodsReviseVo goodsRevise, int pageNum, int pageSize) {
		// 查询总的记录数
		int size = goodsReviseDao.getPageCount(goodsRevise);
		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
		if (size < offset) {
			offset = 0;
		}
		List<GoodsReviseVo> result = goodsReviseDao.getAllGoodsRevise(goodsRevise, offset, pageSize);
		PageUtil paginator = new PageUtil(pageSize, size, pageNum);
		paginator.setObject(result);
		return paginator;
	}
}
