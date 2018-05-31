package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.entity.Message;

/**
 * 消息服务
 * @author administrator
 *
 */
public interface MessageService {

	public List<Message> getAllMessage(Long userId);
	
	public int deleteMessage(Long msgId);
	
	public Message getMessageById(Long msgId);
	
	public int getCountMessage(Long userId);
	
}
