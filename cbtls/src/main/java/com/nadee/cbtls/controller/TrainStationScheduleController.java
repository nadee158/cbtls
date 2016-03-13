package com.nadee.cbtls.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nadee.cbtls.dto.TrainScheduleSearchDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.service.TrainStationScheduleService;

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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
