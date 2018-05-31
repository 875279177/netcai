package com.netcai.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.SysRoleDao;
import com.netcai.admin.entity.SysRole;
import com.netcai.admin.service.SysRoleService;
import com.netcai.admin.utils.PageUtil;

/**
 * 角色service impl
 * @author administrator
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	private SysRoleDao sysRoleDao;
	
	/**
	 * 分页查询角色
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<SysRole> getAllSysRole(int currentPageNum,int currentPageSize){
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		return sysRoleDao.getAllSysRole(offset, currentPageSize);
	}

	/**
	 * 查询总记录数
	 * @return PageUtil
	 */
	public PageUtil getPageResult(int currentPageNum,int currentPageSize){
		int size = sysRoleDao.getPageCount();
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<SysRole> result = sysRoleDao.getAllSysRole(offset, currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}

	/**
	 * 添加角色
	 */
	public int insertSysRole(SysRole role){
		return sysRoleDao.insertSysRole(role);
	}

	/**
	 * 更新角色
	 */
	public int updateSysRole(SysRole role){
		return sysRoleDao.updateSysRole(role);
	}
	
	/**
	 * 根据id查找角色
	 */
	public SysRole getSysRoleById(int id){
		return sysRoleDao.getSysRoleById(id);
	}
	
	/**
	 * 取得所有在用的角色
	 */
	public List<SysRole> getAllSysRoleByStatus(){
		return sysRoleDao.getAllSysRoleByStatus();
	}
	
	/**
	 * 取得用户角色信息
	 */
    public List<SysRole> getRoleByUserId(Long userId){
    	return sysRoleDao.getRoleByUserId(userId);
    }
}
