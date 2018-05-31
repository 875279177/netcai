package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.ProcessMethod;
import com.netcai.admin.utils.PageUtil;

/**
 * 加工方式service
 * @author administrator
 */
public interface ProcessMethodService {
	
	/**
	 * 分页查询加工方式
	 * @param currentPageNum
	 * @param currentPageSize
	 * @return
	 */
	public List<ProcessMethod> getAllProcessMethod(int currentPageNum,int currentPageSize);

	/**
	 * 查询总记录数
	 * @return PageUtil
	 */
	public PageUtil getPageResult(int currentPageNum,int currentPageSize);

	/**
	 * 添加加工方式
	 */
	public int insertProcessMethod(ProcessMethod entity);

	/**
	 * 更新加工方式
	 */
	public int updateProcessMethod(ProcessMethod entity);
	
	/**
	 * 根据id查找加工方式
	 */
	public ProcessMethod getProcessMethodById(int methodId);
	
	/**
	 * 取得所有在用的加工方式
	 * @return
	 */
	public List<ProcessMethod> getAllByStatus();
	
	/**
	 * 取得商品分类的加工方式
	 * @return
	 */
	public List<ProcessMethod> getMethodByCategoryId(int categoryId);
}
