package com.netcai.buyer.service;

import com.netcai.buyer.entity.Sms;
import com.netcai.buyer.sms.SmsMessage;

public interface SmsService {

	public boolean sendSms(SmsMessage smsMessage);

	public int saveSms(Sms sms);
}