package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.SysCommon;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.SysCommonVo;

public interface SysCommonService {
	
	/**
	 * 根据id查询买家信息
	 */
    public PageUtil getSysCommon(SysCommonVo sysCommonVo, Integer pageNum, Integer pageSize);
    
    /**
	 * 根据id查询买家信息 不分页
	 */
    public List<SysCommonVo> getSysCommon(SysCommonVo sysCommonVo);
    
    /**
     *根据buyerType and areaId删除
     */
    public int deleteAllByBuyerIdAndAreaId(Integer buyerType,Long areaId);
    
    /**
     *批量新增
     */
    public int batchSave(List<SysCommon> list);
    
    /**
     *删除
     */
    public int delectById(Long scId);
    
    /**
     *删除
     */
    public int deleteBatch(List<Long> ids);
}
