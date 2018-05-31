package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Banner;

/**
 * 广告信息管理Dao
 * @author administrator
 *
 */
public interface BannerDao {
	
	/**
	 * 
	 * 分页查询
	 * @param banner
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Banner> getAllBanners(@Param("banner") Banner banner, @Param("offset") int offset,
			@Param("pageSize") int pageSize);
	
	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getPageCount();
	
	/**
	 * 根据id查询广告信息
	 * @param id
	 * @return
	 */
    public Banner getBannerById(Long id);
    
    /**
     * 新增数据
     * @param banner
     * @return
     */
    public int insertBanner(Banner banner);
    
    /**
     * 更新数据
     * @param banner
     * @return
     */
    public int updateBanner(Banner banner);
    
    /**
     * 启用
     * @param id
     * @return
     */
    public int enabledBanner(long id);
    
    /**
     * 禁用
     * @param id
     * @return
     */
    public int disabledBanner(long id);
   
    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Long id);

}
