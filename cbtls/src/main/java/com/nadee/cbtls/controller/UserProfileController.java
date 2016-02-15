package com.nadee.cbtls.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.service.SystemUserService;

@Controller
@RequestMapping(value="/user")
public class UserProfileController {
	
	@Autowired
	private SystemUserService systemUserService;
	
	
	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public ModelAndView getRegisterUserPage(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		modelMap.put("systemUser", new SystemUser());
		return new ModelAndView("userProfile", modelMap);
	}
	
	
	@RequestMapping(value = "/updateUserProfile", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request, @ModelAttribute("systemUser") SystemUser systemUser) {
		ModelMap modelMap = new ModelMap();
		systemUserService.updateSystemUser(systemUser);
		modelMap.put("systemUser", systemUser);
		return new ModelAndView("userProfile", modelMap);
	}
	
	

}
