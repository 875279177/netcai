package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.BuyerExpenseDao;
import com.netcai.admin.entity.BuyerExpense;
import com.netcai.admin.service.BuyerExpenseService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerExpenseVo;

/**
 * 买家消费信息ServiceImpl
 * 
 * @author administrator
 *
 */
@Service
public class BuyerExpenseServiceImpl implements BuyerExpenseService {

	@Autowired
	private BuyerExpenseDao buyerExpenseDao;

	/**
	 * 根据map查询买家消费信息
	 */
	public PageUtil getAll(BuyerExpenseVo buyerExpenseVo, int pageNum, int pageSize) {
		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
		//查询所有有订单的买家信息 
		List<BuyerExpense> buyers = buyerExpenseDao.getAllBuyers(buyerExpenseVo.getBuyerPhone(),offset,pageSize);
		//查询总记录数
		int size = buyerExpenseDao.getPageCount(buyerExpenseVo.getBuyerPhone());
		if (CollectionUtils.isEmpty(buyers)) {
			return null;
		}
		// 获取买家近三天的消费信息
		List<BuyerExpenseVo> buyerExpenseVos = getBuyersExpense(buyers);
		PageUtil paginator = new PageUtil(pageSize, size, pageNum);
		paginator.setObject(buyerExpenseVos);
		return paginator;
	}

	/**
	 * 根据map查询买家消费信息
	 */
	@Override
	public List<BuyerExpenseVo> getBuyersExpense(List<BuyerExpense> buyers) {
		// 获取当天的时间
		Map<String, Object> today = DateUtil.getNormalTime(0);
		// 获取昨天的时间
		Map<String, Object> yesterday = DateUtil.getNormalTime(1);
		// 获取前天的时间
		Map<String, Object> before = DateUtil.getNormalTime(2);
		
		// 查询当天的买家消费信息
		List<BuyerExpense> todayExpense_list = buyerExpenseDao.getBuyerExpenses(today);
		// 查询昨天的买家消费信息
		List<BuyerExpense> yesterdayExpense_list = buyerExpenseDao.getBuyerExpenses(yesterday);
		// 查询前天的买家消费信息
		List<BuyerExpense> beforeExpense_list = buyerExpenseDao.getBuyerExpenses(before);
		List<BuyerExpenseVo> result = new ArrayList<BuyerExpenseVo>();
		BuyerExpenseVo buyerExpenseVo = null;
		// 遍历前天的买家消费信息
		for (BuyerExpense buyer : buyers) {
			if (buyer == null) {
				continue;
			}
			if (buyer.getBuyerId() == null) {
				continue;
			}
			buyerExpenseVo = new BuyerExpenseVo();
			buyerExpenseVo.setBuyerId(buyer.getBuyerId());
			buyerExpenseVo.setBuyerName(buyer.getBuyerName());
			buyerExpenseVo.setBuyerPhone(buyer.getBuyerPhone());
			// 遍历前天的买家消费信息
			for (BuyerExpense beforeExpense : beforeExpense_list) {
				if (beforeExpense == null) {
					continue;
				}
				if (buyer.getBuyerId() != null
						&& buyer.getBuyerId().longValue() == beforeExpense.getBuyerId().longValue()) {
					// 添加前天的消费金额
					buyerExpenseVo.setForeExpense(
							beforeExpense.getExpense() == null ? BigDecimal.ZERO : beforeExpense.getExpense());
				}
			}
			// 遍历昨天的买家消费信息
			for (BuyerExpense yesterdayExpense : yesterdayExpense_list) {
				if (yesterdayExpense == null) {
					continue;
				}
				// 根据买家id匹配的消费金额存入昨日消费金额
				if (yesterdayExpense.getBuyerId() != null
						&& yesterdayExpense.getBuyerId().longValue() == buyer.getBuyerId().longValue()) {
					buyerExpenseVo.setYesterdayExpense(
							yesterdayExpense.getExpense() == null ? BigDecimal.ZERO : yesterdayExpense.getExpense());
				}
			}
			// 遍历当天的买家消费信息
			for (BuyerExpense todayExpense : todayExpense_list) {
				if (todayExpense == null) {
					continue;
				}
				// 根据买家id匹配的消费金额存入3天前的消费金额
				if (todayExpense.getBuyerId() != null
						&& buyer.getBuyerId().longValue() == todayExpense.getBuyerId().longValue()) {
					buyerExpenseVo.setTotayExpense(
							todayExpense.getExpense() == null ? BigDecimal.ZERO : todayExpense.getExpense());
				}
			}
			
			// 判断所有的消费金额是否为null
			if (buyerExpenseVo.getTotayExpense() == null) {
				buyerExpenseVo.setTotayExpense(BigDecimal.ZERO);
			}
			if (buyerExpenseVo.getYesterdayExpense() == null) {
				buyerExpenseVo.setYesterdayExpense(BigDecimal.ZERO);
			}
			if (buyerExpenseVo.getForeExpense() == null) {
				buyerExpenseVo.setForeExpense(BigDecimal.ZERO);
			}
			// 将数据结果返回
			result.add(buyerExpenseVo);
		}

		return result;
	}

}
