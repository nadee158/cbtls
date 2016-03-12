package com.nadee.cbtls.dao;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainStation;

public interface TrainStationDAO {

	public long countActiveTrainStations() throws Exception;

	public List<TrainStation> listAllTrainStations(YesNoStatus yesNoStatus) throws Exception;

	public TrainStation getTrainStationByName(String stationName)throws Exception;

	public TrainStation getTrainStationByCode(String stationCode)throws Exception;

}
