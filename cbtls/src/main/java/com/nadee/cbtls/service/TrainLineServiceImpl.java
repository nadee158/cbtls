package com.nadee.cbtls.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.TrainLineDAO;
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.model.TrainStation;

@Service("trainLineService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainLineServiceImpl implements TrainLineService {
	
	@Autowired
	private TrainLineDAO  trainLineDAO;
	
	@Autowired
	private CommonDAO commonDAO;


	@Override
	public long countActiveTrainLines() throws Exception {
		return trainLineDAO.countActiveTrainLines();
	}

	@Override
	public List<TrainLine> listAllTrainLines(YesNoStatus yesNoStatus) throws Exception {
		return trainLineDAO.listAllTrainLines(yesNoStatus);
	}

	@Override
	public String saveTrainLine(TrainLine trainLine) throws Exception {
		trainLine.setActiveStatus(YesNoStatus.YES);
		trainLine.setEndStation((TrainStation) commonDAO.getEntityById(TrainStation.class, trainLine.getEndStation().getTrainStationId()));
		trainLine.setStartStation((TrainStation) commonDAO.getEntityById(TrainStation.class, trainLine.getStartStation().getTrainStationId()));
		return commonDAO.saveOrUpdateEntity(trainLine);
	}

	@Override
	public String deleteTrainLine(long trainLineId) throws Exception {
		TrainLine trainLine=commonDAO.getEntityById(TrainLine.class, trainLineId);
		trainLine.setActiveStatus(YesNoStatus.NO);
		return commonDAO.updateEntity(trainLine);
	}

}
