package com.netcai.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.ProcessMethod;

/**
 * 加工方式Dao
 * @author administrator
 */
public interface ProcessMethodDao {

	/**
	 * 分页查询加工方式
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<ProcessMethod> getAllProcessMethod(@Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * @return total
	 */
	public int getPageCount();

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
	public ProcessMethod getProcessMethodById(@Param("methodId") int methodId);
	
	/**
	 * 取得所有在用的加工方式
	 * @return
	 */
	public List<ProcessMethod> getAllByStatus();
	
	/**
	 * 取得商品分类的加工方式
	 * @return
	 */
	public List<ProcessMethod> getMethodByCategoryId(@Param("categoryId") int categoryId);

}
