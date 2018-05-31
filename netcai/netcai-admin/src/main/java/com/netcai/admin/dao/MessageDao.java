package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Message;

public interface MessageDao {

	public List<Message> getAllMessage(Long userId);
	
	public int deleteMessage(Long msgId);
	
	public Message getMessageById(Long msgId);
	
	public int getCountMessage(@Param("message")Message message);
	
	public Integer saveBatch(@Param("messages")List<Message> messages);
	
	public List<Message> getAll(@Param("message")Message message,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	
	public int update(@Param("message")Message message);
}