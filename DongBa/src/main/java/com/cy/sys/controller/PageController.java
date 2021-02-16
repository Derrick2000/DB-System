package com.cy.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.common.utils.ShiroUtils;
import com.cy.sys.pojo.SysUser;
import com.cy.sys.pojo.SysUserMenu;
import com.cy.sys.service.SysMenuService;

@RequestMapping("/")
@Controller
public class PageController {
	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}
	
	@RequestMapping("doIndexUI")
	public String doIndexUI(Model model) {
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
	
	
	@RequestMapping("{module}/{moduleUI}")
	public String doModuleUI(@PathVariable String moduleUI) {
		return "sys/"+moduleUI;
	}
}

