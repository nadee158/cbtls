package com.nadee.cbtls.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.constant.GeneralEnumConstants.UserRoleType;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.service.SystemUserService;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private SystemUserService systemUserService;
	
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public ModelAndView getRegisterUserPage(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		modelMap.put("systemUser", new SystemUser());
		return new ModelAndView("registerUser", modelMap);
	}
	
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request, @ModelAttribute("systemUser") SystemUser systemUser) {
		ModelMap modelMap = new ModelMap();
		systemUserService.saveSystemUser(systemUser, UserRoleType.ROLE_USER);
		modelMap.put("systemUser", systemUser);
		return new ModelAndView("registerUser", modelMap);
	}
	
	@RequestMapping(value = "/registerAdmin", method = RequestMethod.GET)
	public ModelAndView getRegisterAdminPage(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		modelMap.put("systemUser", new SystemUser());
		return new ModelAndView("registerAdmin", modelMap);
	}
	
	
	@RequestMapping(value = "/registerAdmin", method = RequestMethod.POST)
	public ModelAndView registerAdmin(HttpServletRequest request, @ModelAttribute("systemUser") SystemUser systemUser) {
		ModelMap modelMap = new ModelMap();
		systemUserService.saveSystemUser(systemUser, UserRoleType.ROLE_ADMIN);
		modelMap.put("systemUser", systemUser);
		return new ModelAndView("registerAdmin", modelMap);
	}

}
