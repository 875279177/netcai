package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.UserStatus;
import com.netcai.admin.dao.BillDao;
import com.netcai.admin.dao.BillExceptionLogDao;
import com.netcai.admin.dao.SellerDao;
import com.netcai.admin.dao.UsersDao;
import com.netcai.admin.entity.BillExceptionLog;
import com.netcai.admin.entity.Seller;
import com.netcai.admin.entity.Users;
import com.netcai.admin.service.SellerService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BillVo;
import com.netcai.admin.vo.SellerAmountTodayVo;
import com.netcai.admin.vo.SellerVo;

/**
 * @author administrator
 */

@Service
public class SellerServiceImpl implements SellerService {

	private static final Logger logger = LoggerFactory.getLogger(SellerServiceImpl.class);

	@Autowired
	private SellerDao sellerDao;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private BillDao billDao;

	@Autowired
	private BillExceptionLogDao billExceptionLogDao;

	/**
	 * 通过Id查询单个
	 */
	@Override
	public List<Seller> getSellerByKey(Long id) {
		return sellerDao.getSellerByKey(id);
	}

	/**
	 * 添加
	 */
	@Override
	public Integer insertSeller(Seller seller, Users users) {
		int size = 0;
		if (seller != null && users != null) {

			if (usersDao.insertUsers(users) > 0) {

				seller.setSellerId(users.getId());

			}

			size = sellerDao.insertSeller(seller);
		}
		return size;
	}

	/**
	 * 更新
	 */
	@Override
	public Integer updateSeller(Seller seller, Users users) {
		Integer update = 0;
		if (seller != null) {
			if (users != null) {
				usersDao.update(users);
			}
			update = sellerDao.update(seller);
		}
		return update;
	}

	/**
	 * 更新状态;
	 */
	@Override
	public Integer updateStatus(Users users) {
		int updateStatusById = usersDao.updateStatusById(users);
		return updateStatusById;
	}

	/**
	 * 物理删除 根据Id删除
	 */
	@Override
	public int deleteSeller(Long id) {
		return sellerDao.deleteSeller(id);
	}

	/**
	 * 通过条件查询
	 */
	@Override
	public PageUtil getPageResult(Seller seller, int currentPageNum, int currentPageSize) {

		int size = sellerDao.getPageCount(seller);

		int offset = currentPageNum > 1 ? (currentPageNum - 1) * currentPageSize : 0;
		if (size < offset) {
			offset = 0;
		}

		List<Seller> result = sellerDao.getSeller(seller, offset, currentPageSize);

		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);

		paginator.setObject(result);

