package com.nadee.cbtls.service;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.TrainStationDTO;
import com.nadee.cbtls.model.TrainStation;

public interface TrainStationService {
	
	public long countActiveTrainStations() throws Exception;
	
	public List<TrainStation> listAllTrainStations(YesNoStatus yesNoStatus) throws Exception;
	
	public String saveTrainStation(TrainStation trainStation) throws Exception;

	public String deleteTrainStation(long trainStationId) throws Exception;

	public List<TrainStationDTO> listAllTrainStationsByTrainLine(YesNoStatus yes,long trainLineId) throws Exception;

	public TrainStation getTrainStationById(long trainStationId);
	
	public TrainStation getTrainStationByName(String stationName)throws Exception;
	
	public TrainStation getTrainStationByCode(String stationCode)throws Exception;

}
