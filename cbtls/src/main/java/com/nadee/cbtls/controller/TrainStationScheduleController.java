package com.nadee.cbtls.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.dto.TrainScheduleSearchDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.service.TrainStationScheduleService;
import com.nadee.cbtls.util.SessionUtil;

@Controller
public class TrainStationScheduleController {

	
	@Autowired
	private TrainStationScheduleService trainStationScheduleService;

	
	@RequestMapping(value = "/searchTrainSchedules", method = RequestMethod.POST)
	public @ResponseBody List<TrainStationScheduleDTO> searchTrainSchedules(
			@RequestBody TrainScheduleSearchDTO trainScheduleSearchDTO ){
		List<TrainStationScheduleDTO> list=new ArrayList<TrainStationScheduleDTO>();
		try {
			System.out.println("trainScheduleSearchDTO :" + trainScheduleSearchDTO);
			list=trainStationScheduleService.serachTrainStationSchedules(trainScheduleSearchDTO);
			SessionUtil.addToSession("SEARCHED_SCHEDULES", list);
			SessionUtil.addToSession("SEARCHED_CRITERIA", trainScheduleSearchDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	@RequestMapping(value = "/searchTrain", method = RequestMethod.POST)
	public ModelAndView searchTrain(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		List<TrainStationScheduleDTO> list=SessionUtil.getFromSession("SEARCHED_SCHEDULES");
		TrainScheduleSearchDTO trainScheduleSearchDTO=SessionUtil.getFromSession("SEARCHED_CRITERIA");
		System.out.println("trainScheduleSearchDTO :" + trainScheduleSearchDTO);
		System.out.println("list :" + list);
		modelMap.put("list", list);
		modelMap.put("trainScheduleSearchDTO", trainScheduleSearchDTO);
		return new ModelAndView("trainSheduleList", modelMap);
	}
	
	
	@RequestMapping(value = "/searchTrainScheduleDetails", method = RequestMethod.POST)
	public @ResponseBody TrainStationScheduleDTO searchTrainScheduleDetails(
			@RequestParam("tssid") long tssid ){
		TrainStationScheduleDTO trainStationScheduleDTO=null;
		try {
			
			System.out.println("tssid :" + tssid);
			trainStationScheduleDTO=trainStationScheduleService.getTrainStationScheduleById(tssid);
			SessionUtil.addToSession("SEARCHED_SCHEDULE_DETAIL", trainStationScheduleDTO);
			SessionUtil.addToSession("SEARCHED_SCHEDULE_DETAIL_ID", tssid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainStationScheduleDTO;
	}
	
	@RequestMapping(value = "/viewTrainScheduleDetails", method = RequestMethod.POST)
	public ModelAndView viewTrainScheduleDetails(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		modelMap.put("trainStationScheduleDTO", SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL"));
		modelMap.put("trainStationScheduleId", SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL_ID"));
		return new ModelAndView("viewTrainScheduleDetails", modelMap);
	}

}
