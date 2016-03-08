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
import com.nadee.cbtls.service.TrainLineService;
import com.nadee.cbtls.service.TrainScheduleService;
import com.nadee.cbtls.service.TrainScheduleTurnService;
import com.nadee.cbtls.service.TrainStationService;
import com.nadee.cbtls.service.TrainTypeService;

@Controller
@RequestMapping(value="/admin")
public class AdminHomeController {
	
	@Autowired
	private SystemUserService systemUserService;
	
	@Autowired
	private TrainLineService trainLineService;
	
	@Autowired
	private TrainScheduleService trainScheduleService;
	
	@Autowired
	private TrainScheduleTurnService trainScheduleTurnService;
	
	@Autowired
	private TrainStationService trainStationService;
	
	@Autowired
	private TrainTypeService trainTypeService;
	
	
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
			modelMap.put("trainLineCount", trainLineService.countActiveTrainLines());
			modelMap.put("trainScheduleCount", trainScheduleService.countActiveTrainSchedules());
			modelMap.put("trainScheduleTurnCount", trainScheduleTurnService.countActiveTrainScheduleTurns());
			modelMap.put("trainStationCount", trainStationService.countActiveTrainStations());
			modelMap.put("trainTypeCount", trainTypeService.countActiveTrainTypes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("masterData", modelMap);
	}

}
