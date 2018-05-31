package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.BillSellerConfig;
import com.netcai.admin.vo.BillSellerConfigVo;

/**
 * 卖家帐单周期配置Dao
 * @author administrator
 *
 */
public interface BillSellerConfigDao {
	
	/**
	 * 分页查询账单配置
	 * 
	 * @param billSeller
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<BillSellerConfig> getAll(@Param("billSeller") BillSellerConfigVo billSeller, @Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getPageCount(@Param("billSeller") BillSellerConfigVo billSeller);

	/**
	 * 根据登录名称查询用户
	 * @param id
	 * @return
	 */
	public BillSellerConfig getById(Long id);
	
	/**
	 * 新增
	 * @param billSeller
	 * @return
	 */
	public int insert(BillSellerConfigVo billSeller);
	
	/**
	 * 更新
	 * @param billSeller
	 * @return
	 */
	public int update(BillSellerConfigVo billSeller);
	
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
