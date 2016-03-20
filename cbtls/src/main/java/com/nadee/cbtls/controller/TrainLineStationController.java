package com.nadee.cbtls.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.initbinder.TrainLineEditor;
import com.nadee.cbtls.initbinder.TrainStationEditor;
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.model.TrainLineStation;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.service.TrainLineService;
import com.nadee.cbtls.service.TrainLineStationService;
import com.nadee.cbtls.service.TrainStationService;

@Controller
public class TrainLineStationController {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(TrainStation.class, new TrainStationEditor(trainStationService));
		binder.registerCustomEditor(TrainLine.class, new TrainLineEditor(trainLineService));
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}

	@Autowired
	private TrainStationService trainStationService;

	@Autowired
	private TrainLineService trainLineService;

	@Autowired
	private TrainLineStationService trainLineStationService;

	// Train Stations
	// ----------------------------------------------------------------------------------------------
	@RequestMapping(value = "/admin/manageTrainLineStations", method = RequestMethod.GET)
	public ModelAndView getManageTrainStations(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainLineStations", trainStationService.listAllTrainStationsByTrainLine(YesNoStatus.YES, 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainLineStations", modelMap);
	}

	@RequestMapping(value = "/admin/saveTrainLineStation", method = RequestMethod.POST)
	public ModelAndView saveTrainStation(HttpServletRequest request,
			@ModelAttribute("trainLineStations") List<TrainLineStation> trainLineStations) {
		ModelMap modelMap = new ModelMap();
		try {
			String status = trainLineStationService.saveTrainLineStations(trainLineStations);
			modelMap.put("status", status);
			modelMap.put("trainLineStations", trainStationService.listAllTrainStationsByTrainLine(YesNoStatus.YES, 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainLineStations", modelMap);
	}

	@RequestMapping(value = "/admin/updateTrainLineStation", method = RequestMethod.POST)
	public ModelAndView updateTrainLineStation(HttpServletRequest request,
			@ModelAttribute("trainLineStations") List<TrainLineStation> trainLineStations) {
		ModelMap modelMap = new ModelMap();
		try {
			String status = trainLineStationService.updateTrainLineStations(trainLineStations);
			modelMap.put("status", status);
			modelMap.put("trainLineStations", trainStationService.listAllTrainStationsByTrainLine(YesNoStatus.YES, 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainLineStations", modelMap);
	}

	@RequestMapping(value = "/admin/deleteTrainLineStation", method = RequestMethod.POST)
	public ModelAndView deleteTrainStation(HttpServletRequest request,
			@RequestParam("trainLineStationId") long trainLineStationId) {
		ModelMap modelMap = new ModelMap();
		try {
			String status = trainLineStationService.deleteTrainLineStation(trainLineStationId);
			modelMap.put("status", status);
			modelMap.put("trainLineStations", trainStationService.listAllTrainStationsByTrainLine(YesNoStatus.YES, 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainLineStations", modelMap);
	}

}
