package com.nadee.cbtls.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.TrainScheduleTurnDAO;
import com.nadee.cbtls.model.TrainScheduleTurn;

@Service("trainScheduleTurnService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainScheduleTurnServiceImpl implements TrainScheduleTurnService{
	
	@Autowired
	private TrainScheduleTurnDAO trainScheduleTurnDAO;

	@Override
	public long countActiveTrainScheduleTurns() throws Exception {
		return trainScheduleTurnDAO.countActiveTrainScheduleTurns();
	}

	@Override
	public List<TrainScheduleTurn> listAllTrainScheduleTurns(YesNoStatus yesNoStatus) throws Exception {
		return trainScheduleTurnDAO.listAllTrainScheduleTurns(yesNoStatus);
	}

	@Override
	public String saveTrainScheduleTurn(TrainScheduleTurn trainScheduleTurn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTrainScheduleTurn(long trainScheduleTurnId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
