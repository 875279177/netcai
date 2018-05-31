package com.netcai.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.MessageDao;
import com.netcai.admin.entity.Message;
import com.netcai.admin.service.MessageService;
import com.netcai.admin.utils.PageUtil;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;
	
	@Override
	public PageUtil getAll(Message message, int currentPageNum, int currentPageSize) {
		
		int size = messageDao.getCountMessage(message);
		
		int offset = 0;	
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<Message> all = messageDao.getAll(message, offset, currentPageSize);
		
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		
		paginator.setObject(all);
		return paginator;
	}

	@Override
	public int update(Message message) {
		return messageDao.update(message);
	}

	@Override
	public int saveBatch(List<Message> messages) {
		return messageDao.saveBatch(messages);
	}
}