package com.netcai.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.SysStatus;
import com.netcai.admin.dao.DeliveryAreaDao;
import com.netcai.admin.dao.DeliveryRelatedAreaDao;
import com.netcai.admin.entity.DeliveryRelatedArea;
import com.netcai.admin.service.DeliveryAreaService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.DeliveryAreaVo;

@Service
public class DeliveryAreaServiceImpl implements DeliveryAreaService {

	@Autowired
	private DeliveryAreaDao deliveryAreaDao;
	@Autowired
	private DeliveryRelatedAreaDao deliveryRelatedAreaDao;

	/**
	 * 分页查询
	 */
	@Override
	public PageUtil getAll(DeliveryAreaVo deliveryArea, int pageNum, int pageSize) {
		int size = deliveryAreaDao.getPageCount(deliveryArea);

		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

		List<DeliveryAreaVo> result = deliveryAreaDao.getAll(deliveryArea, offset, pageSize);

		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}

	/**
	 * 新增和修改
	 */
	@Override
	public int insertAndUpdate(DeliveryAreaVo deliveryArea) {
		if (deliveryArea.getId() != null) {
			return deliveryAreaDao.update(deliveryArea);
		}
		// 设置状态未启用
		deliveryArea.setStatus(SysStatus.UN_FORBIDDEN);
		deliveryArea.setCreateTime(new Date());
		return deliveryAreaDao.insert(deliveryArea);
	}

	/**
	 * 根据id查询配送区域
	 */
	@Override
	public DeliveryAreaVo selectById(Long id) {
		return deliveryAreaDao.selectById(id);
	}

	/**
	 * 根据areaId查询配送区域
	 */
	@Override
	public List<DeliveryAreaVo> selectByAreaId(Long areaId) {
		return deliveryAreaDao.selectByAreaId(areaId);
	}

	/**
	 * 启用
	 */
	@Override
	public int enabled(Long id) {
		return deliveryAreaDao.updateStatus(id, SysStatus.UN_FORBIDDEN);
	}

	/**
	 * 禁用
	 */
	@Override
	public int disabled(Long id) {
		return deliveryAreaDao.updateStatus(id, SysStatus.FORBIDDEN);
	}

	/**
	 * 配送人员分配一个或多个配送区域
	 */
	@Override
	public int distributeDelivery(DeliveryRelatedArea deliveryRelatedArea, String deliveryAreaIds) {
		List<DeliveryRelatedArea> list = new ArrayList<DeliveryRelatedArea>();
		Date time = new Date();
		Map<String, Object> map = new HashMap<String, Object>();
		//根据配送人员id查询关联表
		map.put("deliveryId", deliveryRelatedArea.getDeliveryId());
		List<DeliveryRelatedArea> relatedAreas = deliveryRelatedAreaDao.getByMap(map);
		if(CollectionUtils.isNotEmpty(relatedAreas)){
			//新增数据之前根据配送人员id删除之前的数据
			deliveryRelatedAreaDao.deleteByDeliveryId(deliveryRelatedArea.getDeliveryId());
		}
		//配送区域id为空
		if(StringUtils.isBlank(deliveryAreaIds)){
			return 0 ;
		}
		// 分配多个配送区域
		if (deliveryAreaIds.indexOf(",") != -1) {
			//将多个配送区域id以","分割
			String[] ids = deliveryAreaIds.trim().split(",");
			DeliveryRelatedArea entity =null;
			for(int i=0;i<ids.length;i++){
				String id=ids[i].trim();
				if(StringUtils.isBlank(id)){
					continue;
				}
				Long deliveryAreaId = Long.parseLong(id);
				entity = new DeliveryRelatedArea();
				entity.setDeliveryAreaId(deliveryAreaId);
				entity.setDeliveryId(deliveryRelatedArea.getDeliveryId());
				entity.setUserId(deliveryRelatedArea.getUserId());
				entity.setCreateTime(time);
				
				//将新增的数据添加到集合
				list.add(entity);
			}
		} else {// 分配单个配送区域
			deliveryRelatedArea.setDeliveryAreaId(Long.parseLong(deliveryAreaIds));
			deliveryRelatedArea.setCreateTime(time);
			//将新增的数据添加到集合
			list.add(deliveryRelatedArea);
		}
		//集合为空直接返回0
		if(CollectionUtils.isEmpty(list)){
			return 0;
		}
		return deliveryRelatedAreaDao.batchInsert(list);
	}
	
	/**
	 * 查询全部配送区域
	 */
	public List<DeliveryAreaVo> selectDeliveryAreas() {
		return deliveryAreaDao.selectDeliveryAreas();
	}

}
