package com.nadee.cbtls.dao;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.TrainFrequency;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainSchedule;

public interface TrainScheduleDAO {
	
	public long countActiveTrainSchedules() throws Exception;
	
	public List<TrainSchedule> listAllTrainSchedules(YesNoStatus yesNoStatus) throws Exception;
	
	public TrainSchedule fetchTrainSchedule(String trainNumber,TrainFrequency trainFrequency, String startStationName,
			String endStationName, String trainType) throws Exception;

}
