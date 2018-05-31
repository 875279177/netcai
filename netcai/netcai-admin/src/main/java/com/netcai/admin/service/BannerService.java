package com.netcai.admin.service;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Banner;
import com.netcai.admin.utils.PageUtil;

public interface BannerService {

	/**
	 * 分页查询
	 * 
	 * @param banner
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAllBanners(@Param("banner") Banner banner, @Param("offset") int pageNum,
			@Param("pageSize") int pageSize);

	/**
	 * 根据id查询广告信息
	 * 
	 * @param id
	 * @return
	 */
	public Banner getBannerById(Long id);

	/**
	 * 新增和修改数据
	 * 
	 * @param banner
	 * @return
	 */
	public int insertAndUpdate(Banner banner);


	/**
	 * 启用
	 * 
	 * @param id
	 * @return
	 */
	public int enabledBanner(long id);

	/**
	 * 禁用
	 * 
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
