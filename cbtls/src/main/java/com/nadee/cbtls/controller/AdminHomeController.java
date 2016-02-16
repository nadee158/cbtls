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
import com.nadee.cbtls.service.MasterDataService;
import com.nadee.cbtls.service.SystemUserService;

@Controller
@RequestMapping(value="/admin")
public class AdminHomeController {
	
	@Autowired
	private SystemUserService systemUserService;
	
	@Autowired
	private MasterDataService masterDataService;
	
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		modelMap.put("message", "Hi");		
		
		return new ModelAndView("adminHome", modelMap);
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
	
	@RequestMapping(value = "/masterData", method = RequestMethod.GET)
	public ModelAndView getmasterDataPage(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainLineCount", masterDataService.countActiveTrainLines());
			modelMap.put("trainScheduleCount", masterDataService.countActiveTrainSchedules());
			modelMap.put("trainScheduleTurnCount", masterDataService.countActiveTrainScheduleTurns());
			modelMap.put("trainStationCount", masterDataService.countActiveTrainStations());
			modelMap.put("trainTypeCount", masterDataService.countActiveTrainTypes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("masterData", modelMap);
	}

}
