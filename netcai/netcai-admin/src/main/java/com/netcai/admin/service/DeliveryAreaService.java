package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.DeliveryRelatedArea;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.DeliveryAreaVo;

public interface DeliveryAreaService {
	
	/**
	 * 分页查询账单信息
	 * 
	 * @param deliveryArea
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAll(DeliveryAreaVo deliveryArea,int pageNum,int pageSize);
	
	/**
	 * 新增和修改
	 * @param deliveryArea
	 * @return
	 */
	public int insertAndUpdate(DeliveryAreaVo deliveryArea);
	
	/**
	 * 根据id查询此配送区域
	 * @param id
	 * @return
	 */
	public DeliveryAreaVo selectById(Long id);
	
	/**
	 * 根据区域id查询配送区域
	 * @param areaId
	 * @return
	 */
	public List<DeliveryAreaVo> selectByAreaId(Long areaId);
	
	/**
	 * 查询全部配送区域
	 * @return
	 */
	public List<DeliveryAreaVo> selectDeliveryAreas();
	
	/**
	 * 配送人员分配多个配送区域
	 * @param deliveryRelatedArea
	 * @param ids
	 * @return
	 */
	public int distributeDelivery(DeliveryRelatedArea deliveryRelatedArea,String ids);
	
	/**
	 * 启用
	 * @param id
	 * @return
	 */
	public int enabled(Long id);
	
	/**
	 * 禁用
	 * @param id
	 * @return
	 */
	public int disabled(Long id);

}
