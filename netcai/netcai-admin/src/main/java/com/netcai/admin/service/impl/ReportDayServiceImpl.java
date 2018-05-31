package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.BuyerDao;
import com.netcai.admin.dao.OrderInfoDao;
import com.netcai.admin.dao.OrderItemDao;
import com.netcai.admin.dao.ReportDayDao;
import com.netcai.admin.entity.ReportDay;
import com.netcai.admin.service.ReportDayService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.CategoryItemVo;
import com.netcai.admin.vo.OrderCategoryItemVo;
import com.netcai.admin.vo.OrderCategoryListVo;
import com.netcai.admin.vo.OrderCategoryVo;
import com.netcai.admin.vo.ReportDayVo;
import com.netcai.admin.vo.SearchVo;

/**
 * 统计每天订单报表
 */
@Service
public class ReportDayServiceImpl implements ReportDayService {

	@Autowired
	private ReportDayDao reportDayDao;
	
	@Autowired
	private OrderInfoDao orderInfoDao;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Autowired
	private BuyerDao buyerDao;
	/**
	 * 批量新增
	 */
	@Override
	public int insertBatch(Integer today) {
		Map<String, Object> mapOrderTime = DateUtil.getTradeTime(today);
		//regionId	buyerNum	购买商家总数
		ArrayList<ReportDay> buyerNum = orderInfoDao.getBuyerNumByThatDayByArea(mapOrderTime);
		//regionId	orderAmount 	订单总金额
		ArrayList<ReportDay> orderAmounts = orderInfoDao.getOrderAmountByThatDayByArea(mapOrderTime);
		//regionId	orderNum 	订单数(卖家-买家)
		ArrayList<ReportDay> orderNumAndArea = orderItemDao.getCountByAreaByTime(mapOrderTime);
		//regionId	newBuyer	新注册买家
		ArrayList<ReportDay> newBuyerAndArea = buyerDao.getCountByThatDay(today+1);
		//regionId	newBuyerNum	昨天注册，今天下单的买家数量
		ArrayList<ReportDay> newBuyerNumAndArea = orderInfoDao.getCountByThatDayByArea(mapOrderTime);
		
		
		Map<Long,ReportDay> map = new HashMap<>();
		Iterator<ReportDay> iter  = buyerNum.iterator();
		
		while (iter.hasNext()) {
			ReportDay reportDay = (ReportDay) iter.next();
			reportDay.setToday(new Date());
			map.put(reportDay.getRegionId(), reportDay);
		}
		//组装orderAmount;
		for (int i = 0; i < orderAmounts.size(); i++) {
			ReportDay reportDay = orderAmounts.get(i);
			BigDecimal orderAmount = reportDay.getOrderAmount();
			if(orderAmount == null){
				orderAmount = BigDecimal.ZERO;
			}
			Long regionId = reportDay.getRegionId();
			map.get(regionId).setOrderAmount(orderAmount);
		}
		//组装orderNum;
		for (int i = 0; i < orderNumAndArea.size(); i++) {
			ReportDay reportDay = orderNumAndArea.get(i);
			Integer orderNum = reportDay.getOrderNum();
			if(orderNum == null){
				orderNum = 0;
			}
			Long regionId = reportDay.getRegionId();
			map.get(regionId).setOrderNum(orderNum);
		}
		//组装newBuyer;
		for (int i = 0; i < newBuyerAndArea.size(); i++) {
			ReportDay reportDay = newBuyerAndArea.get(i);
			Integer newBuyer = reportDay.getNewBuyer();
			if(newBuyer == null){
				newBuyer = 0;
			}
			Long regionId = reportDay.getRegionId();
			map.get(regionId).setNewBuyer(newBuyer);
		}
		//组装newBuyerNum;
		for (int i = 0; i < newBuyerNumAndArea.size(); i++) {
			ReportDay reportDay = newBuyerNumAndArea.get(i);
			Integer newBuyerNum = reportDay.getNewBuyerNum();
			if(newBuyerNum == null){
				newBuyerNum = 0;
			}
			Long regionId = reportDay.getRegionId();
			map.get(regionId).setNewBuyerNum(newBuyerNum);
		}
		
		ArrayList<ReportDay> arrayList = new ArrayList<ReportDay>(map.values());
		return reportDayDao.insertBatch(arrayList);
	}

