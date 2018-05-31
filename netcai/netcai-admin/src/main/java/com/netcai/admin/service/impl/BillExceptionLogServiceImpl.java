package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.BillExceptionLogDao;
import com.netcai.admin.entity.BillExceptionLog;
import com.netcai.admin.service.BillExceptionLogService;

@Service
public class BillExceptionLogServiceImpl implements BillExceptionLogService{
	
	@Autowired
	private BillExceptionLogDao billExceptionLogDao;
	
	/**
	 * 查询全部数据
	 */
	@Override
	public List<BillExceptionLog> getAll() {
		List<BillExceptionLog> list = billExceptionLogDao.getAll();
		if(CollectionUtils.isNotEmpty(list)){
			for(BillExceptionLog log:list){
				if(log==null){
					continue ;
				}
				if(log.getSellerBalance()==null){
					log.setSellerBalance(BigDecimal.ZERO);
				}
				if(log.getAvailableAmount()==null){
					log.setAvailableAmount(BigDecimal.ZERO);
				}
				if(log.getBillAmount()==null){
					log.setBillAmount(BigDecimal.ZERO);
				}
			}
		}
		return list;
	}
	
}