		return paginator;
	}

	/**
	 * 通过条件查询
	 */
	@Override
	public List<Seller> getResult(Seller seller, int currentPageNum, int currentPageSize) {
		return sellerDao.getSeller(seller, currentPageNum, currentPageSize);
	}

	/**
	 * 查询可用的商家 (促销活动选择商家时使用)
	 */
	@Override
	public List<SellerVo> searchSeller(SellerVo sellerVo) {
		return sellerDao.searchSeller(sellerVo);
	}

	/**
	 * 统计卖家数量
	 */
	@Override
	public int getDailySellerCount() {
		// 获取当天的开始时间和结束时间
		Map<String, Object> map = DateUtil.getNormalTime(0);
		return usersDao.getSellerCount(map);
	}

	/**
	 * 查询当日入驻的卖家
	 */
	@Override
	public List<Seller> getSellerByDate() {
		Map<String, Object> map = DateUtil.getNormalTime(0);
		List<Seller> sellerList = sellerDao.getSellerByDate(map);
		if (CollectionUtils.isEmpty(sellerList)) {
			sellerList = new ArrayList<Seller>();
		} else {
			for (Seller seller : sellerList) {
				if (seller.getBalanceMoney() == null) {
					seller.setBalanceMoney(BigDecimal.ZERO);
				}
				if (seller.getBillMoney() == null) {
					seller.setBillMoney(BigDecimal.ZERO);
				}
			}
		}
		return sellerList;
	}

	@Override
	public Integer getByAccount(String account) {
		return sellerDao.getByAccount(account);
	}

	/**
	 * 查询所有卖家信息
	 * 
	 * @return
	 */
	@Override
	public List<Seller> getSellers(int status) {
		return sellerDao.getSellers(status);
	}

	@Override
	public List<Seller> getSellerByBuyerId(Long buyerId,Integer sellerType) {
		return sellerDao.getSellerByBuyerId(buyerId,sellerType);
	}

	/**
	 * 根据账单更新卖家余额
	 * 
	 * @return
	 */
	@Override
	public int updateBalanceByBill() {
		logger.info("开始更新卖家余额");
		// 统计更新的卖家数量
		int count = 0;
		// 查询所有的卖家
		List<Seller> sellerList = this.getSellers(UserStatus.All);
		// 获取昨天的时间
		Map<String, Object> map = DateUtil.getNormalTime(1);
		// 查询昨天的所有订单
		List<BillVo> bills = billDao.getBillsBySellerId(map);
		// 账单和卖家数据判空
		if (CollectionUtils.isEmpty(bills) || CollectionUtils.isEmpty(sellerList)) {
			return count;
		}
		for (Seller seller : sellerList) 
		{
			for (BillVo bill : bills) 
			{
				// 根据sellerId来匹配卖家相应的账单
				if (seller.getSellerId().longValue() == bill.getSellerId().longValue()) {
					// 获取卖家账单的预收款
					BigDecimal realIncome = bill.getRealIncome();
					// 若卖家账单预收款为空则直接跳过
					if (realIncome == null) {
						break;
					}
					// 获取卖家当前的余额
					BigDecimal balanceMoney = seller.getBalanceMoney();
					if (balanceMoney == null) {
						balanceMoney = BigDecimal.ZERO;
					}
					// 更新买家余额
					BigDecimal totalIncome = balanceMoney.add(realIncome);
					sellerDao.updateBalanceMoney(seller.getSellerId(), totalIncome);
					logger.info("更新卖家余额，卖家id为：" + seller.getSellerId());
					count++;
				}
			}

		}
		logger.info("更新了" + count + "个卖家的余额");
		return count;
	}

	/**
	 * 根据卖家id查询卖家信息
	 */
	@Override
	public BigDecimal getById(Long sellerId) {
		return sellerDao.getById(sellerId);
	}

	/**
	 * 根据卖家id更新余额
	 */
	@Override
	public Integer updateBalanceMoney(Long sellerId, BigDecimal balanceMoney) {
		return sellerDao.updateBalanceMoney(sellerId, balanceMoney);
	}

	/**
	 * 核对卖家余额
	 */
	@Override
	public void verifySellerBalance() {
		logger.info("开始核对卖家余额");
		// 查询所有订单
		List<Map<String, Object>> list = billDao.getRealIncome();
		// 账单和卖家数据判空
		if (CollectionUtils.isEmpty(list)) {
			return;
		}
		Long sellerId;
		// 卖家余额
		BigDecimal balanceMoney;
		// 卖家可用余额
		BigDecimal billMoney;
		// 账单金额
		BigDecimal realIncome;
		String sellerName;
		List<BillExceptionLog> billExceptionLog_list = new ArrayList<BillExceptionLog>();
		BillExceptionLog billExceptionLog;
		Iterator<Map<String, Object>> iterator = list.iterator();
		while (iterator.hasNext()) {
			Map<String, Object> map = iterator.next();
			if (map.isEmpty()) {
				continue;
			}
			sellerId = (Long) map.get("sellerId");
			balanceMoney = (BigDecimal) map.get("balanceMoney");
			billMoney = (BigDecimal) map.get("billMoney");
			realIncome = (BigDecimal) map.get("realIncome");
			sellerName = (String) map.get("sellerName");
			if (sellerId == null || balanceMoney == null) {
				continue;
			}
			if (billMoney == null) {
				billMoney = BigDecimal.ZERO;
			}
			if (realIncome == null) {
				realIncome = BigDecimal.ZERO;
			}
			realIncome = billMoney.add(realIncome);
			if (realIncome.compareTo(balanceMoney) != 0) {
				billExceptionLog = new BillExceptionLog();
				billExceptionLog.setSellerId(sellerId);
				billExceptionLog.setSellerName(sellerName);
				billExceptionLog.setSellerBalance(balanceMoney);
				billExceptionLog.setAvailableAmount(billMoney);
				billExceptionLog.setBillAmount(realIncome);
				billExceptionLog.setCreateTime(new Date());
				// 将数据保存到集合中
				billExceptionLog_list.add(billExceptionLog);
			}
		}
		if (CollectionUtils.isNotEmpty(billExceptionLog_list)) {
			billExceptionLogDao.batchInsert(billExceptionLog_list);
		}
		logger.info("核对卖家余额完成，有" + billExceptionLog_list.size() + "卖家余额异常");
	}

	/**
	 * 根据区id查询区域下所有的卖家
	 */
	@Override
	public List<SellerVo> getSellerByRegionId(Long regionId) {
		return sellerDao.getSellerByRegionId(regionId);
	}

	/**
	 * 分页查询卖家今日收益、今日订单数量、可用余额、可提现金额
	 */
	@Override
	public PageUtil getSellerAmountByToday(SellerAmountTodayVo seller, int pageNum, int pageSize) {
		// 查询总的记录数
		int size = sellerDao.getSellerAmountCount(seller);
		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
		PageUtil page = new PageUtil(pageSize, size, pageNum);
		List<SellerAmountTodayVo> list = sellerDao.getSellerAmountByToday(seller, offset, pageSize);
		page.setObject(list);
		return page;
	}
}