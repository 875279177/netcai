package com.netcai.admin.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.netcai.admin.constants.DeliverySex;
import com.netcai.admin.constants.DeliveryType;
import com.netcai.admin.constants.SysStatus;
import com.netcai.admin.dao.AreaDao;
import com.netcai.admin.dao.DeliveryDao;
import com.netcai.admin.dao.DeliveryRelatedAreaDao;
import com.netcai.admin.entity.Area;
import com.netcai.admin.entity.Delivery;
import com.netcai.admin.entity.DeliveryRelatedArea;
import com.netcai.admin.service.DeliveryService;
import com.netcai.admin.utils.EncryptUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.DeliveryCoordinateVo;

/**
 * 配送人员基本信息service实现
 * 
 * @author mengjie
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryDao deliveryDao;

	@Autowired
	private AreaDao areaDao;

	@Autowired
	private DeliveryRelatedAreaDao deliveryRelatedAreaDao;

	/**
	 * 根据map查询配送人员基本信息
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public Delivery getDelivery(Map<String, Object> map) {
		Delivery delivery = deliveryDao.getDelivery(map);
		if (delivery != null && delivery.getAreaId() != null) {
			Area area = areaDao.getAreaById(delivery.getAreaId());
			if(area!=null && StringUtils.isNotBlank(area.getAreaName())){
				delivery.setAreaName(area.getAreaName());
			}else{
				delivery.setAreaName("");
			}
			
		}
		return delivery;
	}

	/**
	 * 分页查询配送人员信息
	 * 
	 * @param delivery
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageUtil getPageResult(Delivery delivery, int pageNum, int pageSize) {
		// 对象判空
		Assert.notNull(delivery, "Argument delivery object is null");
		// 当类型为0时查询全部
		if (delivery.getDeliveryType() != null && delivery.getDeliveryType() == 0) {
			delivery.setDeliveryType(null);
		}
		// 当状态为0时查询全部
		if (delivery.getStatus() != null && delivery.getStatus() == 0) {
			delivery.setStatus(null);
		}

		int size = deliveryDao.getPageCount(delivery);

		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

		List<Delivery> result = deliveryDao.getAll(delivery, offset, pageSize);
		if (CollectionUtils.isNotEmpty(result)) {
			for (Delivery entity : result) {
				Area area = areaDao.getAreaById(entity.getAreaId());
				if(area!=null && StringUtils.isNotBlank(area.getAreaName())){
					entity.setAreaName(area.getAreaName());
				}else{
					entity.setAreaName("");
				}
			}
		}

		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}

	/**
	 * 禁用
	 */
	@Override
	public int disabled(Long id) {
		return deliveryDao.disabled(id);
	}

	/**
	 * 启用
	 */
	@Override
	public int enabled(Long id) {
		return deliveryDao.enabled(id);
	}

	/**
	 * 新增配送人员信息
	 * 
	 * @param delivery
	 * @return
	 */
	@Override
	public int insertDelivery(Delivery delivery) {
		int sequence = 1;
		if (StringUtils.isNotBlank(delivery.getDeliveryPassword())) {
			delivery.setDeliveryPassword(EncryptUtil.getMD5(delivery.getDeliveryPassword()));
		}
		// 若id不为空则更新数据
		if (delivery.getId() != null) {
			delivery.setLastUpdateTime(new Date());
			return deliveryDao.updateDelivery(delivery);
		}

		if (delivery.getDeliverySex() == null) {
			// 性别为空时给默认值为男
			delivery.setDeliverySex(DeliverySex.MALE);
		}
		if (delivery.getDeliveryType() == null || delivery.getDeliveryType() == 0) {
			// 类型为空时给默认值为自营
			delivery.setDeliveryType(DeliveryType.SELFSUPPORT);
		}

		// 设置排序为默认
		delivery.setSequence(sequence);
		// 设置状态为默认在职
		delivery.setStatus(SysStatus.UN_FORBIDDEN);
		delivery.setCreateTime(new Date());
		return deliveryDao.insertDelivery(delivery);
	}

	/**
	 * 根据id查询配送人员信息
	 */
	@Override
	public Delivery getById(Long deliveryId) {
		return deliveryDao.getById(deliveryId);
	}

	/**
	 * 查询所有的配送人员信息
	 */
	@Override
	public List<Delivery> getDeliverys() {
		return deliveryDao.getDeliverys();
	}

	/**
	 * 查看配送人员负责的配送区域
	 */
	@Override
	public List<DeliveryRelatedArea> getDeliveryAreaById(Long deliveryId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deliveryId", deliveryId);
		return deliveryRelatedAreaDao.getByMap(map);
	}

	/**
	 * 获取配送人员坐标
	 */
	public List<DeliveryCoordinateVo> getDeliveryCoordinate(Long deliveryId) {
		return deliveryDao.getDeliveryCoordinate(deliveryId);
	}
}