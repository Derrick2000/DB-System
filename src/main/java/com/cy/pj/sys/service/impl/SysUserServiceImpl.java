package com.cy.pj.sys.service.impl;

import java.util.HashMap;


import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.bo.PageObject;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.utils.AssertUtils;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.pojo.SysUser;
import com.cy.pj.sys.pojo.SysUserDept;
import com.cy.pj.sys.service.SysUserService;
@Transactional(readOnly = false,
				rollbackFor = Exception.class,
				timeout = 60,
				isolation = Isolation.READ_COMMITTED)
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired 
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Transactional(readOnly = true)
	@RequiredLog(value="FindbyPage")
	@Override
	public PageObject<SysUserDept> findPageObjects(String username, Integer pageCurrent) {
		//1.对参数进行校验
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("Invalid Page number");
		//2.查询总记录数并进行校验
		int rowCount=sysUserDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("No record is found");
		//3.查询当前页记录
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysUserDept> records=
		sysUserDao.findPageObjects(username,
		startIndex, pageSize);
		//4.对查询结果进行封装并返回
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}
	
	@Transactional
	@RequiredLog(value="Save user")
	@Override
	public int saveObject(SysUser entity, Integer[] roleIds) {
		if(entity==null)
			throw new IllegalArgumentException("The saved object cannot be empty");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new IllegalArgumentException("Username cannot be empty");
		if(StringUtils.isEmpty(entity.getPassword()))
			throw new IllegalArgumentException("Password cannot be empty");
		if(roleIds==null || roleIds.length==0)
			throw new IllegalArgumentException("At least setting a role for the user");
		
		String source = entity.getPassword();
		String salt = UUID.randomUUID().toString();
		SimpleHash sh = new SimpleHash("MD5", source, salt, 1);
		entity.setSalt(salt);
		entity.setPassword(sh.toHex());
		int rows=sysUserDao.insertObject(entity);
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		
		return rows;
	}

	@Transactional(readOnly = true) //Recommended for search
	@Override
	public Map<String, Object> findObjectById(Integer userId) {
		if(userId==null || userId<=0)
			throw new IllegalArgumentException("Illegal parameter, userId="+userId);
		SysUserDept user = sysUserDao.findObjectById(userId);
		if(user==null)
			throw new ServiceException("This user is gone forever");
		List<Integer> roleIds=sysUserRoleDao.findRoleIdsByUserId(userId);
		Map<String,Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roleIds",roleIds);
		return map;
	}


	@Override
	public int updateObject(SysUser entity, Integer[] roleIds) {
		if(entity==null) 
			throw new IllegalArgumentException("Saved object cannot be empty");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new IllegalArgumentException("Username cannot be empty");
		if(roleIds==null||roleIds.length==0)
			throw new IllegalArgumentException("It has to have a role id");	
		int rows = sysUserDao.updateObject(entity);
		sysUserRoleDao.deleteObjectsByUserId(entity.getId());
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		return rows;
	}

	@Override
	public int updatePassword(String password, String newPassword,String checkPassword) {
		//1.判定新密码与密码确认是否相同
		System.out.println(password);
		System.out.println(newPassword);
		System.out.println(checkPassword);
		if(StringUtils.isEmpty(newPassword))
			throw new IllegalArgumentException("New Password cannot be empty");
		if(StringUtils.isEmpty(checkPassword))
			throw new IllegalArgumentException("Confirm Password cannot be empty");
		if(!newPassword.equals(checkPassword))			
			throw new IllegalArgumentException("Passwords typed are inconsistent");
		//2.判定原密码是否正确
		if(StringUtils.isEmpty(password))
			throw new IllegalArgumentException("Old password cannot be empty");
		//获取登陆用户
		SysUser user=(SysUser)SecurityUtils.getSubject().getPrincipal();
		SimpleHash sh=new SimpleHash("MD5",password, user.getSalt(), 1);
		if(!user.getPassword().equals(sh.toHex()))
			throw new IllegalArgumentException("Old password is incorrect");
		//3.对新密码进行加密
		String salt=UUID.randomUUID().toString();
		sh=new SimpleHash("MD5",newPassword,salt, 1);
		//4.将新密码加密以后的结果更新到数据库
		int rows=sysUserDao.updatePassword(sh.toHex(), salt,user.getId());
		if(rows==0)
		throw new ServiceException("Update failed");
		return rows;
	}

	@Transactional(rollbackFor = IllegalArgumentException.class)
	@RequiredLog(value="Start and Block")
	@Override
	public int validById(Integer id, Integer valid) {
		AssertUtils.isArgValid(id==null||id<1,"invalid parameter");
		AssertUtils.isArgValid(valid!=0&&valid!=0, "Invalid status value");
		int rows = sysUserDao.validById(id, valid, "admin");//admin for now
		if(rows==1)
			throw new ServiceException("Record may not exist");
		return rows;
	}


}
