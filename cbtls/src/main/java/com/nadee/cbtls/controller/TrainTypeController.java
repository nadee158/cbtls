package com.nadee.cbtls.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainType;
import com.nadee.cbtls.service.TrainTypeService;

@Controller
public class TrainTypeController {

	@Autowired
	private TrainTypeService trainTypeService;

	// Train Types
	// ----------------------------------------------------------------------------------------------
	@RequestMapping(value = "/manageTrainTypes", method = RequestMethod.GET)
	public ModelAndView getManageTrainTypes(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainTypes", trainTypeService.listAllTrainTypes(YesNoStatus.YES));
			modelMap.put("trainType", new TrainType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainTypes", modelMap);
	}

	@RequestMapping(value = "/saveTrainType", method = RequestMethod.POST)
	public ModelAndView saveTrainType(HttpServletRequest request, @ModelAttribute("trainType") TrainType trainType) {
		ModelMap modelMap = new ModelMap();
		try {
			String status = trainTypeService.saveTrainType(trainType);
			modelMap.put("status", status);
			modelMap.put("trainTypes", trainTypeService.listAllTrainTypes(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainTypes", modelMap);
	}

	@RequestMapping(value = "/deleteTrainType", method = RequestMethod.POST)
	public ModelAndView deleteTrainType(HttpServletRequest request, @RequestParam("trainTypeId") long trainTypeId) {
		ModelMap modelMap = new ModelMap();
		try {
			String status = trainTypeService.deleteTrainType(trainTypeId);
			modelMap.put("status", status);
			modelMap.put("trainTypes", trainTypeService.listAllTrainTypes(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainTypes", modelMap);
	}

}
