package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.vo.DeliveryAreaVo;

/**
 * 配送区域Dao
 * @author administrator
 *
 */
public interface DeliveryAreaDao {
	
	/**
	 * 分页查询配送区域信息
	 * 
	 * @param deliveryArea
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<DeliveryAreaVo> getAll(@Param("deliveryArea") DeliveryAreaVo deliveryArea, @Param("offset") int offset,
			@Param("pageSize") int pageSize);
	

	/**
	 * 查询总记录数
	 * @param deliveryArea
	 * @return
	 */
	public int getPageCount(@Param("deliveryArea") DeliveryAreaVo deliveryArea);
	
	/**
	 * 新增
	 * @param deliveryArea
	 * @return
	 */
	public int insert(DeliveryAreaVo deliveryArea);
	
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
	 * 修改
	 * @param deliveryArea
	 * @return
	 */
	public int update(DeliveryAreaVo deliveryArea);
	
	/**
	 * 修改状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateStatus(@Param("id") Long id,@Param("status") Integer status);

}
