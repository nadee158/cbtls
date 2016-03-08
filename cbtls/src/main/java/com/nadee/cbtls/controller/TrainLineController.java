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
import com.nadee.cbtls.initbinder.TrainStationEditor;
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.service.TrainLineService;
import com.nadee.cbtls.service.TrainStationService;

@Controller
public class TrainLineController {

	@Autowired
	private TrainLineService trainLineService;
	
	@Autowired
	private TrainStationService trainStationService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(TrainStation.class, new TrainStationEditor(trainStationService));
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
	
	// Train Lines
	// ----------------------------------------------------------------------------------------------
	@RequestMapping(value = "/admin/manageTrainLines", method = RequestMethod.GET)
	public ModelAndView getManageTrainLines(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainLines", trainLineService.listAllTrainLines(YesNoStatus.YES));
			modelMap.put("trainStations", trainStationService.listAllTrainStations(YesNoStatus.YES));
			modelMap.put("trainLine", new TrainLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainLines", modelMap);
	}

	@RequestMapping(value = "/admin/saveTrainLine", method = RequestMethod.POST)
	public ModelAndView saveTrainLine(HttpServletRequest request, @ModelAttribute("trainLine") TrainLine trainLine) {
		ModelMap modelMap = new ModelMap();
		try {
			String status = trainLineService.saveTrainLine(trainLine);
			modelMap.put("status", status);
			modelMap.put("trainLine", new TrainLine());
			modelMap.put("trainStations", trainStationService.listAllTrainStations(YesNoStatus.YES));
			modelMap.put("trainLines", trainLineService.listAllTrainLines(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainLines", modelMap);
	}

	@RequestMapping(value = "/admin/deleteTrainLine", method = RequestMethod.POST)
	public ModelAndView deleteTrainLine(HttpServletRequest request, @RequestParam("trainLineId") long trainLineId) {
		ModelMap modelMap = new ModelMap();
		try {
			String status = trainLineService.deleteTrainLine(trainLineId);
			modelMap.put("status", status);
			modelMap.put("trainLine", new TrainLine());
			modelMap.put("trainStations", trainStationService.listAllTrainStations(YesNoStatus.YES));
			modelMap.put("trainLines", trainLineService.listAllTrainLines(YesNoStatus.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("manageTrainLines", modelMap);
	}
	
	@RequestMapping(value = "/listTrainLines", method = RequestMethod.GET)
	public @ResponseBody List<TrainLine> listAllTrainLines(){
		List<TrainLine> trainLines=new ArrayList<TrainLine>();
		try {
			trainLines=trainLineService.listAllTrainLines(YesNoStatus.YES);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainLines;
	}

}
