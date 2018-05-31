package com.netcai.buyer.entity;

public class OfflinePower {
    private Long id;

    /**
     * 区域Id
     */
    private Integer regionId;
	
    /**
	 * 买家Id
	 */
    private Long buyerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
}