package com.netcai.buyer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.MessageDao;
import com.netcai.buyer.entity.Message;
import com.netcai.buyer.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageDao messageDao;

	@Override
	public List<Message> getAllMessage(Long userId) {
		return messageDao.getAllMessage(userId);
	}

	@Override
	public int deleteMessage(Long msgId) {
		return messageDao.deleteMessage(msgId);
	}

	@Override
	public Message getMessageById(Long msgId) {
		return messageDao.getMessageById(msgId);
	}

	@Override
	public int getCountMessage(Long userId)
	{
		return messageDao.getCountMessage(userId);
	}
}