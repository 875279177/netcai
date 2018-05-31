package com.netcai.admin.dao;

import java.util.List;
import java.util.Map;

import com.netcai.admin.entity.DeliveryRelatedArea;

/**
 * 配送区域关联配送人员Dao
 * @author administrator
 *
 */
public interface DeliveryRelatedAreaDao {
	
	/**
	 * 根据配送区域id查询
	 * @param map
	 * @return
	 */
	public List<DeliveryRelatedArea> getByMap(Map<String, Object> map);
	
	/**
	 * 批量新增数据
	 * @param list
	 * @return
	 */
	public int batchInsert(List<DeliveryRelatedArea> list);
	
	/**
	 * 修改
	 * @param deliveryRelatedArea
	 * @return
	 */
	public int update(DeliveryRelatedArea deliveryRelatedArea);
	
	/**
	 * 根据配送人员id删除
	 * @param deliveryId
	 * @return
	 */
	public int deleteByDeliveryId(Long deliveryId);

}
