package com.netcai.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.SysStatus;
import com.netcai.admin.dao.GroupsItemDao;
import com.netcai.admin.entity.GroupsItem;
import com.netcai.admin.service.GroupsItemService;
import com.netcai.admin.vo.GroupsVo;

/**
 * 团购活动明细
 * @author administrator
 *
 */
@Service
public class GroupsItemServiceImpl implements GroupsItemService{
	
	@Autowired
	private GroupsItemDao groupsItemDao;
	
	@Override
	public int add(GroupsVo groups) {
		List<GroupsItem> items = new ArrayList<GroupsItem>();
		Date now = new Date();
		//获取ids
		String ids = groups.getFormatIds();
		if(StringUtils.isBlank(ids)){
			return 0;
		}
		List<Long> list = new ArrayList<Long>();
		Long groupId = groups.getId();
		if(ids.indexOf(",")!=-1){
			//将区域id分割，转换成区域名称
			String[] formatIds = ids.trim().split(",");
			for(String id :formatIds){
				if(StringUtils.isBlank(id)){
					continue ;
				}
				//将id转换为Long类型
				Long formatId = new Long(id);
				GroupsItem item = new GroupsItem();
				item.setGroupId(groupId);
				item.setGoodsId(groups.getGoodsId());
				item.setFormatId(formatId);
				item.setCreateUserId(groups.getCreateUserId());
				item.setPrice(groups.getGroupPrice());
				item.setCount(groups.getCount());
				item.setStatus(-1);
				item.setCreateTime(now);
				items.add(item);
				list.add(formatId);
			}
		}else{
			//将id转换为Long类型
			Long formatId = new Long(ids);
			GroupsItem item = new GroupsItem();
			item.setGroupId(groupId);
			item.setGoodsId(groups.getGoodsId());
			item.setFormatId(formatId);
			item.setCreateUserId(groups.getCreateUserId());
			item.setPrice(groups.getGroupPrice());
			item.setCount(groups.getCount());
			item.setStatus(-1);
			item.setCreateTime(now);
			items.add(item);
			list.add(formatId);
		}
		//新增之前删除重复的数据
		groupsItemDao.batchDelete(groupId,list);
		//批量新增
		return groupsItemDao.batchInsert(items);
	}
	
	/**
	 * 更新
	 */
	@Override
	public int update(GroupsVo groups) {
		GroupsItem item = new GroupsItem();
		item.setId(groups.getItemId());
		item.setPrice(groups.getGroupPrice());
		item.setCount(groups.getCount());
		return groupsItemDao.update(item);
	}
	
	/**
	 * 根据团购活动id查询明细
	 */
	@Override
	public List<GroupsItem> getByGroupsId(Long groupsId) {
		return groupsItemDao.getByGroupsId(groupsId);
	}
	
	/**
	 * 启用
	 */
	@Override
	public int enabled(Long id) {
		return groupsItemDao.updateStatus(id, SysStatus.UN_FORBIDDEN);
	}
	
	/**
	 * 禁用
	 */
	@Override
	public int disabled(Long id) {
		return groupsItemDao.updateStatus(id, SysStatus.FORBIDDEN);
	}
	
}
