package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.Activity;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.ActivityVo;

/**
 * 促销活动service
 * @author administrator
 */
public interface ActivityService {

	/**
	 * 分页查询活动信息
	 * @param currentPageNum
	 * @param currentPageSize
	 * @return
	 */
	public List<Activity> getAllActivity(Activity activity,int currentPageNum,int currentPageSize);

	/**
	 * 查询总记录数
	 * @return PageUtil
	 */
	public PageUtil getPageResult(Activity activity,int currentPageNum,int currentPageSize);
	
	
	/**
	 * 新增活动信息
	 */
	public int insertActivity(Activity activity);

	/**
	 * 更新活动信息
	 */
	public int updateActivity(Activity activity);
	
	/**
	 * 取得活动详情
	 */
	public ActivityVo getActivityInfo(int activityId);
}
