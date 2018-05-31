package com.netcai.admin.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.SalesDao;
import com.netcai.admin.entity.Sales;
import com.netcai.admin.service.SalesService;
import com.netcai.admin.utils.ArrayListUtil;
import com.netcai.admin.utils.EncryptUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.SalesPerf;

/**
 * 销售人员信息service实现
 * @author mengj
 *
 */
@Service
public class SalesServiceImpl implements SalesService {
	
	@Autowired
	private SalesDao salesDao;
	
	/**
	 * 分页查询销售人员信息
	 * 
	 * @param sales
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageUtil getAllSales(Sales sales, int currentPageNum, int currentPageSize) {
		int size = salesDao.getPageCount(sales);
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<Sales> result = salesDao.getAllSales(sales,offset, currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}
	
	/**
	 * 根据id查询销售人员信息
	 * @return
	 */
	@Override
	public Sales getSalesById(Long id) {
		return salesDao.getSalesById(id);
	}
	
	/**
	 * 根据手机号查询
	 */
	@Override
	public Sales getSalesByPhone(String phone) {
		return salesDao.getSalesByPhone(phone);
	}
	
	/**
     * 新增和更新
     * @param sales
     * @return
     */
	@Override
	public int insertAndUpdate(Sales sales) {
		//id不为空时更新数据
		if(sales.getId()!=null){
			if(StringUtils.isNotBlank(sales.getPassword())){
				sales.setPassword(EncryptUtil.getMD5(sales.getPassword()));
			}
			sales.setLastUpdateTime(new Date());
			return salesDao.updateSales(sales);
		}
		if(sales.getPassword()==null){
			sales.setPassword("123456");
		}
		sales.setPassword(EncryptUtil.getMD5(sales.getPassword()));
		//默认设置状态为在职
		sales.setStatus(1);
		sales.setCreateTime(new Date());
		return salesDao.insertSales(sales);
	}
	
	/**
	 *查询所有的销售人员信息
	 * @return
	 */
	@Override
	public List<Sales> getListSales(Integer status,Integer level) 
	{
		return salesDao.getListSales(status,level);
	}
	
	/**
     * 统计销售业绩前十的销售人员
     * @return
     */
	@Override
	public List<Map<String, Object>> getTopTenSales() {
		List<Map<String, Object>> list = salesDao.getTopTenSales();
		return ArrayListUtil.getArrayListByArray(list, ArrayListUtil.TOPTEN_SALES);
	}
	
	/**
	 * 禁用
	 */
	@Override
	public int disabled(Long id) {
		return salesDao.disabled(id);
	}
	
	/**
	 * 启用
	 */
	@Override
	public int enabled(Long id) {
		return salesDao.enabled(id);
	}

	@Override
	public PageUtil getSalesPerf(SalesPerf salesPerf, Integer pageNum, Integer pageSize) {
		int size = salesDao.getSalesPerfCount(salesPerf);

		int offset = 0;
		if (pageNum > 1) {
			offset = (pageNum - 1) * pageSize;
		}
		if (size < offset) {
			offset = 0;
		}

		List<SalesPerf> result = salesDao.getSalesPerfList(salesPerf, offset, pageSize);

		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}

	@Override
	public List<SalesPerf> getSalesPerf(SalesPerf salesPerf) {
		return salesDao.getSalesPerfList(salesPerf, null, null);
	}

}