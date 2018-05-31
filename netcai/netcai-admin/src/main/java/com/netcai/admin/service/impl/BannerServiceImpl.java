package com.netcai.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.SysStatus;
import com.netcai.admin.dao.BannerDao;
import com.netcai.admin.entity.Banner;
import com.netcai.admin.service.BannerService;
import com.netcai.admin.utils.PageUtil;

/**
 * 广告信息service实现
 * @author administrator
 *
 */
@Service
public class BannerServiceImpl implements BannerService{
	
	@Autowired 
	private BannerDao bannerDao;
	
	/**
	 * 分页查询
	 */
	@Override
	public PageUtil getAllBanners(Banner banner, int pageNum, int pageSize) {
		
		int size = bannerDao.getPageCount();

		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

		List<Banner> result = bannerDao.getAllBanners(banner, offset, pageSize);

		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}
	
	/**
	 * 根据id查询
	 */
	@Override
	public Banner getBannerById(Long id) {
		return bannerDao.getBannerById(id);
	}
	
	/**
	 * 新增和更新数据
	 */
	@Override
	public int insertAndUpdate(Banner banner) {
		if(banner.getId() != null){
			return bannerDao.updateBanner(banner);
		}
		//默认设置为启用
		banner.setStatus(SysStatus.UN_FORBIDDEN);
		banner.setCreateTime(new Date());
		banner.setBannerSeq(1);
		return bannerDao.insertBanner(banner);
	}
	
	/**
	 * 启用
	 */
	@Override
	public int enabledBanner(long id) {
		return bannerDao.enabledBanner(id);
	}
	
	/**
	 * 禁用
	 */
	@Override
	public int disabledBanner(long id) {
		return bannerDao.disabledBanner(id);
	}
	
	/**
	 * 删除
	 */
	@Override
	public int delete(Long id) {
		return bannerDao.delete(id);
	}

}
