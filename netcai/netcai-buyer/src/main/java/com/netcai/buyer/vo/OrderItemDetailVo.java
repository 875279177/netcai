package com.netcai.buyer.vo;

import java.util.List;

/**
 * 根据订单查看具体的订单详细情况
 * @author administrator
 */
public class OrderItemDetailVo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private OrderInfoVo orderInfoVo;
	
	/**
	 * 店铺名称
	 */
	private String sellerName;
	
	public List<ProductVo> productVos;

	public OrderInfoVo getOrderInfoVo() {
		return orderInfoVo;
	}

	public void setOrderInfoVo(OrderInfoVo orderInfoVo) {
		this.orderInfoVo = orderInfoVo;
	}

	public List<ProductVo> getProductVos() {
		return productVos;
	}

	public void setProductVos(List<ProductVo> productVos) {
		this.productVos = productVos;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	
}