package com.netcai.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.OrderReturnCauseDao;
import com.netcai.admin.entity.OrderReturnCause;
import com.netcai.admin.service.OrderReturnCauseService;

/**
 * @author administrator
 */

@Service
public class OrderReturnCauseServiceImpl implements OrderReturnCauseService {

	@Autowired
	private OrderReturnCauseDao orderReturnCauseDao;

	/**
	 * 通过Id查询单个
	 */
	@Override
	public OrderReturnCause getOrderReturnCauseById(Long id) {
		return orderReturnCauseDao.getOrderReturnCauseById(id);
	}

	

	/**
	 * 添加
	 */
	@Override
	public Integer insertOrderReturnCause(OrderReturnCause OrderReturnCause) {
		int size =0;
		if (OrderReturnCause != null) {
			OrderReturnCause.setCreateTime(new Date());
			size = orderReturnCauseDao.insertOrderReturnCause(OrderReturnCause);
		}
		return size;
	}


	/**
	 * 逻辑删除   根据Id删除
	 */
	@Override
	public int deleteOrderReturnCause(Long id) {
		
		return orderReturnCauseDao.updateStatus(id);
		
	}

	/**
	 * 通过条件查询 
	 */
	@Override
	public List<OrderReturnCause> getPageResult(OrderReturnCause OrderReturnCause) {
		List<OrderReturnCause> result = orderReturnCauseDao.getOrderReturnCause(OrderReturnCause);
		return result;
	}



	@Override
	public List<OrderReturnCause>  getOrderReturnCauseByParentId(Long id) {
		return orderReturnCauseDao.getOrderReturnCauseByParentId(id);
	}



	@Override
	public int updateById(OrderReturnCause OrderReturnCause) {
		return orderReturnCauseDao.updateById(OrderReturnCause);
	}


	/**
	 * 查询所有
	 */
	@Override
	public List<OrderReturnCause> getAll() {
		List<OrderReturnCause> all = orderReturnCauseDao.getAll();
		return all;
	}
}