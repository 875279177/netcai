package com.netcai.buyer.service;

import com.netcai.buyer.entity.PayLogs;

public interface PayLogsService {
	
	/**
	 * 根据订单号获取订单日志
	 * @param orderNumber
	 * @return
	 */
	public PayLogs getPayLogsByOrderNumber(String orderNumber);
	
	/*增加日志记录*/
	public int addPayLogs(PayLogs payLogs);
	
	/**
	 * 支付宝服务端回调，更新日志记录
	 * @param orderNumber 订单号
	 * @param outerTradeNo 支付宝交易订单号
	 * @param status 支付状态
	 * @return
	 */
	public int updatePayLogs(PayLogs payLogs);
}