	/**
	 * 查询所有;分区域;
	 */
	@Override
	public Map<Integer, List<ReportDayVo>> selectList(ReportDayVo reportDay) {
		Map<Integer,List<ReportDayVo>> map = new HashMap<>();
		
		List<ReportDayVo> selectList = reportDayDao.selectList(reportDay);
		for (int i = 0; i < selectList.size(); i++) {
			ReportDayVo reportDayVo = selectList.get(i);
				Integer areaId = reportDayVo.getAreaId();
				//判断map里是否有这个区域;	有则直接添加进去;
				if(map.containsKey(areaId) ){
					List<ReportDayVo> list = map.get(areaId);
					list.add(reportDayVo);
				}else {
					//没有这个区域则添加这个区域;
					List<ReportDayVo> list = new ArrayList<ReportDayVo>();
					list.add(reportDayVo);
					map.put(areaId, list);
				}
			
		}
		return map;
	}

	@Override
	public ReportDayVo getByDate(int date) {
		return reportDayDao.getByDate(date);
	}
	
	public PageUtil getPageResult(int currentPageNum,int currentPageSize){
		int size = reportDayDao.getOrderByCategoryCount();
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<OrderCategoryListVo> list = reportDayDao.getOrderByCategory(offset, currentPageSize);
		List<OrderCategoryVo> ocList = new ArrayList<OrderCategoryVo>();

		for (int i = 0; i < list.size(); i++) {
			OrderCategoryListVo ocl = list.get(i);
			OrderCategoryVo ocv = new OrderCategoryVo();
			ocv.setBuyerId(ocl.getBuyerId());
			ocv.setBuyerName(ocl.getBuyerName());
			ocv.setSendDate(ocl.getSendDate());
			BigDecimal totalAmt = BigDecimal.ZERO;
			List<OrderCategoryItemVo> ociList = ocl.getClist();
	        Map<String,BigDecimal> one_amt = new HashMap<String,BigDecimal>();
	        Map<String,BigDecimal> two_amt = new HashMap<String,BigDecimal>();
			for (int j = 0; j < ociList.size(); j++) {
				OrderCategoryItemVo oci = ociList.get(j);
				String oneId = oci.getOneCategoryId().toString();
				String twoId = oci.getTwoCategoryId().toString();
				totalAmt = oci.getGoodsAmount().add(totalAmt);
				
				BigDecimal one_totalAmt = one_amt.get(oneId) == null ? BigDecimal.ZERO :one_amt.get(oneId);
				BigDecimal two_totalAmt = two_amt.get(twoId) == null ? BigDecimal.ZERO :two_amt.get(twoId);
				if("2".equals(oneId)){
					if(two_amt.containsKey(twoId)){
						two_totalAmt = oci.getGoodsAmount().add(two_totalAmt);
					}else{
						two_totalAmt = oci.getGoodsAmount();
					}
					two_amt.put(twoId, two_totalAmt);
				}else{
					if(one_amt.containsKey(oneId)){
						one_totalAmt = oci.getGoodsAmount().add(one_totalAmt);
					}else{
						one_totalAmt = oci.getGoodsAmount();
					}
					one_amt.put(oneId, one_totalAmt);
				}
			}
			if(one_amt.get("1")!=null){
				ocv.setItemAmount1(one_amt.get("1"));
			} 
			if(one_amt.get("3")!=null){
				ocv.setItemAmount4(one_amt.get("3"));
			} 
			if(one_amt.get("4")!=null){
				ocv.setItemAmount5(one_amt.get("4"));
			} 
			if(one_amt.get("5")!=null){
				ocv.setItemAmount6(one_amt.get("5"));
			} 
			if(one_amt.get("6")!=null){
				ocv.setItemAmount7(one_amt.get("6"));
			} 
			if(one_amt.get("7")!=null){
				ocv.setItemAmount8(one_amt.get("7"));
			} 
			if(one_amt.get("8")!=null){
				ocv.setItemAmount9(one_amt.get("8"));
			} 
			if(two_amt.get("19")!=null){
            	ocv.setItemAmount3(two_amt.get("19"));
			} 
			if(two_amt.get("16")!=null){
				ocv.setItemAmount2(two_amt.get("16"));
			}
			if(two_amt.get("17")!=null){
				ocv.setItemAmount2(two_amt.get("17"));
			}
			if(two_amt.get("16")!=null && two_amt.get("17")!=null){
				ocv.setItemAmount2(two_amt.get("16").add(two_amt.get("17")));
			}
			ocv.setTotalAmount(totalAmt);
			ocList.add(ocv);
		}
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(ocList);
		return paginator;
	}
	
	public List<CategoryItemVo> getOrderItemByCategory(SearchVo search){
		return reportDayDao.getOrderItemByCategory(search);
	}
	
	public List<CategoryItemVo> getOrderBuyerByCategory(SearchVo search){
		return reportDayDao.getOrderBuyerByCategory(search);
	}
	
	public List<CategoryItemVo> getOrderBuyerByDate(SearchVo search){
		return reportDayDao.getOrderBuyerByDate(search);
	}
}