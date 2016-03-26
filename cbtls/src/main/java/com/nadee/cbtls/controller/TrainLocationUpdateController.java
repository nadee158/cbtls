package com.nadee.cbtls.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.dto.ActiveTrainLocationUpdateDTO;
import com.nadee.cbtls.dto.PassiveTrainLocationUpdateDTO;
import com.nadee.cbtls.service.TrainLocationUpdateService;
import com.nadee.cbtls.util.SessionUtil;

@Controller
public class TrainLocationUpdateController {
	
	@Autowired
	private TrainLocationUpdateService trainLocationUpdateService;

	@RequestMapping(value = "/getActiveUpdateLocation", method = RequestMethod.POST)
	public ModelAndView getActiveUpdateLocation(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		long tssid=SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL_ID");
		modelMap.put("tssid", tssid);
		return new ModelAndView("activeUpdateLocation", modelMap);
	}
	
	@RequestMapping(value = "/activeUpdateTrainLocation", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> activeUpdateTrainLocation(
			@RequestBody ActiveTrainLocationUpdateDTO activeTrainLocationUpdateDTO ){
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			System.out.println("activeTrainLocationUpdateDTO :" + activeTrainLocationUpdateDTO);
			String result=trainLocationUpdateService.activeUpdateTrainLocation(activeTrainLocationUpdateDTO);
			map.put("RESULT", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/getPassiveUpdateLocation", method = RequestMethod.POST)
	public ModelAndView getPassiveUpdateLocation(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		return new ModelAndView("passiveUpdateLocation", modelMap);
	}
	
	
	@RequestMapping(value = "/passiveUpdateTrainLocation", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> passiveUpdateTrainLocation(
			@RequestBody PassiveTrainLocationUpdateDTO passiveTrainLocationUpdateDTO ){
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			System.out.println("passiveTrainLocationUpdateDTO :" + passiveTrainLocationUpdateDTO);
			String result=trainLocationUpdateService.passiveUpdateTrainLocation(passiveTrainLocationUpdateDTO);
			map.put("RESULT", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
