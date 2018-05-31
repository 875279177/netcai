package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Suggestion;

/**
 * 用户建议Dao
 * @author administrator
 *
 */
public interface SuggestionDao {

	/**
	 * 分页查询买家信息
	 * 
	 * @param suggestion
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Suggestion> getAll(@Param("suggestion") Suggestion suggestion, @Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * 
	 * @param suggestion
	 * @return
	 */
	public int getPageCount(@Param("suggestion") Suggestion suggestion);
	
}
