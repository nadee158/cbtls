package com.nadee.cbtls.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.TrainTypeDAO;
import com.nadee.cbtls.model.TrainType;

@Service("trainTypeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainTypeServiceImpl implements TrainTypeService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired
	private TrainTypeDAO trainTypeDAO;

	@Override
	public long countActiveTrainTypes() throws Exception {
		return trainTypeDAO.countActiveTrainTypes();
	}

	@Override
	public List<TrainType> listAllTrainTypes(YesNoStatus yesNoStatus) throws Exception {
		return trainTypeDAO.listAllTrainTypes(yesNoStatus);
	}

	@Override
	public String saveTrainType(TrainType trainType) throws Exception {
		trainType.setActiveStatus(YesNoStatus.YES);
		return commonDAO.saveOrUpdateEntity(trainType);
	}

	@Override
	public String deleteTrainType(long trainTypeId) throws Exception {
		TrainType trainType=commonDAO.getEntityById(TrainType.class, trainTypeId);
		trainType.setActiveStatus(YesNoStatus.NO);
		return commonDAO.updateEntity(trainType);
	}

}
