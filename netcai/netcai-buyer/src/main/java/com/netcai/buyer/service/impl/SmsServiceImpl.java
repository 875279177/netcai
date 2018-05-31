package com.netcai.buyer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.SmsDao;
import com.netcai.buyer.entity.Sms;
import com.netcai.buyer.service.SmsService;
import com.netcai.buyer.sms.SmsMessage;
import com.netcai.buyer.sms.SmsUtil;

/**
 * 短信相关服务
 * @author administrator
 */
@Service
public class SmsServiceImpl implements SmsService {

	@Autowired
	private SmsDao smsDao;
	
	@Autowired
	private SmsUtil smsUtil;
	
	@Override
	public boolean sendSms(SmsMessage smsMessage) 
	{
		return smsUtil.sendSms(smsMessage);
	}

	@Override
	public int saveSms(Sms sms) 
	{
		return smsDao.saveSms(sms);
	}
}