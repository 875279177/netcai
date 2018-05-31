package com.netcai.admin.constants;
/**
 * 客户级别枚举
 * @author administrator
 *
 */
public enum BuyerLevelEnum {
	LevelA(1,"A类客户"),
	LevelB(2,"B类客户"),
	LevelC(3,"C类客户");
		
	public int code;
	public String name;
	
	BuyerLevelEnum(int code,String name){
		this.code=code;
		this.name=name;
	}

	public static String getName(int code){
		for(BuyerLevelEnum e: BuyerLevelEnum.values()){
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
