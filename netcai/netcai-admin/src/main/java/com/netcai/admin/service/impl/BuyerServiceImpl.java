package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.ChartTitleEnum;
import com.netcai.admin.constants.SysStatus;
import com.netcai.admin.constants.UserStatus;
import com.netcai.admin.dao.AreaDao;
import com.netcai.admin.dao.BuyerDao;
import com.netcai.admin.dao.UsersDao;
import com.netcai.admin.entity.Area;
import com.netcai.admin.entity.Buyer;
import com.netcai.admin.entity.Users;
import com.netcai.admin.service.BuyerService;
import com.netcai.admin.utils.ArrayListUtil;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.EncryptUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerVo;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private BuyerDao buyerDao;

	@Autowired
	private UsersDao usersDao;
	
	@Autowired 
	private AreaDao areaDao;

	/**
	 * 分页查询买家信息
	 */
	@Override
	public PageUtil getAllBuyer(BuyerVo buyer, int pageNum, int pageSize) {

		int size = buyerDao.getPageCount(buyer);

		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

		List<BuyerVo> result = buyerDao.getAllBuyer(buyer, offset, pageSize);

		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}
	
	/**
	 * 查询所有买家信息
	 */
	@Override
	public List<BuyerVo> getAll(BuyerVo buyer) {
		return buyerDao.getAll(buyer);
	}

	/**
	 * 根据id查询买家信息
	 */
	@Override
	public BuyerVo getBuyerById(Long id) {
		return buyerDao.getBuyerById(id);
	}

	/**
	 * 新增和更新数据
	 */
	@Override
	public int insertAndUpdate(Buyer buyer) {
		// 默认密码
		String password = "123456";

		// id不为空时更新数据
		if (buyer.getBuyerId() != null) {
			//修改用户密码
			if(StringUtils.isNotBlank(buyer.getPassword())){
				Users users= new Users();
				users.setId(buyer.getBuyerId());
				users.setPassword(EncryptUtil.getMD5(buyer.getPassword()));
				usersDao.update(users);
			}
			return buyerDao.updateBuyer(buyer);
		}
		
		// 先添加数据到user表中
		Users user =null;
		user = usersDao.getUsersByAccount(buyer.getBossTel());
		if(user!=null){
			return 0;
		}
		user = new Users();
		user.setTrueName(buyer.getBossName());
		user.setAccount(buyer.getBossTel());
		if (StringUtils.isNotBlank(buyer.getPassword())) {
			// 当密码为空时设置默认密码
			password = buyer.getPassword();
		}
		user.setPassword(EncryptUtil.getMD5(password));
		// 默认设置用户为可用
		user.setStatus(SysStatus.UN_FORBIDDEN);
		// 用户类型设置为买家
		user.setType(1);
		user.setCreateTime(new Date());
		usersDao.insertUsers(user);

		buyer.setBuyerId(user.getId());
		return buyerDao.insertBuyer(buyer);
	}

	/**
	 * 启用买家
	 */
	@Override
	public int enabledBuyer(Long id) {
		Users users = usersDao.getUsersById(id);
		// 状态为不可用的用户才可以启用
		if (users != null && users.getStatus() == UserStatus.FORBIDDEN) {
			// 设置状态为可用
			users.setStatus(UserStatus.AUDITED);
			return usersDao.updateStatusById(users);
		}
		return 0;
	}

	/**
	 * 禁用买家
	 */
	@Override
	public int disabledBuyer(Long id) {
		Users users = usersDao.getUsersById(id);
		// 状态为可用的用户才可以被禁用
		if (users != null && users.getStatus() == UserStatus.AUDITED) {
			// 设置状态为禁用
			users.setStatus(UserStatus.FORBIDDEN);
			return usersDao.updateStatusById(users);
		}
		return 0;
	}

	/**
	 * 根据区域统计买家数量
	 */
	@Override
	public int getBuyerCount(Long regionId) {
		Map<String, Object> map = null;
		if(regionId!=null){
			map = new HashMap<String, Object>();
			map.put("regionId", regionId);
		}
		return usersDao.getBuyerCount(map);
	}

	/**
	 * 统计买家数量
	 * 
	 * @return
	 */
	@Override
	public int getDailyBuyerCount() {
		// 获取当天的开始时间和结束时间
		Map<String, Object> map = DateUtil.getNormalTime(0);
		return usersDao.getBuyerCount(map);
	}

	/**
	 * 审核通过
	 */
	@Override
	public int auditThrough(Long id) {
		Users users = usersDao.getUsersById(id);
		// 用户状态为未审核
		if (users != null && users.getStatus() == UserStatus.INCOMPLETE) {
			// 设置状态为审核通过
			users.setStatus(UserStatus.AUDITED);
			return usersDao.updateStatusById(users);
		}
		return 0;
	}

	/**
	 * 审核不通过
	 */
	@Override
	public int auditNotThrough(Long id) {
		Users users = usersDao.getUsersById(id);
		// 用户状态为未审核
		if (users != null && users.getStatus() == UserStatus.INCOMPLETE) {
			// 设置状态为审核未通过
			users.setStatus(UserStatus.AUDITFAILED);
			return usersDao.updateStatusById(users);
		}
		return 0;
	}

	/**
	 * 查询今日入驻买家
	 */
	@Override
	public List<BuyerVo> getBuyerByDate(Buyer buyer) {
		Map<String, Object> map = DateUtil.getNormalTime(0);
		List<BuyerVo> buyerList = buyerDao.getBuyerByDate(map,buyer);
		if (CollectionUtils.isEmpty(buyerList)) {
			buyerList = new ArrayList<BuyerVo>();
		} else {
			for (BuyerVo buyerVo : buyerList) {
				if (buyerVo.getBalanceMoney() == null) {
					buyerVo.setBalanceMoney(BigDecimal.ZERO);
				}
			}
		}
		return buyerList;
	}
	
	/**
	 * 查询昨天入驻买家
	 */
	@Override
	public List<BuyerVo> getBuyerByDateYesterday(Buyer buyer) {
		Map<String, Object> map = DateUtil.getNormalTime(1);
		List<BuyerVo> buyerList = buyerDao.getBuyerByDate(map,buyer);
		if (CollectionUtils.isEmpty(buyerList)) {
			buyerList = new ArrayList<BuyerVo>();
		} else {
			for (BuyerVo buyerVo : buyerList) {
				if (buyerVo.getBalanceMoney() == null) {
					buyerVo.setBalanceMoney(BigDecimal.ZERO);
				}
			}
		}
		return buyerList;
	}

	/**
	 * 根据时间类型（按天或者按月）统计一个周期内的的注册买家数量
	 */
	@Override
	public Map<String, List<Integer>> getBuyerCountByTimeType(Integer timeType) {
		if (timeType == null) {
			// 默认是时间类型是按天查询
			timeType = DateUtil.DATE_TYPE_DAY;
		}
		Map<String, List<Integer>> result = new LinkedHashMap<String, List<Integer>>();
		Map<String, Object> map = null;
		List<Integer> totalCount = new ArrayList<Integer>();
		for (int i = DateUtil.WEEKCOUNT - 1; i >= 0; i--) {
			// 获取n天前的订单查询时间
			if (DateUtil.DATE_TYPE_DAY == timeType) {
				map = DateUtil.getNormalTime(i);
			} else if (DateUtil.DATE_TYPE_MONTH == timeType) {
				map = DateUtil.getMonthTime(i,DateUtil.TRADE_TIME_TYPE);
			}
			//根据时间查询全部区域的订单数量
			int orderNum = usersDao.getBuyerCount(map);
			// 将订单数量结果添加到集合
			totalCount.add(orderNum);
		}
		result.put(ChartTitleEnum.BuyerTotalCount.getName(), totalCount);
		// 查询所有区域
		List<Area> areas = areaDao.getRegions();
		if (CollectionUtils.isEmpty(areas)) {
			return result;
		}
		for (Area area : areas) {
			if (area == null || area.getId() == null) {
				continue;
			}
			Long regionId = area.getId();
			String regionName = area.getAreaName();
			List<Integer> counts = new ArrayList<Integer>();
			for (int i = DateUtil.WEEKCOUNT - 1; i >= 0; i--) {
				// 获取n天前的订单查询时间
				if (DateUtil.DATE_TYPE_DAY == timeType) {
					map = DateUtil.getNormalTime(i);
				} else if (DateUtil.DATE_TYPE_MONTH == timeType) {
					map = DateUtil.getMonthTime(i,DateUtil.NORMAL_TIME_TYPE);
				}
				map.put("regionId", regionId);
				int buyerCount = usersDao.getBuyerCount(map);
				// 将订单数量结果添加到集合
				counts.add(buyerCount);
			}
			if (StringUtils.isNotBlank(regionName)) {
				regionName += ChartTitleEnum.BuyerCount.getName();
			}
			result.put(regionName, counts);
		}
		
		return result;
	}

	/**
	 * 查询订单项最多的前十位买家
	 */
	@Override
	public List<Map<String, Object>> getTopTenWidelyBuyer() {
		List<Map<String, Object>> list = buyerDao.getTopTenWidelyBuyer();
		return ArrayListUtil.getArrayListByArray(list, ArrayListUtil.TOPTEN_WIDELYBUYER);
	}

	@Override
	public List<BuyerVo> getBuyerBySalesIdAndTime(Buyer buyer) {
		return buyerDao.getBuyerBySalesIdAndTime(buyer);
	}
	
    /**
     * 更新买家类别 注册时间超过7天并下单
     */
    public int updateBuyerLevel(Integer buyerLevel){
    	return buyerDao.updateBuyerLevel(buyerLevel);
    }
    
    /**
     * 更新买家类别为4 注册时间超过7天并未下单
     */
    public int updateBuyerLevel0(){
    	return buyerDao.updateBuyerLevel0();
    }

}