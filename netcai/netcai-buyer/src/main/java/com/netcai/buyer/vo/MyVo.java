package com.netcai.buyer.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class MyVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int countMessage;

	private BigDecimal balanceMoney;

	public int getCountMessage() {
		return countMessage;
	}

	public void setCountMessage(int countMessage) {
		this.countMessage = countMessage;
	}

	public BigDecimal getBalanceMoney() {
		return balanceMoney;
	}

	public void setBalanceMoney(BigDecimal balanceMoney) {
		this.balanceMoney = balanceMoney;
	}
}