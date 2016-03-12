package com.nadee.cbtls.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.TrainStationDAO;
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.model.TrainLineStation;
import com.nadee.cbtls.model.TrainStation;

@Service("trainStationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainStationServiceImpl implements TrainStationService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired
	private TrainStationDAO trainStationDAO;
	
	@Override
	public long countActiveTrainStations() throws Exception {
		return trainStationDAO.countActiveTrainStations();
	}

	@Override
	public List<TrainStation> listAllTrainStations(YesNoStatus yesNoStatus) throws Exception {
		return trainStationDAO.listAllTrainStations(yesNoStatus);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String saveTrainStation(TrainStation trainStation) throws Exception {
		trainStation.setActiveStatus(YesNoStatus.YES);
		return commonDAO.saveOrUpdateEntity(trainStation);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deleteTrainStation(long trainStationId) throws Exception {
		TrainStation trainStation=commonDAO.getEntityById(TrainStation.class, trainStationId);
		trainStation.setActiveStatus(YesNoStatus.NO);
		return commonDAO.updateEntity(trainStation);
	}

	@Override
	public List<TrainStation> listAllTrainStationsByTrainLine(YesNoStatus yes, long trainLineId) {
		List<TrainStation> trainStations=new ArrayList<TrainStation>();
		TrainLine trainLine=commonDAO.getEntityById(TrainLine.class, trainLineId);
		if(!(trainLine==null)){
			for (TrainLineStation trainLineStation : trainLine.getTrainLineStations()) {
				trainStations.add(trainLineStation.getTrainStation());
			}
		}
		return trainStations;
	}

	@Override
	public TrainStation getTrainStationById(long trainStationId) {
		return commonDAO.getEntityById(TrainStation.class, trainStationId);
	}

	@Override
	public TrainStation getTrainStationByName(String stationName) throws Exception {
		return trainStationDAO.getTrainStationByName(stationName);
	}

	@Override
	public TrainStation getTrainStationByCode(String stationCode) throws Exception {
		return trainStationDAO.getTrainStationByCode(stationCode);
	}


}
