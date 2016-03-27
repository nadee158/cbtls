package com.nadee.cbtls.dao;

import java.util.Date;

import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainStationScheduleTurn;

public interface TrainLocationUpdateDAO {
	
	TrainScheduleTurn fetchTrainScheduleTurn(long trainScheduleId, Date turnDate) throws Exception;

	TrainStationScheduleTurn fetchTrainStationScheduleTurn(long trainScheduleTurnId, long trainStationScheduleId) throws Exception;

	TrainSchedule getTrainScheduleById(long trainScheduleId) throws Exception;

}
