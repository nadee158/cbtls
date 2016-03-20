package com.nadee.cbtls.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.model.TrainLineStation;

@Service("trainLineStationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainLineStationServiceImpl implements TrainLineStationService {
	
	@Autowired
	private CommonDAO commonDAO;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String saveTrainLineStations(List<TrainLineStation> trainLineStations) {
		String status=ApplicationConstants.SUCCESS;
		for (TrainLineStation trainLineStation : trainLineStations) {
			trainLineStation.setActiveStatus(YesNoStatus.YES);
			long id=commonDAO.createEntity(trainLineStation);
			if((id<=0)){
				status=ApplicationConstants.ERROR;
				break;
			}
		}
		return status;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String updateTrainLineStations(List<TrainLineStation> trainLineStations) {
		String status=ApplicationConstants.SUCCESS;
		for (TrainLineStation trainLineStation : trainLineStations) {
			TrainLineStation trainLineStationFromDb=commonDAO.getEntityById(TrainLineStation.class, trainLineStation.getTrainLineStationId());
			trainLineStationFromDb.setActiveStatus(YesNoStatus.YES);
			trainLineStationFromDb.updateFromTrainLineStation(trainLineStation);
			status=commonDAO.updateEntity(trainLineStationFromDb);
			if(StringUtils.equals(status, ApplicationConstants.ERROR)){
				break;
			}
		}
		return status;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deleteTrainLineStation(long trainLineStationId) {
		TrainLineStation trainLineStation=new TrainLineStation();
		trainLineStation.setTrainLineStationId(trainLineStationId);
		commonDAO.deleteEntity(trainLineStation);
		return ApplicationConstants.SUCCESS;
	}

}
