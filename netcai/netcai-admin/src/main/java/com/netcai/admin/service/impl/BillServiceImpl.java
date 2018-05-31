package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.BillStatus;
import com.netcai.admin.dao.BillDao;
import com.netcai.admin.dao.SellerDao;
import com.netcai.admin.dao.SellerOrderDeliveryDao;
import com.netcai.admin.entity.Bill;
import com.netcai.admin.service.BillService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BillVo;

/**
 * 账单service实现类
 * 
 * @author administrator
 */
@Service
public class BillServiceImpl implements BillService {

	private static final Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);

	@Autowired
	private SellerDao sellerDao;

	@Autowired
	private BillDao billDao;

	@Autowired
	private SellerOrderDeliveryDao sellerOrderDeliveryDao;

	/**
	 * 分页查询账单
	 */
	@Override
	public PageUtil getAll(BillVo bill, int pageNum, int pageSize) {
		int size = billDao.getPageCount(bill);

		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
		Date start = null;
		Date end = null;
		// 比较开始时间和结束时间
		if (StringUtils.isNotBlank(bill.getStartTimeStr()) && StringUtils.isNotBlank(bill.getEndTimeStr())) {
			start = DateUtil.stringToDate(bill.getStartTimeStr(), DateUtil.FMT_DATETIME);
			end = DateUtil.stringToDate(bill.getEndTimeStr(), DateUtil.FMT_DATETIME);
			int num = DateUtil.compareDate(end, start);
			// 结束时间比开始时间早，则结束时间设置为开始时间
			if (num < 0) {
				bill.setEndTimeStr(bill.getStartTimeStr());
			}
		}
		List<Bill> result = billDao.getAll(bill, offset, pageSize);

		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}

	/**
	 * 根据卖家id查询账单
	 */
	@Override
	public List<BillVo> getBillsBySellerId(Map<String, Object> map) {
		return billDao.getBillsBySellerId(map);
	}

	/**
	 * 生成卖家账单
	 */
	@Override
	public void addBills() {
		logger.info("统计卖家今日的总收入，并新增卖家账单记录");
		// 获取今天的时间
		Map<String, Object> dateMap = DateUtil.getTradeTime(0);
		// 查询今天每个卖家的总收入
		List<Map<String, Object>> sellerList = sellerDao.getAmountByDate(dateMap);
		if (CollectionUtils.isEmpty(sellerList)) {
			logger.info("卖家今日的总收入为：0");
			return;
		}

		List<Bill> bills = new ArrayList<Bill>();
		try {
			for (Map<String, Object> sellerMap : sellerList) {
				// 获取卖家id
				Long sellerId = (Long) sellerMap.get("sellerId");
				if (sellerId == null) {
					continue;
				}
				// 获取今日的总收入
				BigDecimal amount = (BigDecimal) sellerMap.get("amount");
				if (amount == null) {
					amount = BigDecimal.ZERO;
				}
				BigDecimal realIncome = amount;

				// 根据卖家id查询今日总配送费
				BigDecimal deliveryAmount = sellerOrderDeliveryDao.getDeliveryAmountBySellerId(sellerId);
				if (deliveryAmount != null && deliveryAmount.compareTo(BigDecimal.ZERO) == 1) {
					realIncome = realIncome.add(deliveryAmount);
				}
				Bill bill = new Bill();
				Date now = new Date();
				bill.setSellerId(sellerId);
				bill.setCreateTime(now);
				bill.setPeriod(now);
				bill.setRealIncome(realIncome);
				bill.setExpectIncome(amount);
				// 设置状态为待结算
				bill.setStatus(BillStatus.PENDING_SETTLED);
				// 将数据添加到集合中
				bills.add(bill);
				logger.info("新增卖家账单,卖家id为：" + sellerId);
			}
			// 新增账单
			billDao.batchInsert(bills);
		} catch (Exception ex) {
			logger.error("[BillServiceImpl][addBillsAndBillItems] exception:", ex);
		}
	}

	@Override
	public void correctAmount() {
		List<Map<String, Object>> resultMap = billDao.correctSellerAmount();
		if (CollectionUtils.isNotEmpty(resultMap)) {

			for (Map<String, Object> map : resultMap) {
				try {
					Long sellerId = Long.valueOf(String.valueOf(map.get("sellerId")));
					BigDecimal balanceMoney = new BigDecimal(String.valueOf(map.get("rmb")));

					// 更新最新的余额
					sellerDao.updateBalanceMoney(sellerId, balanceMoney);
				} catch (Exception ex) {
					logger.error("[BillServiceImpl][correctAmount] exception:", ex);
				}
			}
		}
	}

	/**
	 * 根据卖家抽点金额更新账单实际金额
	 */
	@Override
	public int updateRealAmountByPercentage() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		Long billId;
		BigDecimal realIncome;
		BigDecimal percentageAmount;
		// 获取当天每个卖家的账单实际金额和抽点金额
		List<Map<String, Object>> amount_list = billDao.getRealMoneyAndPercentageAmount(new Date());
		if (CollectionUtils.isEmpty(amount_list)) {
			return 0;
		}
		for (Map<String, Object> amount_map : amount_list) {
			if (MapUtils.isEmpty(amount_map)) {
				continue;
			}
			billId = (Long) amount_map.get("billId");
			if (billId == null) {
				continue;
			}
			realIncome = (BigDecimal) amount_map.get("realIncome");
			if (realIncome == null || realIncome == BigDecimal.ZERO) {
				continue;
			}
			percentageAmount = (BigDecimal) amount_map.get("percentageAmount");
			if (percentageAmount == null || percentageAmount == BigDecimal.ZERO) {
				continue;
			}
			// 如果抽点金额大于或者等于实际金额则跳过
			if (percentageAmount.compareTo(realIncome) != -1) {
				continue;
			}
			realIncome = realIncome.subtract(percentageAmount);
			map = new HashMap<String, Object>();
			// 将计算之后的实际金额添加到map中
			map.put("id", billId);
			map.put("realIncome", realIncome);
			list.add(map);
		}
		if (CollectionUtils.isEmpty(list)) {
			return 0;
		}
		// 更新卖家账单实际金额
		return billDao.batchUpdateRealitymoney(list);

	}
}