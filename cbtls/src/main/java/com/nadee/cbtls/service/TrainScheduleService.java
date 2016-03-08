package com.nadee.cbtls.service;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainSchedule;

public interface TrainScheduleService {
	
	public long countActiveTrainSchedules() throws Exception;
	
	public List<TrainSchedule> listAllTrainSchedules(YesNoStatus yesNoStatus) throws Exception;
	
	public String saveTrainSchedule(TrainSchedule trainSchedule) throws Exception;

	public String deleteTrainSchedule(long trainScheduleId) throws Exception;

}
