package com.netcai.admin.constants;

/**
 * 首页表格统计图标题
 * @author Administrator
 *
 */
public enum ChartTitleEnum {
	
	OrderCount(1,"订单数量"),
	OrderAmount(2,"营业额"),
	PercentageAmount(3,"抽成金额"),
	BuyerCount(4,"买家数量"),
	OrderTotalCount(5,"总计订单数量"),
	OrderTotalAmount(6,"总计营业额"),
	PercentageTotalAmount(7,"总计抽成金额"),
	BuyerTotalCount(8,"总计买家数量");
	
	private int code;
	private String name;
	
	ChartTitleEnum(int code,String name){
		this.code=code;
		this.name=name;
	}
	
	public static String getNameByCode(int code){
		for(ChartTitleEnum e:ChartTitleEnum.values()){
			if(e.getCode()==code){
				return e.name;
			}
		}
		return "";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
