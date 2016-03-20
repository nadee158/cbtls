package com.nadee.cbtls.service;

import java.util.Date;
import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.TrainScheduleSearchDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.model.TrainStationSchedule;

public interface TrainStationScheduleService {
	
	public long countActiveTrainStationSchedules() throws Exception;
	
	public List<TrainStationSchedule> listAllTrainStationSchedule(YesNoStatus yesNoStatus) throws Exception;
	
	public String saveTrainStationSchedule(TrainStationSchedule trainStationSchedule) throws Exception;

	public String deleteTrainSchedule(long trainStationScheduleId) throws Exception;
	
	public TrainStationSchedule fetchTrainStationSchedule(long trainScheduleId,long fromStationId, long toStationId,
			Date arrivalTime,Date depatureTime) throws Exception;

	public List<TrainStationScheduleDTO> serachTrainStationSchedules(TrainScheduleSearchDTO trainScheduleSearchDTO)throws Exception;

	public TrainStationScheduleDTO getTrainStationScheduleById(long trainStationScheduleId)throws Exception;

}
