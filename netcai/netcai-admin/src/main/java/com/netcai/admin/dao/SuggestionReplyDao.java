package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.SuggestionReply;

/**
 *用户对平台的建议回复
 */
public interface SuggestionReplyDao {

	/**
	 * 查询信息
	 */
	public List<SuggestionReply> getList(@Param("suggestionId") Long suggestionId);
	
	/**
	 * 添加
	 */
	public int insert(@Param("s") SuggestionReply s);
}
