package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.BillItemDao;
import com.netcai.admin.dao.SellerDao;
import com.netcai.admin.entity.BillItem;
import com.netcai.admin.service.BillItemService;
import com.netcai.admin.utils.DateUtil;

/**
 * 账单明细serviceImpl
 * 
 * @author administrator
 *
 */
@Service
public class BillItemServiceImpl implements BillItemService {
	
	private static final Logger logger = LoggerFactory.getLogger(BillItemServiceImpl.class);
	
	@Autowired
	private BillItemDao billItemDao;

	@Autowired
	private SellerDao sellerDao;
	
	@Override
	public List<BillItem> getAllByBillId(Long billId) {
		return billItemDao.getAllByBillId(billId);
	}

	/**
	 * 新增
	 */
	@Override
	public int insert(BillItem billItem) {
		billItem.setCreateTime(new Date());
		return billItemDao.insert(billItem);
	}

	/**
	 * 新增账单对应的账单明细
	 */
	@Override
	public void addBills(Long sellerId, Long billId) {
		logger.info("开始新增账单对应的账单明细");
		try {
			if (sellerId == null) {
				throw new Exception("卖家id为空");
			}
			if (billId == null) {
				throw new Exception("账单id为空");
			}
			// 获取今天的时间
			Map<String, Object> dateMap = DateUtil.getNormalTime(0);
			dateMap.put("sellerId", sellerId);
			// 根据卖家id查询账单明细
			List<Map<String, Object>> sellerList = sellerDao.getAmountDetail(dateMap);
			BigDecimal amount;
			BillItem billItem;
			Date payTime ;
			// 统计账单明细的记录数
			int count = 0;
			for (Map<String, Object> map : sellerList) {
				// 获取今日的总收入
				amount = (BigDecimal) map.get("amount");
				if (amount == null) {
					amount = BigDecimal.ZERO;
				}
				payTime = (Date)map.get("payTime");
				// 新增账单明细
				billItem = new BillItem();
				billItem.setBillId(billId);
				billItem.setSellerId(sellerId);
				billItem.setPeriod(payTime);
				billItem.setMoney(amount);
				insert(billItem);
				count++;
			}
			logger.info("新增卖家账单明细"+count+"条记录,卖家id为："+sellerId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
