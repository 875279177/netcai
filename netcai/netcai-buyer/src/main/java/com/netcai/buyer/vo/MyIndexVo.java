package com.netcai.buyer.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class MyIndexVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 未支付
	 */
	private int noPayNum;
	/**
	 * 待收货
	 */
	private int waitTakeNum;
	/**
	 * 已完成
	 */
	private int finishNum;
	/**
	 * 消息数
	 */
	private int msgNum;
	/**
	 * 红包数
	 */
	private int redPacketNum;
	/**
	 * 优惠券
	 */
	private int couponReceiveNum;
	/**
	 * 余额
	 */
	private BigDecimal balanceMoney;

	public int getNoPayNum() {
		return noPayNum;
	}

	public void setNoPayNum(int noPayNum) {
		this.noPayNum = noPayNum;
	}

	public int getWaitTakeNum() {
		return waitTakeNum;
	}

	public void setWaitTakeNum(int waitTakeNum) {
		this.waitTakeNum = waitTakeNum;
	}

	public int getFinishNum() {
		return finishNum;
	}

	public void setFinishNum(int finishNum) {
		this.finishNum = finishNum;
	}

	public int getMsgNum() {
		return msgNum;
	}

	public void setMsgNum(int msgNum) {
		this.msgNum = msgNum;
	}

	public int getRedPacketNum() {
		return redPacketNum;
	}

	public void setRedPacketNum(int redPacketNum) {
		this.redPacketNum = redPacketNum;
	}

	public BigDecimal getBalanceMoney() {
		return balanceMoney;
	}

	public void setBalanceMoney(BigDecimal balanceMoney) {
		this.balanceMoney = balanceMoney;
	}

	public int getCouponReceiveNum() {
		return couponReceiveNum;
	}

	public void setCouponReceiveNum(int couponReceiveNum) {
		this.couponReceiveNum = couponReceiveNum;
	}
}