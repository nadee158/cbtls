package com.nadee.cbtls.dao;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainSchedule;

public interface TrainScheduleDAO {
	
	public long countActiveTrainSchedules() throws Exception;
	
	public List<TrainSchedule> listAllTrainSchedules(YesNoStatus yesNoStatus) throws Exception;

}
