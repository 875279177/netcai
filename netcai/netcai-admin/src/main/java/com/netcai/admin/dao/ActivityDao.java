package com.netcai.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Activity;
import com.netcai.admin.vo.ActivityVo;

/**
 * 促销活动DAO
 * @author administrator
 */
public interface ActivityDao {


	/**
	 * 分页查询活动信息
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Activity> getAllActivity(@Param("activity") Activity activity,@Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * @return total
	 */
	public int getPageCount(@Param("activity") Activity activity);
	
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
	public ActivityVo getActivityInfo(@Param("activityId") int activityId);
}
