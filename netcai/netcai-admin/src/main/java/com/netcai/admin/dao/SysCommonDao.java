package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.SysCommon;
import com.netcai.admin.vo.SysCommonVo;

/**
 *
 */
public interface SysCommonDao {
	
	/**
	 *获取数量;
	 */
	public int getCount(@Param("s")SysCommonVo s);
	
	/**
	 * 查询信息
	 */
    public List<SysCommonVo> getSysCommon(@Param("s")SysCommonVo s,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
    
    
    /**
     *根据buyerTypeId and areaId删除
     */
    public int deleteAllByBuyerIdAndAreaId(@Param("buyerTypeId")Integer buyerTypeId,@Param("areaId") Long areaId);
    
    /**
     *批量新增
     */
    public int batchSave(@Param("list")List<SysCommon> list);
    
    /**
     *删除By ID
     */
    public int delectById(@Param("scId")Long scId);
    
    /**
     *批量删除
     */
    public int deleteBatch(@Param("ids")List<Long> ids);
}
