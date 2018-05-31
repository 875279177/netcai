package com.netcai.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Sales;
import com.netcai.admin.vo.SalesPerf;

/**
 * 销售人员信息Dao
 * @author mengj
 *
 */
public interface SalesDao {
	
	/**
	 * 分页查询销售人员信息
	 * 
	 * @param sales
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Sales> getAllSales(@Param("sales") Sales sales, @Param("offset") int offset,
			@Param("pageSize") int pageSize);
	
	/**
	 * 查询总记录数
	 * 
	 * @param sales
	 * @return
	 */
	public int getPageCount(@Param("sales") Sales sales);
	
	/**
	 * 查询所有的销售人员信息
	 * @return
	 */
	public List<Sales> getListSales(@Param("status") Integer status,@Param("level") Integer level);
	
	
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
     * 新增数据
     * @param sales
     * @return
     */
    public int insertSales(Sales sales);
    
    /**
     * 更新数据
     * @param sales
     * @return
     */
    public int updateSales(Sales sales);
    
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
	 * 查询销售绩效 
	 */
	public List<SalesPerf> getSalesPerfList(@Param("o") SalesPerf salesPerf,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	
	/**
	 * 查询销售绩效数量 
	 */
	public int getSalesPerfCount(@Param("o") SalesPerf salesPerf);
}
