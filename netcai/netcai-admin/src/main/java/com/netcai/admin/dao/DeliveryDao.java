package com.netcai.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Delivery;
import com.netcai.admin.vo.DeliveryCoordinateVo;

/**
 * 配送人员基本信息DAO
 * 
 * @author mengjie
 */
public interface DeliveryDao {

	/**
	 * 根据map查询单条配送人员基本信息
	 * @param map
	 * @return
	 */
	public Delivery getDelivery(Map<String, Object> map);

	/**
	 * 分页查询配送人员信息
	 * 
	 * @param delivery
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Delivery> getAll(@Param("delivery") Delivery delivery, @Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * 
	 * @param delivery
	 * @return
	 */
	public int getPageCount(@Param("delivery") Delivery delivery);
	
	/**
	 * 查询配送人员信息
	 * @return
	 */
	public List<Delivery> getDeliverys();
	
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
	 * @param delivery
	 * @return
	 */
	public int insertDelivery(Delivery delivery);
	
	/**
	 * 修改配送人员信息
	 * @param delivery
	 * @return
	 */
	public int updateDelivery(Delivery delivery);
	
	/**
	 * 查询ById
	 */
	public Delivery getById(Long deliveryId);
	
	/**
	 * 获取配送人员坐标
	 */
	public List<DeliveryCoordinateVo> getDeliveryCoordinate(@Param("deliveryId") Long deliveryId);

}