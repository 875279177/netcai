package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.ProblemDao;
import com.netcai.admin.entity.Problem;
import com.netcai.admin.service.ProblemService;
import com.netcai.admin.utils.PageUtil;

/**
 */
@Service
public class ProblemServiceImpl implements ProblemService{

	@Autowired
	private ProblemDao problemDao;

	@Override
	public PageUtil getPageResult(Problem problem, Integer pageNum, Integer pageSize) {
		int size = problemDao.getPageCount(problem);
		int offset = 0;
		if (pageNum > 1) {
			offset = (pageNum - 1) * pageSize;
		}
		if (size < offset) {
			offset = 0;
		}
		List<Problem> result = problemDao.selectList(problem, pageNum, pageSize);
		PageUtil paginator = new PageUtil(pageSize, size, pageNum);
		paginator.setObject(result);
		return paginator;
	}

	@Override
	public int deleteById(Long id) {
		return problemDao.deleteById(id);
	}

	@Override
	public int insert(Problem record) {
		return problemDao.insert(record);
	}

	@Override
	public Problem selectById(Long id) {
		return problemDao.selectById(id);
	}

	@Override
	public int update(Problem problem) {
		return problemDao.update(problem);
	}
	
}
