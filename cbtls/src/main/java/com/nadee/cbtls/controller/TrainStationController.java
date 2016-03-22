package com.nadee.cbtls.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.TrainStationDTO;
import com.nadee.cbtls.initbinder.GeoLocationEditor;
import com.nadee.cbtls.model.GeoLocation;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.service.TrainStationService;

@Controller
public class TrainStationController {

	@Autowired
	private TrainStationService trainStationService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(GeoLocation.class, new GeoLocationEditor(trainStationService));
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}

	// Train Stations
	// ----------------------------------------------------------------------------------------------
	@RequestMapping(value = "/admin/manageTrainStations", method = RequestMethod.GET)
	public ModelAndView getManageTrainStations(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainStations", trainStationService.listAllTrainStations(YesNoStatus.YES));
			modelMap.put("trainStation", new TrainStation());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainStations", modelMap);
	}
	
	@RequestMapping(value = "/admin/getEditTrainStation", method = RequestMethod.GET)
	public ModelAndView getEditTrainStation(HttpServletRequest request, @RequestParam("id") long trainStationId) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainStations", trainStationService.listAllTrainStations(YesNoStatus.YES));
			modelMap.put("trainStation", new TrainStation());
			modelMap.put("trainStationEdit", trainStationService.getTrainStationById(trainStationId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainStations", modelMap);
	}
	
	

	@RequestMapping(value = "/admin/saveTrainStation", method = RequestMethod.POST)
	public ModelAndView saveTrainStation(HttpServletRequest request,
			@ModelAttribute("trainStation") TrainStation trainStation) {
		ModelMap modelMap = new ModelMap();
		try {
			String status = trainStationService.saveTrainStation(trainStation);
			modelMap.put("status", status);
			modelMap.put("trainStations", trainStationService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainStations", modelMap);
	}
	
	@RequestMapping(value = "/admin/updateTrainStation", method = RequestMethod.POST)
	public ModelAndView updateTrainStation(HttpServletRequest request,
			@ModelAttribute("trainStation") TrainStation trainStation) {
		ModelMap modelMap = new ModelMap();
		try {
			String status = trainStationService.updateTrainStation(trainStation);
			modelMap.put("status", status);
			modelMap.put("trainStations", trainStationService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainStations", modelMap);
	}

	@RequestMapping(value = "/admin/deleteTrainStation", method = RequestMethod.POST)
	public ModelAndView deleteTrainStation(HttpServletRequest request,
			@RequestParam("trainStationId") long trainStationId) {
		ModelMap modelMap = new ModelMap();
		try {
			String status = trainStationService.deleteTrainStation(trainStationId);
			modelMap.put("status", status);
			modelMap.put("trainStations", trainStationService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainStations", modelMap);
	}
	
	
	@RequestMapping(value = "/listTrainStationsByTrainLine", method = RequestMethod.GET)
	public @ResponseBody List<TrainStationDTO> listAllTrainStationsByTrainLine(@RequestParam("trainLineId") long trainLineId){
		List<TrainStationDTO> trainStations=new ArrayList<TrainStationDTO>();
		try {
			trainStations=trainStationService.listAllTrainStationsByTrainLine(YesNoStatus.YES, trainLineId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainStations;
	}

}
