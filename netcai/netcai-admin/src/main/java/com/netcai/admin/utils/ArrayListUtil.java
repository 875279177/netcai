package com.netcai.admin.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

/**
 * 集合数据转换
 * 
 * @author Administrator
 *
 */
public class ArrayListUtil {
	
	//一周内消费前十的买家返回数据数组
	public static final String[] TOPTEN_AMOUNT = { "buyerName", "typeName", "amount", "count" };
	//一周内订单项的前十位买家返回字段数组
	public static final String[] TOPTEN_WIDELYBUYER = { "buyerName", "typeName", "orderNum", "count" };
	//一周内收入前十的卖家返回字段数组
	public static final String[] TONTEN_INCOMES = { "sellerName", "amount", "count", "grade" };
	//一周内销售量前十的商品返回字段数组
	public static final String[] TOPTEN_GOODS = { "goodsName", "formatName", "num", "amount" };
	//一周内销售业绩前十的销售人员返回字段数组
	public static final String[] TOPTEN_SALES = { "name", "phone", "count"};
	
	public static final String COUNT = "count";
	
	public static final String AMOUNT = "amount";
	
	public static final String TIME = "createTime";
	
	/**
	 * 将数据按照自定义排序存取
	 * @param list
	 * @param arr
	 * @return
	 */
	public static List<Map<String, Object>> getArrayListByArray(List<Map<String, Object>> list,String[] arr) {
		List<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
		if (CollectionUtils.isEmpty(list)) {
			return arrayList;
		}
		Iterator<Map<String, Object>> iterator = list.iterator();
		while (iterator.hasNext()) {
			Map<String, Object> map = iterator.next();
			// map为空时就删除
			if (MapUtils.isEmpty(map)) {
				iterator.remove();
				continue;
			} 
			Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
			for (int i = 0; i < arr.length; i++) {
				if (map.containsKey(AMOUNT) && map.get(AMOUNT) == null) {
					map.put(AMOUNT, BigDecimal.ZERO);
				}
				if (map.containsKey(TIME)) {
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date =(Date)map.get(TIME);
					String time = sdf.format(date);
					dataMap.put(TIME, time);
				}
				if (map.containsKey(arr[i])) {
					dataMap.put(arr[i], map.get(arr[i]));
				}
			}
			arrayList.add(dataMap);
		}
		return arrayList;
	}
	
}
