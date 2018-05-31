package com.netcai.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.ActivityDao;
import com.netcai.admin.dao.ActivityFormatDao;
import com.netcai.admin.dao.ActivityGoodsDao;
import com.netcai.admin.dao.ActivitySellerDao;
import com.netcai.admin.entity.Activity;
import com.netcai.admin.entity.ActivityFormat;
import com.netcai.admin.entity.ActivityGoods;
import com.netcai.admin.entity.ActivitySeller;
import com.netcai.admin.service.ActivityService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.ActivityVo;

/**
 * 促销活动信息serviceimpl
 * @author administrator
 */
@Service
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	private ActivityDao activityDao;
	@Autowired
	private ActivityFormatDao activityFormatDao;
	@Autowired
	private ActivitySellerDao activitySellerDao;
	@Autowired
	private ActivityGoodsDao activityGoodsDao;
	
	/**
	 * 分页查询活动信息
	 * @param currentPageNum
	 * @param currentPageSize
	 * @return
	 */
	@Override
	public List<Activity> getAllActivity(Activity activity,int currentPageNum,int currentPageSize){
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		return activityDao.getAllActivity(activity,offset, currentPageSize);
	}

	/**
	 * 查询总记录数
	 * @return PageUtil
	 */
	@Override
	public PageUtil getPageResult(Activity activity,int currentPageNum,int currentPageSize){
		int size = activityDao.getPageCount(activity);
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<Activity> result = activityDao.getAllActivity(activity,currentPageNum, currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}
	
	
	/**
	 * 新增活动信息
	 */
	@Override
	public int insertActivity(Activity activity){
		activityDao.insertActivity(activity);
		int activityId = activity.getActivityId();
		//添加活动规则
		List<ActivityFormat> formatList = activity.getActivityFormatList();
		if (null != formatList && formatList.size()>0) {
			activityFormatDao.batchInsertActivityFormat(activity);
		}
		//添加活动商家
		List<ActivitySeller> sellerList = activity.getActivitySellerList();
		if (null != sellerList && sellerList.size()>0) {
			activitySellerDao.batchInsertActivitySeller(activity);
		}
		//添加活动商品
		List<ActivityGoods> goodsList = activity.getActivityGoodsList();
		if (null != goodsList && goodsList.size()>0) {
			activityGoodsDao.batchInsertActivityGoods(activity);
		}
		return activityId;
	}

	/**
	 * 更新活动信息
	 */
	@Override
	public int updateActivity(Activity activity) {
		int stat = activityDao.updateActivity(activity);
		int activityId = activity.getActivityId();
		//删除原记录
		activityFormatDao.deleteActivityFormat(activityId);
		//添加活动规则
		List<ActivityFormat> formatList = activity.getActivityFormatList();
		if (null != formatList && formatList.size()>0) {
			activityFormatDao.batchInsertActivityFormat(activity);
		}
		//删除原记录
		activitySellerDao.deleteActivitySeller(activityId);
		//添加活动商家
		List<ActivitySeller> sellerList = activity.getActivitySellerList();
		if (null != sellerList && sellerList.size()>0) {
			activitySellerDao.batchInsertActivitySeller(activity);
		}
		//删除原记录
		activityGoodsDao.deleteActivityGoods(activityId);
		//添加活动商品
		List<ActivityGoods> goodsList = activity.getActivityGoodsList();
		if (null != goodsList && goodsList.size()>0) {
			activityGoodsDao.batchInsertActivityGoods(activity);
		}
		return stat;
	}
	
	/**
	 * 取得活动详情
	 */
	public ActivityVo getActivityInfo(int activityId){
		return activityDao.getActivityInfo(activityId);
	}
}
