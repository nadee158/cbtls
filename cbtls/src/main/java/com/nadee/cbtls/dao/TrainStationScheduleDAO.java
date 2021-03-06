package com.nadee.cbtls.dao;

import java.util.Date;
import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.TrainScheduleSearchDTO;
import com.nadee.cbtls.model.TicketPrice;
import com.nadee.cbtls.model.TrainStationSchedule;

public interface TrainStationScheduleDAO {

	public long countActiveTrainStationSchedules() throws Exception;

	public List<TrainStationSchedule> listAllTrainStationSchedule(YesNoStatus yesNoStatus) throws Exception;

	public TrainStationSchedule fetchTrainStationSchedule(long trainScheduleId, long fromStationId, long toStationId,
			Date arrivalTime, Date depatureTime) throws Exception;

	public List<TrainStationSchedule> serachTrainStationSchedules(TrainScheduleSearchDTO trainScheduleSearchDTO)throws Exception;

	public List<TicketPrice> getTicketPrices(long trainStationScheduleId);

}
