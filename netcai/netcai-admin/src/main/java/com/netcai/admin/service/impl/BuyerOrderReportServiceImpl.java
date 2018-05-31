package com.netcai.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.BuyerOrderReportDao;
import com.netcai.admin.dao.OrderInfoDao;
import com.netcai.admin.entity.BuyerOrderReport;
import com.netcai.admin.service.BuyerOrderReportService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.vo.BuyerOrderReportVo;
import com.netcai.admin.vo.ReportBuyerVo;

/**
 * 统计每天订单报表
 */
@Service
public class BuyerOrderReportServiceImpl implements BuyerOrderReportService {


	@Autowired
	private BuyerOrderReportDao buyerOrderReportDao;
	
	@Autowired
	private OrderInfoDao orderInfoDao;
	/**
	 * 批量新增
	 */
	@Override
	public int insertBatch(Integer today) {
		Map<String, Object> mapOrderTimeT = DateUtil.getTradeTime(today);
		Map<String, Object> mapOrderTimeY = DateUtil.getTradeTime(today+1);
		//统计每当天所有买家订单报表;
		ArrayList<BuyerOrderReport> orderInfoT = orderInfoDao.getByThatDayByBuyer(mapOrderTimeT);
		
		ArrayList<BuyerOrderReport> orderInfoY = orderInfoDao.getByThatDayByBuyer(mapOrderTimeY);
		
		Map<Long,BuyerOrderReport>  map = new HashMap<>();
		Iterator<BuyerOrderReport> iter = orderInfoY.iterator();
		
		while (iter.hasNext()) {
			BuyerOrderReport buyerOrderReport = (BuyerOrderReport) iter.next();
			Long buyerId = buyerOrderReport.getBuyerId();
			map.put(buyerId, buyerOrderReport);
		}
		
		//比较所有买家今天的订单金额是否比昨天少100;
		for (int i = 0; i < orderInfoT.size(); i++) {
			BuyerOrderReport buyerOrderReport = orderInfoT.get(i);
			buyerOrderReport.setToday(new Date());
			Long buyerId = buyerOrderReport.getBuyerId();
			//判断今天下了订单的买家昨天是否也下了单;是则比较;设置Warn
			if(map.containsKey(buyerId)){
				 int intValueT = buyerOrderReport.getOrderMoney().intValue();
				 int intValueY = map.get(buyerId).getOrderMoney().intValue();
				 
				if(intValueY - intValueT >= 100){
					buyerOrderReport.setWarn(0);
				}else {
					buyerOrderReport.setWarn(1);
				}
				//否则不设置设置Warn;
			}else {
				buyerOrderReport.setWarn(1);
			}
		}
		return buyerOrderReportDao.insertBatch(orderInfoT);
	}

	/**
	 * 查询所有;
	 */
	@Override
	public Map<Integer,List<BuyerOrderReportVo>> selectList(BuyerOrderReportVo buyerOrderReport) {
		Map<Integer,List<BuyerOrderReportVo>> map = new HashMap<>();
		
		List<BuyerOrderReportVo> selectList = buyerOrderReportDao.selectList(buyerOrderReport);
		for (int i = 0; i < selectList.size(); i++) {
			BuyerOrderReportVo buyerOrderReportVo = selectList.get(i);
			Integer areaId = buyerOrderReportVo.getAreaId();
			 int today = buyerOrderReportVo.getToday().intValue();
			 int yesterday = buyerOrderReportVo.getYesterday().intValue();
			 int anteayer = buyerOrderReportVo.getAnteayer().intValue();
			if(today == yesterday && yesterday== anteayer && yesterday== 0){
				
			}
			//判断map里是否有这个区域;	有则直接添加进去;
			else if(map.containsKey(areaId)){
				List<BuyerOrderReportVo> list = map.get(areaId);
				list.add(buyerOrderReportVo);
			}else {
				//没有这个区域则添加这个区域;
				List<BuyerOrderReportVo> list = new ArrayList<BuyerOrderReportVo>();
				list.add(buyerOrderReportVo);
				map.put(areaId, list);
			}
		}
		return map;
	}

	/**
	 * 统计买家订单报表;
	 */
	@Override
	public List<ReportBuyerVo> selectListByDateByHz(ReportBuyerVo r) {
		List<ReportBuyerVo> selectListByDateByHz = buyerOrderReportDao.selectListByDateByHz(r);
		
		Iterator<ReportBuyerVo> iterator = selectListByDateByHz.iterator();
		while (iterator.hasNext()) {
			Integer frequency = iterator.next().getFrequency();
			if(frequency == 0){
				iterator.remove();
			}
		}
		
		return selectListByDateByHz;
	}
}