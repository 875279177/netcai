package com.netcai.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.Message;

public interface MessageDao {

	public List<Message> getAllMessage(Long userId);
	
	public Message getMessageById(Long msgId);
	
	public int getCountMessage(Long userId);
	
	public int deleteMessage(Long msgId);

	public int saveBatch(@Param("messages")List<Message> messages);
}