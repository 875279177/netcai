package com.netcai.admin.service;

import java.util.List;
import java.util.Map;

import com.netcai.admin.entity.Delivery;
import com.netcai.admin.entity.DeliveryRelatedArea;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.DeliveryCoordinateVo;

/**
 * 配送人员基本信息service
 * 
 * @author mengjie
 */
public interface DeliveryService {

	/**
	 * 根据map查询配送人员基本信息
	 * 
	 * @param map
	 * @return
	 */
	public Delivery getDelivery(Map<String, Object> map);

	/**
	 * 查询总记录数
	 * 
	 * @param delivery
	 * @return
	 */
	public PageUtil getPageResult(Delivery delivery, int currentPageNum, int currentPageSize);
	
	/**
	 * 查询配送人员信息
	 * @return
	 */
	public List<Delivery> getDeliverys();
	
	/**
	 * 查看配送人员负责的配送区域
	 * @param deliveryId
	 * @return
	 */
	public List<DeliveryRelatedArea> getDeliveryAreaById(Long deliveryId);

	/**
	 * 禁用
	 * @param id
	 */
	public int disabled(Long id);
	
	/**
	 * 禁用
	 * @param id
	 */
	public int enabled(Long id);

	/**
	 * 新增配送人员信息
	 * 
	 * @param delivery
	 * @return
	 */
	public int insertDelivery(Delivery delivery);
	
	/**
	 * 查询ById
	 */
	public Delivery getById(Long deliveryId);
	
	/**
	 * 获取配送人员坐标
	 */
	public List<DeliveryCoordinateVo> getDeliveryCoordinate(Long deliveryId);
}
