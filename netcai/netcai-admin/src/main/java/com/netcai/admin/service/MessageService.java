package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.Message;
import com.netcai.admin.utils.PageUtil;

public interface MessageService {

	public PageUtil getAll(Message message, int currentPageNum, int currentPageSize);
	
	public int update(Message message);
	
	public int saveBatch(List<Message> messages);
}
