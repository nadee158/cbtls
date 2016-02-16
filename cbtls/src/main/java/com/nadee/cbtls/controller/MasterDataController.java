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
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.model.TrainType;
import com.nadee.cbtls.service.MasterDataService;

@Controller
@RequestMapping(value="/admin")
public class MasterDataController {
	
	@Autowired
	private MasterDataService masterDataService;
	
	
//Train Types ----------------------------------------------------------------------------------------------	
	@RequestMapping(value = "/manageTrainTypes", method = RequestMethod.GET)
	public ModelAndView getManageTrainTypes(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainTypes", masterDataService.listAllTrainTypes(YesNoStatus.YES));
			modelMap.put("trainType", new TrainType());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ModelAndView("manageTrainTypes", modelMap);
	}
	
	@RequestMapping(value = "/saveTrainType", method = RequestMethod.POST)
	public ModelAndView saveTrainType(HttpServletRequest request, 
			@ModelAttribute("trainType") TrainType trainType) {
		ModelMap modelMap = new ModelMap();
		try {
			String status=masterDataService.saveTrainType(trainType);
			modelMap.put("status", status);
			modelMap.put("trainTypes", masterDataService.listAllTrainTypes(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ModelAndView("manageTrainTypes", modelMap);
	}
	
	@RequestMapping(value = "/deleteTrainType", method = RequestMethod.POST)
	public ModelAndView deleteTrainType(HttpServletRequest request, 
			@RequestParam("trainTypeId") long trainTypeId) {
		ModelMap modelMap = new ModelMap();
		try {
			String status=masterDataService.deleteTrainType(trainTypeId);
			modelMap.put("status", status);
			modelMap.put("trainTypes", masterDataService.listAllTrainTypes(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ModelAndView("manageTrainTypes", modelMap);
	}

//Train Lines ----------------------------------------------------------------------------------------------
	@RequestMapping(value = "/manageTrainLines", method = RequestMethod.GET)
	public ModelAndView getManageTrainLines(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainLines", masterDataService.listAllTrainLines(YesNoStatus.YES));
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
			modelMap.put("trainLine", new TrainLine());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ModelAndView("manageTrainLines", modelMap);
	}
	
	@RequestMapping(value = "/saveTrainLine", method = RequestMethod.POST)
	public ModelAndView saveTrainLine(HttpServletRequest request, 
			@ModelAttribute("trainLine") TrainLine trainLine) {
		ModelMap modelMap = new ModelMap();
		try {
			String status=masterDataService.saveTrainLine(trainLine);
			modelMap.put("status", status);
			modelMap.put("trainLine", new TrainLine());
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
			modelMap.put("trainLines", masterDataService.listAllTrainLines(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ModelAndView("manageTrainLines", modelMap);
	}
	
	@RequestMapping(value = "/deleteTrainLine", method = RequestMethod.POST)
	public ModelAndView deleteTrainLine(HttpServletRequest request, 
			@RequestParam("trainLineId") long trainLineId) {
		ModelMap modelMap = new ModelMap();
		try {
			String status=masterDataService.deleteTrainLine(trainLineId);
			modelMap.put("status", status);
			modelMap.put("trainLine", new TrainLine());
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
			modelMap.put("trainLines", masterDataService.listAllTrainLines(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ModelAndView("manageTrainLines", modelMap);
	}
	
//Train Stations ----------------------------------------------------------------------------------------------		
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
