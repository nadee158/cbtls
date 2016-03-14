package com.nadee.cbtls.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nadee.cbtls.dto.TrainLineDTO;
import com.nadee.cbtls.masterdata.service.TrainScheduleMasterDataService;

@Controller
public class TrainScheduleController {

	@Autowired
	private TrainScheduleMasterDataService trainScheduleMasterDataService;

	
	@RequestMapping(value = "/trainSchedules", method = RequestMethod.GET)
	public @ResponseBody List<TrainLineDTO> trainSchedules(){
		List<TrainLineDTO> trainLines=new ArrayList<TrainLineDTO>();
		try {
		trainScheduleMasterDataService.saveSchedules(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainLines;
	}
	
	

}
