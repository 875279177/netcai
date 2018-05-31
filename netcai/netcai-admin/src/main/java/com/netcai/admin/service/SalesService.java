package com.netcai.admin.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Sales;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.SalesPerf;

/**
 * 销售人员信息service
 * @author mengj
 *
 */
public interface SalesService {
	
	/**
	 * 分页查询销售人员信息
	 * 
	 * @param sales
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAllSales(@Param("sales") Sales sales, @Param("offset") int offset,
			@Param("pageSize") int pageSize);
	
	
	/**
	 * 查询所有的列表
	 * @return
	 */
    public List<Sales> getListSales(Integer status,Integer level);
	
	/**
	 * 根据id查询销售人员信息
	 * @param id
	 * @return
	 */
    public Sales getSalesById(Long id);
    
    /**
     * 根据手机号查询销售人员信息
     * @param phone
     * @return
     */
    public Sales getSalesByPhone(String phone);
    
    /**
     * 新增和更新
     * @param sales
     * @return
     */
    public int insertAndUpdate(Sales sales);
    
    /**
   	 * 禁用
   	 * @param id
   	 */
   	public int disabled(Long id);
   	
   	/**
   	 * 禁用
   	 * @param id
   	 */
   	public int enabled(Long id);
    
    /**
     * 统计销售业绩前十的销售人员
     * @return
     */
    public List<Map<String, Object>> getTopTenSales();
    /**
	 * 分页查询销售绩效
	 */
	public PageUtil getSalesPerf(SalesPerf salesPerf,Integer pageNum,Integer pageSize);
	
	/**
	 * 分页查询销售绩效
	 */
	public List<SalesPerf> getSalesPerf(SalesPerf salesPerf);
	
}
