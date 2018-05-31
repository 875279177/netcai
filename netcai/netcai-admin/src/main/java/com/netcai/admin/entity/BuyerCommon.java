package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 常用清单;
 */
public class BuyerCommon implements Serializable{
	
    /**
	 */
	private static final long serialVersionUID = -5894610129367005370L;

	private Long bcId;

	/**
	 * 买家ID
	 */
    private Long buyerId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 批量修改商品Id
     */
    private List<GoodId> goodIds;

	public Long getBcId() {
		return bcId;
	}

	public void setBcId(Long bcId) {
		this.bcId = bcId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public static  class GoodId {

		/**
		 * 现商品Id
		 */
		public Long goodsId;

		/**
		 * 原商品Id
		 */
		public Long goodsIdOld;
	    
	    /**
		 * 现商品Id
		 */
		public String goodsName;

		/**
		 * 原商品Id
		 */
		public String goodsNameOld;

		public Long getGoodsId() {
			return goodsId;
		}

		public void setGoodsId(Long goodsId) {
			this.goodsId = goodsId;
		}

		public Long getGoodsIdOld() {
			return goodsIdOld;
		}

		public void setGoodsIdOld(Long goodsIdOld) {
			this.goodsIdOld = goodsIdOld;
		}

		public GoodId(Long goodsId, Long goodsIdOld, String goodsName, String goodsNameOld) {
			this.goodsId = goodsId;
			this.goodsIdOld = goodsIdOld;
			this.goodsName = goodsName;
			this.goodsNameOld = goodsNameOld;
		}

		public String getGoodsName() {
			return goodsName;
		}

		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}

		public String getGoodsNameOld() {
			return goodsNameOld;
		}

		public void setGoodsNameOld(String goodsNameOld) {
			this.goodsNameOld = goodsNameOld;
		}

		public GoodId() {
		}
	}

	public  List<GoodId> getGoodIds() {
		return goodIds;
	}

	public  void setGoodIds(List<GoodId> goodIds) {
		this.goodIds = goodIds;
	}

	public BuyerCommon(Long bcId, Long buyerId, Long goodsId, Date createTime, List<GoodId> goodIds) {
		this.bcId = bcId;
		this.buyerId = buyerId;
		this.goodsId = goodsId;
		this.createTime = createTime;
		this.goodIds = goodIds;
	}

	public BuyerCommon() {
	}
	
	
}