package com.netcai.admin.service;

import com.netcai.admin.entity.BillSellerConfig;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BillSellerConfigVo;

/**
 * 卖家帐单周期配置Service
 * @author administrator
 *
 */
public interface BillSellerConfigService {
	
	    /**
		 * 分页查询账单配置
		 * 
		 * @param billSeller
		 * @param offset
		 * @param pageSize
		 * @return
		 */
		public PageUtil getAll(BillSellerConfigVo billSeller, int offset,int pageSize);
		
		/**
		 * 根据登录名称查询用户
		 * @param id
		 * @return
		 */
		public BillSellerConfig getById(Long id);
		
		/**
		 * 新增和修改
		 * @param billSeller
		 * @return
		 */
		public int insertAndUpdate(BillSellerConfigVo billSeller);
		
		/**
		 * 禁用
		 * @param id
		 * @return
		 */
		public int disabled(Long id);
		
		/**
		 * 启用
		 * @param id
		 * @return
		 */
		public int enabled(Long id);

}
