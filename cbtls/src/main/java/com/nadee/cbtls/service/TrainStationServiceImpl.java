package com.nadee.cbtls.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.TrainLineStationDAO;
import com.nadee.cbtls.dao.TrainStationDAO;
import com.nadee.cbtls.dto.TrainStationDTO;
import com.nadee.cbtls.model.GeoLocation;
import com.nadee.cbtls.model.TrainLineStation;
import com.nadee.cbtls.model.TrainStation;

@Service("trainStationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainStationServiceImpl implements TrainStationService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired
	private TrainStationDAO trainStationDAO;
	
	@Autowired
	private TrainLineStationDAO trainLineStationDAO;
	
	@Override
	public long countActiveTrainStations() throws Exception {
		return trainStationDAO.countActiveTrainStations();
	}

	@Override
	public List<TrainStation> listAllTrainStations(YesNoStatus yesNoStatus) throws Exception {
		List<TrainStation> trainStations=new ArrayList<TrainStation>();
		List<TrainLineStation> trainLineStations=trainLineStationDAO.listAllTrainLineStationsByTrainLine(3);
		if(!(trainLineStations==null)){
			for (TrainLineStation trainLineStation : trainLineStations) {
				trainStations.add(trainLineStation.getTrainStation());
			}
		}
		//return trainStationDAO.listAllTrainStations(yesNoStatus);
		return trainStations;
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
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TrainStationDTO> listAllTrainStationsByTrainLine(YesNoStatus yes, long trainLineId) throws Exception {
		List<TrainStationDTO> trainStations=new ArrayList<TrainStationDTO>();
		List<TrainLineStation> trainLineStations=trainLineStationDAO.listAllTrainLineStationsByTrainLine(trainLineId);
		if(!(trainLineStations==null)){
			for (TrainLineStation trainLineStation : trainLineStations) {
				trainStations.add(new TrainStationDTO(trainLineStation.getTrainStation()));
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
	
	@Override
	public String updateTrainStation(TrainStation trainStation) throws Exception {
		String status=ApplicationConstants.ERROR;
		TrainStation trainStationFromDB=commonDAO.getEntityById(TrainStation.class, trainStation.getTrainStationId());
		trainStationFromDB.updateFromTrainStation(trainStation);
		status=commonDAO.updateEntity(trainStationFromDB);
		return status;
	}
	
	@Override
	public GeoLocation getGeoLocationById(long geoLocationId) throws Exception {
		return commonDAO.getEntityById(GeoLocation.class, geoLocationId);
	}


}
