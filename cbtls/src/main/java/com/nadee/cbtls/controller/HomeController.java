package com.nadee.cbtls.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.TrainSearchDTO;
import com.nadee.cbtls.service.MasterDataService;

@Controller
public class HomeController {
	
	@Autowired
	private MasterDataService masterDataService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		modelMap.put("message", "Hi");	
		modelMap.put("trainSearchDTO", new TrainSearchDTO());
		try {
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("home", modelMap);
	}
	
	@RequestMapping(value = "/searchTrain", method = RequestMethod.POST)
	public ModelAndView searchTrain(HttpServletRequest request, @ModelAttribute("trainSearchDTO") TrainSearchDTO trainSearchDTO) {
		ModelMap modelMap = new ModelMap();
		System.out.println(trainSearchDTO.getStartDate());
		request.getSession().setAttribute("trainSearchDTO", trainSearchDTO);
		modelMap.put("trainSearchDTO", trainSearchDTO);
		return new ModelAndView("trainSheduleList", modelMap);
	}
	
	@RequestMapping(value = "/searchTrainAdvanced", method = RequestMethod.POST)
	public ModelAndView searchTrainAdvanced(HttpServletRequest request, @ModelAttribute("trainSearchDTO") TrainSearchDTO trainSearchDTO) {
		ModelMap modelMap = new ModelMap();
		System.out.println(trainSearchDTO.getStartDate());
		request.getSession().setAttribute("trainSearchDTO", trainSearchDTO);
		modelMap.put("trainSearchDTO", trainSearchDTO);
		return new ModelAndView("trainSheduleList", modelMap);
	}
	
	@RequestMapping(value = "/viewRecommendations", method = RequestMethod.POST)
	public ModelAndView viewRecommendations(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		TrainSearchDTO trainSearchDTO  = (TrainSearchDTO) request.getSession().getAttribute("trainSearchDTO");
		System.out.println(trainSearchDTO.getStartDate());
		modelMap.put("trainSearchDTO", trainSearchDTO);
		return new ModelAndView("viewRecommendations", modelMap);
	}
	
	
	@RequestMapping(value = "/viewTrainScheduleDetails", method = RequestMethod.POST)
	public ModelAndView viewTrainScheduleDetails(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		TrainSearchDTO trainSearchDTO  = (TrainSearchDTO) request.getSession().getAttribute("trainSearchDTO");
		System.out.println(trainSearchDTO.getStartDate());
		modelMap.put("trainSearchDTO", trainSearchDTO);
		return new ModelAndView("viewTrainScheduleDetails", modelMap);
	}
	
	@RequestMapping(value = "/activeUpdateLocation", method = RequestMethod.POST)
	public ModelAndView activeUpdateLocation(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TrainSearchDTO trainSearchDTO  = (TrainSearchDTO) request.getSession().getAttribute("trainSearchDTO");
		System.out.println(trainSearchDTO.getStartDate());
		modelMap.put("trainSearchDTO", trainSearchDTO);
		return new ModelAndView("activeUpdateLocation", modelMap);
	}
	
	@RequestMapping(value = "/passiveUpdateLocation", method = RequestMethod.POST)
	public ModelAndView passiveUpdateLocation(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TrainSearchDTO trainSearchDTO  = (TrainSearchDTO) request.getSession().getAttribute("trainSearchDTO");
		System.out.println(trainSearchDTO.getStartDate());
		modelMap.put("trainSearchDTO", trainSearchDTO);
		return new ModelAndView("passiveUpdateLocation", modelMap);
	}
	
	
	@RequestMapping(value = "/viewAnalysisOfTrain", method = RequestMethod.POST)
	public ModelAndView viewAnalysisOfTrain(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TrainSearchDTO trainSearchDTO  = (TrainSearchDTO) request.getSession().getAttribute("trainSearchDTO");
		System.out.println(trainSearchDTO.getStartDate());
		modelMap.put("trainSearchDTO", trainSearchDTO);
		return new ModelAndView("viewAnalysisOfTrain", modelMap);
	}
	
	@RequestMapping(value = "/updateCompartmentDetails", method = RequestMethod.POST)
	public ModelAndView updateCompartmentDetails(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TrainSearchDTO trainSearchDTO  = (TrainSearchDTO) request.getSession().getAttribute("trainSearchDTO");
		System.out.println(trainSearchDTO.getStartDate());
		modelMap.put("trainSearchDTO", trainSearchDTO);
		return new ModelAndView("updateCompartmentDetails", modelMap);
	}
	
	@RequestMapping(value = "/setNotificationAlarm", method = RequestMethod.POST)
	public ModelAndView setNotificationAlarm(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TrainSearchDTO trainSearchDTO  = (TrainSearchDTO) request.getSession().getAttribute("trainSearchDTO");
		System.out.println(trainSearchDTO.getStartDate());
		modelMap.put("trainSearchDTO", trainSearchDTO);
		return new ModelAndView("setNotificationAlarm", modelMap);
	}
	
	@RequestMapping(value = "/viewTrainLocation", method = RequestMethod.POST)
	public ModelAndView viewTrainLocation(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TrainSearchDTO trainSearchDTO  = (TrainSearchDTO) request.getSession().getAttribute("trainSearchDTO");
		System.out.println(trainSearchDTO.getStartDate());
		modelMap.put("trainSearchDTO", trainSearchDTO);
		return new ModelAndView("viewTrainLocation", modelMap);
	}
	
	@RequestMapping(value = "/viewCompartmentDetails", method = RequestMethod.POST)
	public ModelAndView viewCompartmentDetails(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		try {
			modelMap.put("trainStations", masterDataService.listAllTrainStations(YesNoStatus.YES));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TrainSearchDTO trainSearchDTO  = (TrainSearchDTO) request.getSession().getAttribute("trainSearchDTO");
		System.out.println(trainSearchDTO.getStartDate());
		modelMap.put("trainSearchDTO", trainSearchDTO);
		return new ModelAndView("viewCompartmentDetails", modelMap);
	}
	
	

}
