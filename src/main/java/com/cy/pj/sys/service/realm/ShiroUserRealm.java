package com.cy.pj.sys.service.realm;

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

import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.pojo.SysUser;

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

	
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
		cMatcher.setHashAlgorithmName("MD5");
		cMatcher.setHashIterations(1);
		super.setCredentialsMatcher(cMatcher);
	}
	


	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		SysUser user = sysUserDao.findUserByUsername(username);
		if(user == null)
			throw new UnknownAccountException();
		if(user.getValid()==0)
			throw new LockedAccountException();
		
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),credentialsSalt,getName());
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
			SysUser user = (SysUser)principals.getPrimaryPrincipal();
			Integer userId = user.getId();
			List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(userId);
			if(roleIds==null||roleIds.size()==0)
				throw new AuthorizationException();
			List<Integer> menuIds = sysRoleMenuDao.findMenuIdsByRoleIds(roleIds);
			if(menuIds==null||roleIds.size()==0)
				throw new AuthorizationException();
			List<String> permissions = sysMenuDao.findPermissions(menuIds);
			Set<String> set = new HashSet<>();
			for(String permission:permissions) {
				if(!StringUtils.isEmpty(permission)) {
					set.add(permission);
				}
			}
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.setStringPermissions(set);
			return info;
	}

}
