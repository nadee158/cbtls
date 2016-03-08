package com.nadee.cbtls.service;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainStation;

public interface TrainStationService {
	
	public long countActiveTrainStations() throws Exception;
	
	public List<TrainStation> listAllTrainStations(YesNoStatus yesNoStatus) throws Exception;
	
	public String saveTrainStation(TrainStation trainStation) throws Exception;

	public String deleteTrainStation(long trainStationId) throws Exception;

	public List<TrainStation> listAllTrainStationsByTrainLine(YesNoStatus yes,long trainLineId);

}
