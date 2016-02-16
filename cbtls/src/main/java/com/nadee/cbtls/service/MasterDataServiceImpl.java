package com.nadee.cbtls.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.MasterDataDAO;
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.model.TrainType;

@Service("masterDataService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MasterDataServiceImpl implements MasterDataService {
	
	@Autowired
	private MasterDataDAO  masterDataDAO;
	
	@Autowired
	private CommonDAO commonDAO;

	@Override
	public long countActiveTrainTypes() throws Exception {
		return masterDataDAO.countActiveTrainTypes();
	}

	@Override
	public long countActiveTrainLines() throws Exception {
		return masterDataDAO.countActiveTrainLines();
	}

	@Override
	public long countActiveTrainStations() throws Exception {
		return masterDataDAO.countActiveTrainStations();
	}

	@Override
	public long countActiveTrainSchedules() throws Exception {
		return masterDataDAO.countActiveTrainSchedules();
	}

	@Override
	public long countActiveTrainScheduleTurns() throws Exception {
		return masterDataDAO.countActiveTrainScheduleTurns();
	}

	@Override
	public List<TrainStation> listAllTrainStations(YesNoStatus yesNoStatus) throws Exception {
		return masterDataDAO.listAllTrainStations(yesNoStatus);
	}

	@Override
	public List<TrainType> listAllTrainTypes(YesNoStatus yesNoStatus) throws Exception {
		return masterDataDAO.listAllTrainTypes(yesNoStatus);
	}

	@Override
	public List<TrainLine> listAllTrainLines(YesNoStatus yesNoStatus) throws Exception {
		return masterDataDAO.listAllTrainLines(yesNoStatus);
	}

	@Override
	public List<TrainSchedule> listAllTrainSchedules(YesNoStatus yesNoStatus) throws Exception {
		return masterDataDAO.listAllTrainSchedules(yesNoStatus);
	}

	@Override
	public List<TrainScheduleTurn> listAllTrainScheduleTurns(YesNoStatus yesNoStatus) throws Exception {
		return masterDataDAO.listAllTrainScheduleTurns(yesNoStatus);
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
	
	

}
