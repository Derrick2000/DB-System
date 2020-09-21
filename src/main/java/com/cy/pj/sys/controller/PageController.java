package com.cy.pj.sys.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.common.utils.ShiroUtils;
import com.cy.pj.sys.pojo.SysUser;
import com.cy.pj.sys.pojo.SysUserMenu;
import com.cy.pj.sys.service.SysMenuService;
import com.cy.pj.sys.service.SysUserService;

@RequestMapping("/")
@Controller
public class PageController {
	
	@Autowired
	private SysMenuService sysMenuService;
	@RequestMapping("doIndexUI")
	public String doIndexUI(Model model){
		SysUser user = ShiroUtils.getUser();
		model.addAttribute("user",user);
		List<SysUserMenu> userMenus = sysMenuService.findUserMenusByUserId(user.getId());
		model.addAttribute("userMenus",userMenus);
		return "starter";
	}
	

	
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
	
//	@RequestMapping("menu/menu_list")
//	public String doMenuUI() {
//		return "sys/menu_list";
//	}
	
	@RequestMapping("{module}/{moduleUI}")
	public String doModuleUI(@PathVariable String moduleUI) {
		return "sys/"+moduleUI;
	}
	
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}
	
	
	
}
