package com.netcai.admin.constants;
/**
 * 餐馆的类型枚举
 * @author administrator
 *
 */
public enum BuyerTypeEnum {
	Hotpot(1,"火锅店"),
	Chophouse(2,"小餐馆"),
	Restaurants(3,"中餐馆"),
	Barbecue(4,"烧烤店");
	
	public int code;
	public String name;
	
	BuyerTypeEnum(int code,String name){
		this.code=code;
		this.name=name;
	}

	public static String getName(int code){
		for(BuyerTypeEnum e: BuyerTypeEnum.values()){
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

	public void setName(String value) {
		this.name = value;
	}
	
	
}
