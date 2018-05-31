package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.SysCommonDao;
import com.netcai.admin.entity.SysCommon;
import com.netcai.admin.service.SysCommonService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.SysCommonVo;

@Service
public class SysCommonServiceImpl implements SysCommonService {

	@Autowired
	private SysCommonDao sysCommonDao;

	@Override
	public PageUtil getSysCommon(SysCommonVo sysCommonVo, Integer currentPageNum, Integer currentPageSize) {
		
		int size = sysCommonDao.getCount(sysCommonVo);
		
		int offset = currentPageNum > 1 ? (currentPageNum - 1) * currentPageSize : 0;
		if (size < offset) {
			offset = 0;
		}
		List<SysCommonVo> result = sysCommonDao.getSysCommon(sysCommonVo, offset, currentPageSize);
		
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);

		paginator.setObject(result);

		return paginator;
	}

	@Override
	public int deleteAllByBuyerIdAndAreaId(Integer buyerType,Long areaId) {
		return sysCommonDao.deleteAllByBuyerIdAndAreaId(buyerType,areaId);
	}

	@Override
	public int batchSave(List<SysCommon> list) {
		return sysCommonDao.batchSave(list);
	}

	@Override
	public List<SysCommonVo> getSysCommon(SysCommonVo sysCommonVo) {
		return  sysCommonDao.getSysCommon(sysCommonVo,null,null);
	}

	@Override
	public int delectById(Long scId) {
		return sysCommonDao.delectById(scId);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return sysCommonDao.deleteBatch(ids);
	}
	
}