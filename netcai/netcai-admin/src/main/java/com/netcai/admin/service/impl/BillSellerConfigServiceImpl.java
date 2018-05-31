package com.netcai.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.BillPeriod;
import com.netcai.admin.constants.SysStatus;
import com.netcai.admin.dao.BillSellerConfigDao;
import com.netcai.admin.entity.BillSellerConfig;
import com.netcai.admin.service.BillSellerConfigService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BillSellerConfigVo;

@Service
public class BillSellerConfigServiceImpl implements BillSellerConfigService {

	@Autowired
	private BillSellerConfigDao billSellerConfigDao;

	/**
	 * 分页查询数据
	 */
	@Override
	public PageUtil getAll(BillSellerConfigVo billSeller, int pageNum, int pageSize) {
		int size = billSellerConfigDao.getPageCount(billSeller);

		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

		List<BillSellerConfig> result = billSellerConfigDao.getAll(billSeller, offset, pageSize);

		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}

	/**
	 * 根据id查询数据
	 */
	@Override
	public BillSellerConfig getById(Long id) {
		return billSellerConfigDao.getById(id);
	}

	/**
	 * 新增和修改
	 */
	@Override
	public int insertAndUpdate(BillSellerConfigVo billSeller) {
		if (billSeller.getId() != null) {
			return billSellerConfigDao.update(billSeller);
		}
		if (billSeller.getPeriod() == null || billSeller.getPeriod() == 0) {
			// 账单结算周期默认设置为一周
			billSeller.setPeriod(BillPeriod.WEEK);
		}
		billSeller.setStatus(SysStatus.UN_FORBIDDEN);
		billSeller.setCreateTime(new Date());
		return billSellerConfigDao.insert(billSeller);
	}

	/**
	 * 禁用
	 */
	@Override
	public int disabled(Long id) {
		return billSellerConfigDao.disabled(id);
	}

	/**
	 * 启用
	 */
	@Override
	public int enabled(Long id) {
		return billSellerConfigDao.enabled(id);
	}

}
