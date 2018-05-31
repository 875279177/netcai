package com.netcai.admin.dao;

import java.util.List;

import com.netcai.admin.entity.RefundCause;

/**
 * 退款原因Dao
 * @author administrator
 *
 */
public interface RefundCauseDao {
	
	/**
	 * 查询全部退款原因
	 * @return
	 */
	public List<RefundCause> getAll();
	
	/**
	 * 根据多个id查询退款原因
	 * @param ids
	 * @return
	 */
	public List<RefundCause> getByIds(List<Long> ids);
	

}
