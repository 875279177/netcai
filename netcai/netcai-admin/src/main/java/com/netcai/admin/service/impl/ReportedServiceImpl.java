package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.ReportedDao;
import com.netcai.admin.entity.Reported;
import com.netcai.admin.service.ReportedService;
import com.netcai.admin.utils.PageUtil;

/**
 * 报备表
 */
@Service
public class ReportedServiceImpl implements ReportedService {

	@Autowired
	private ReportedDao reportedDao;
	
	@Override
	public PageUtil getPageResult(Reported reported, int currentPageNum, int currentPageSize) {
		int size = reportedDao.getPageCount(reported);

		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if (size < offset) {
			offset = 0;
		}
		List<Reported> result = reportedDao.getPageList(reported, offset, currentPageSize);

		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);

		paginator.setObject(result);

		return paginator;
	}
	
	@Override
	public int updateReadStatus(Long id, Long rReadStatus) {
		return reportedDao.updateReadStatus(id, rReadStatus);
	}
	
	@Override
	public int updateSolveStatus(Long id, Long rSolveStatus) {
		return reportedDao.updateSolveStatus(id, rSolveStatus);
	}

	@Override
	public List<Reported> getList(Reported reported) {
		return reportedDao.getPageList(reported, null, null);
	}

	@Override
	public int getCount(Reported reported) {
		return reportedDao.getPageCount(reported);
	}
}