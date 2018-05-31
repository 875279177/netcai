package com.netcai.buyer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.NoticeDao;
import com.netcai.buyer.entity.Notice;
import com.netcai.buyer.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public Notice getNoticeByBuyerId(Long buyerId) {
		return noticeDao.getNoticeByBuyerId(buyerId);
	}

	@Override
	public int updateBuyerNotice(Long buyerId) 
	{
		return noticeDao.updateBuyerNotice(buyerId);
	}

	@Override
	public int insertNotice(Long buyerId,String content) {
		return noticeDao.insertNotice(buyerId,content);
	}
}