package com.netcai.buyer.service;

import com.netcai.buyer.entity.Notice;

public interface NoticeService {
	
	public Notice getNoticeByBuyerId(Long buyerId);
	
	public int updateBuyerNotice(Long buyerId);
	
	public int insertNotice(Long buyerId,String content);
}