package com.cy.sys.service.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.sys.dao.SysMenuDao;
import com.cy.sys.dao.SysRoleMenuDao;
import com.cy.sys.dao.SysUserDao;
import com.cy.sys.dao.SysUserRoleDao;
import com.cy.sys.pojo.SysUser;


@Service
public class ShiroUserRealm extends AuthorizingRealm{

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	
	/**
	 * 设置凭证适配器
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
		
		//设置加密算法
		cMatcher.setHashAlgorithmName("MD5");
		//加密次数
		cMatcher.setHashIterations(1);
		super.setCredentialsMatcher(cMatcher);
	}
	
	/**
	 * 完成认证数据的获取及封装，系统底层会将认证数据传递认证管理器，由认证管理器完成认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo
						(AuthenticationToken token) throws AuthenticationException{
			
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		SysUser user = sysUserDao.findUserByUserName(username);
		if(user == null) {
			throw new UnknownAccountException();
		}
		if(user.getValid() == 0) {
			throw new LockedAccountException();
		}
		
		//封装
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo
				(user,user.getPassword(),credentialsSalt, getName());
		return info;
		
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser user = (SysUser) principals.getPrimaryPrincipal();
		Integer userIds = user.getId();
		List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(userIds);
		if(roleIds == null || roleIds.size() == 0) {
			throw new AuthorizationException();
		}
		List<Integer> menuIds = sysRoleMenuDao.findMenuIdsByRoleIds(roleIds);
		if(menuIds == null || menuIds.size() == 0) {
			throw new AuthorizationException();
		}
		List<String> permissions = sysMenuDao.findPermissions(menuIds);
		Set<String> set = new HashSet<>();
		for(String per:permissions) {
			if(!StringUtils.isEmpty(per)) {
				set.add(per);
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(set);
		return info;
	}
	
}
