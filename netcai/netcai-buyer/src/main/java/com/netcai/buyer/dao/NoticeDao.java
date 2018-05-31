package com.netcai.buyer.dao;

import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.Notice;

public interface NoticeDao {

	public Notice getNoticeByBuyerId(Long buyerId);

	public int updateBuyerNotice(Long buyerId);
	
	public int insertNotice(@Param("buyerId") Long buyerId,@Param("content") String content);
}