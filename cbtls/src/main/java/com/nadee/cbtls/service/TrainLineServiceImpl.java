package com.nadee.cbtls.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.TrainLineDAO;
import com.nadee.cbtls.dto.TrainLineDTO;
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
	public List<TrainLineDTO> listAllTrainLines(YesNoStatus yesNoStatus) throws Exception {
		List<TrainLineDTO> lineDTOs=new ArrayList<TrainLineDTO>();
		List<TrainLine> lines=trainLineDAO.listAllTrainLines(yesNoStatus);
		for (TrainLine trainLine : lines) {
			lineDTOs.add(new TrainLineDTO(trainLine));
		}
		return lineDTOs;
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
