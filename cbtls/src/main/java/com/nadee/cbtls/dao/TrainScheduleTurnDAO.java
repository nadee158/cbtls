package com.nadee.cbtls.dao;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainScheduleTurn;

public interface TrainScheduleTurnDAO {
	
	public long countActiveTrainScheduleTurns() throws Exception;
	
	public List<TrainScheduleTurn> listAllTrainScheduleTurns(YesNoStatus yesNoStatus) throws Exception;

}
