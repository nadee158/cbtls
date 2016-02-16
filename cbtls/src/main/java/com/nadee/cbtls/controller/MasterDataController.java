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
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.service.MasterDataService;

@Controller
@RequestMapping(value="/admin")
public class MasterDataController {
	
	@Autowired
	private MasterDataService masterDataService;
	
	
	@RequestMapping(value = "/manageTrainStations", method = RequestMethod.GET)
	public ModelAndView getManageTrainStations(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
			modelMap.put("trainStation", new TrainStation());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ModelAndView("manageTrainStations", modelMap);
	}
	
	
	@RequestMapping(value = "/saveTrainStation", method = RequestMethod.POST)
	public ModelAndView saveTrainStation(HttpServletRequest request, 
			@ModelAttribute("trainStation") TrainStation trainStation) {
		ModelMap modelMap = new ModelMap();
		try {
			String status=masterDataService.saveTrainStation(trainStation);
			modelMap.put("status", status);
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ModelAndView("manageTrainStations", modelMap);
	}
	
	@RequestMapping(value = "/deleteTrainStation", method = RequestMethod.POST)
	public ModelAndView deleteTrainStation(HttpServletRequest request, 
			@RequestParam("trainStationId") long trainStationId) {
		ModelMap modelMap = new ModelMap();
		try {
			String status=masterDataService.deleteTrainStation(trainStationId);
			modelMap.put("status", status);
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ModelAndView("manageTrainStations", modelMap);
	}
	

}
