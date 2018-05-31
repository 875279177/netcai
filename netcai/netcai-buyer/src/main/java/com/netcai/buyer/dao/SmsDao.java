package com.netcai.buyer.dao;

import com.netcai.buyer.entity.Sms;

public interface SmsDao {
	
	/**
	 * 保存sms对象
	 * @param sms
	 * @return
	 */
	public int saveSms(Sms sms);
}