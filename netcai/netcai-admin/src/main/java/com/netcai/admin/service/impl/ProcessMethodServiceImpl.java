package com.netcai.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.ProcessMethodDao;
import com.netcai.admin.entity.ProcessMethod;
import com.netcai.admin.service.ProcessMethodService;
import com.netcai.admin.utils.PageUtil;

/**
 * 加工方式serviceimpl
 * @author administrator
 */
@Service
public class ProcessMethodServiceImpl implements ProcessMethodService{
	
	@Autowired
	private ProcessMethodDao methodDao;
	
	/**
	 * 分页查询加工方式
	 * @param currentPageNum
	 * @param currentPageSize
	 * @return
	 */
	public List<ProcessMethod> getAllProcessMethod(int currentPageNum,int currentPageSize){
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		return methodDao.getAllProcessMethod(offset, currentPageSize);
	}

	/**
	 * 查询总记录数
	 * @return PageUtil
	 */
	public PageUtil getPageResult(int currentPageNum,int currentPageSize){
		int size = methodDao.getPageCount();
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<ProcessMethod> result = methodDao.getAllProcessMethod(offset, currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}

	/**
	 * 添加加工方式
	 */
	@Override
	public int insertProcessMethod(ProcessMethod entity) {
		return methodDao.insertProcessMethod(entity);
	}

	/**
	 * 更新加工方式
	 */
	@Override
	public int updateProcessMethod(ProcessMethod entity) {
		return methodDao.updateProcessMethod(entity);
	}
	
	/**
	 * 根据id查找加工方式
	 */
	@Override
	public ProcessMethod getProcessMethodById(int methodId){
		return methodDao.getProcessMethodById(methodId);
	}

	/**
	 * 取得所有在用的加工方式
	 * @return
	 */
	@Override
	public List<ProcessMethod> getAllByStatus(){
		return methodDao.getAllByStatus();
	}
	
	/**
	 * 取得商品分类的加工方式
	 * @return
	 */
	@Override
	public List<ProcessMethod> getMethodByCategoryId(int categoryId){
		return methodDao.getMethodByCategoryId(categoryId);
	}
}
