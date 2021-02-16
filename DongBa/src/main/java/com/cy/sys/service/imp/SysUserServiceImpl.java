package com.cy.sys.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.bo.PageObject;
import com.cy.common.exception.ServiceException;
import com.cy.common.utils.AssertUtils;
import com.cy.common.utils.ShiroUtils;
import com.cy.sys.dao.SysUserDao;
import com.cy.sys.dao.SysUserRoleDao;
import com.cy.sys.pojo.SysUser;
import com.cy.sys.service.SysUserService;
import com.cy.sys.vo.SysUserDeptVo;
import com.github.pagehelper.util.StringUtil;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Override
	public PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent) {
		if(pageCurrent == null || pageCurrent < 1) {
			throw new IllegalArgumentException("Invalid page number");
		}
		int rowCount = sysUserDao.getRowCount(username);
		if(rowCount == 0) {
			throw new ServiceException("No corresponding records");
		}
		int pageSize = 5;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysUserDeptVo> records = sysUserDao.findPageObjects(username, startIndex, pageSize);
		
		return new PageObject<>(pageCurrent,pageSize,rowCount,records);
	}
	@Override
	public int updatePassword(String sourcePassword, String newPassword, String cfgPassword) {
		AssertUtils.isArgValid(StringUtil.isEmpty(sourcePassword), "Old password cannot be empty");
		AssertUtils.isArgValid(StringUtil.isEmpty(newPassword), "New password cannot be empty");
		AssertUtils.isArgValid(!newPassword.equals(cfgPassword), "Two passwords are different");
		
		SysUser user = ShiroUtils.getUser();
		String hashedPwd = user.getPassword();
		SimpleHash sh = new SimpleHash("MD5",sourcePassword,user.getSalt(),1);
		AssertUtils.isArgValid(!hashedPwd.equals(sh.toHex()), "Old password is incorrect");
		
		String newSalt=UUID.randomUUID().toString();
		sh=new SimpleHash("MD5",newPassword,newSalt,1);
		String newHashedPwd=sh.toHex();
		int rows = sysUserDao.updatePassword(newHashedPwd, newSalt, user.getId());
		return rows;
	}
	
	
	@Override
	public Map<String, Object> findObjectById(Integer id) {
		AssertUtils.isArgValid(id==null||id<1, "Invalid id");
		SysUserDeptVo user = sysUserDao.findObjectById(id);
		AssertUtils.isServiceValid(user==null, "Record may not exist");
		List<Integer> roleIds=sysUserRoleDao.findRoleIdsByUserId(id);
		Map<String,Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roleIds", roleIds);
		return map;
	}
	@Override
	public int updateObject(SysUser entity, Integer[] roleIds) {
		AssertUtils.isArgValid(entity==null, "New user cannot be null");
		AssertUtils.isArgValid(entity.getUsername()==null||"".equals(entity.getUsername()), "Username cannot be empty");
		AssertUtils.isArgValid(roleIds==null||roleIds.length==0, "User has to have a role");
		
		int rows = sysUserDao.updateObject(entity);
		AssertUtils.isServiceValid(rows==0, "Record may not exist");
		
		sysUserRoleDao.deleteObjectsByRoleId(entity.getId());
		sysUserRoleDao.insertObject(entity.getId(), roleIds);
		return rows;
	}
	@Override
	public int saveObject(SysUser entity, Integer[] roleIds) {
		AssertUtils.isArgValid(entity==null, "User cannot be null");
		AssertUtils.isArgValid(entity.getUsername()==null||"".equals(entity.getUsername()), "Username cannot be empty");
		AssertUtils.isArgValid(entity.getPassword()==null||"".equals(entity.getPassword()), "Password cannot be empty");
		AssertUtils.isArgValid(roleIds==null||roleIds.length==0, "User has to have a role");		
		
		String salt = UUID.randomUUID().toString();
		SimpleHash sh = new SimpleHash("MD5",entity.getPassword(),salt,1);
		String hashedPassword = sh.toHex();
		entity.setSalt(salt);
		entity.setPassword(hashedPassword);
		int rows = sysUserDao.insertObject(entity);
		sysUserRoleDao.insertObject(entity.getId(), roleIds);
		return rows;
	}
	@Override
	public int validById(Integer id, Integer valid) {
		AssertUtils.isArgValid(id==null||id<1, "Invalid id");
		AssertUtils.isArgValid(valid!=0&&valid!=1, "Invalid valid number");
		
		int rows = sysUserDao.validById(id, valid, ShiroUtils.getUser().toString());
		if(rows==0) {
			throw new ServiceException("Record may not exist");
		}
		return rows;
	}

}
