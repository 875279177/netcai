package com.netcai.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.SysStatus;
import com.netcai.admin.dao.AreaDao;
import com.netcai.admin.dao.GroupsDao;
import com.netcai.admin.dao.GroupsItemDao;
import com.netcai.admin.entity.Area;
import com.netcai.admin.service.GroupsService;
import com.netcai.admin.utils.GroupsNumberGenerator;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.GroupsVo;

/**
 * 团购活动serviceImple
 * 
 * @author administrator
 *
 */
@Service
public class GroupsServiceImpl implements GroupsService {

	@Autowired
	private GroupsDao groupsDao;
	
	@Autowired
	private GroupsItemDao groupsItemDao;

	@Autowired
	private AreaDao areaDao;

	/**
	 * 分页查询团购活动信息
	 * 
	 * @return
	 */
	@Override
	public PageUtil getAllByPage(GroupsVo groups, int currentPage, int pageSize) {
		// 查询总记录数
		int total = groupsDao.getTotalCount(groups);
		if (currentPage <= 0) {
			currentPage = 1;
		}
		// 起始条数
		int start = (currentPage - 1) * pageSize;
		List<GroupsVo> list = groupsDao.getAll(groups, start, pageSize);
		list = getRegionNames(list);
		PageUtil pageUtil = new PageUtil(pageSize, total, currentPage);
		pageUtil.setObject(list);
		return pageUtil;
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@Override
	public GroupsVo getById(Long id) {
		return groupsDao.getById(id);
	}

	/**
	 * 新增
	 */
	@Override
	public int insert(GroupsVo groups) {
		//设置团购表示号
		groups.setGroupNumber(GroupsNumberGenerator.getGroupsNumber());
		// 设置团购活动未开始
		groups.setStatus(-1);
		groups.setCreateTime(new Date());
		return groupsDao.insert(groups);
	}

	/**
	 * 更新
	 */
	@Override
	public int update(GroupsVo groups) {
		return groupsDao.update(groups);
	}

	/**
	 * 更改状态为不开团
	 */
	@Override
	public int disabled(Long id) {
		//更新明细的状态为启用
		groupsItemDao.updateStatusByGroupsId(id, SysStatus.FORBIDDEN);
		return groupsDao.updateStatus(id, SysStatus.FORBIDDEN);
	}

	/**
	 * 更改状态为开团
	 */
	@Override
	public int enabled(Long id) {
		//更新明细的状态为启用
		groupsItemDao.updateStatusByGroupsId(id, SysStatus.UN_FORBIDDEN);
		return groupsDao.updateStatus(id, SysStatus.UN_FORBIDDEN);
	}

	/**
	 * 将区域id转换为字符串
	 * 
	 * @param list
	 * @return
	 */
	public List<GroupsVo> getRegionNames(List<GroupsVo> list) {
		if (CollectionUtils.isNotEmpty(list)) {
			for (GroupsVo groups : list) {
				// 获取ids
				String ids = groups.getRegionIds();
				if (StringUtils.isBlank(ids)) {
					continue;
				}
				StringBuilder regionNames = new StringBuilder("");
				//多个区域
				if (ids.indexOf(",") != -1) {
					// 将区域id分割，转换成区域名称
					String[] regionIds = ids.trim().split(",");
					for (String regionId : regionIds) {
						if (StringUtils.isBlank(regionId)) {
							continue;
						}
						// 根据区域id查询区域
						Area area = areaDao.getAreaById(new Long(regionId));
						if (null != area && StringUtils.isNotBlank(area.getAreaName())) {
							regionNames.append(area.getAreaName());
							regionNames.append(",");
						}
					}
					regionNames.deleteCharAt(regionNames.length() - 1);
				} else {
					Area area = areaDao.getAreaById(new Long(ids));
					if (null != area && StringUtils.isNotBlank(area.getAreaName())) {
						regionNames.append(area.getAreaName());
					}
				}
				groups.setRegionNames(regionNames.toString());

			}
		}
		return list;
	}

}
