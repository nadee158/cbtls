package com.nadee.cbtls.service;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainScheduleTurn;

public interface TrainScheduleTurnService {
	
	public long countActiveTrainScheduleTurns() throws Exception;
	
	public List<TrainScheduleTurn> listAllTrainScheduleTurns(YesNoStatus yesNoStatus) throws Exception;
	
	public String saveTrainScheduleTurn(TrainScheduleTurn trainScheduleTurn) throws Exception;

	public String deleteTrainScheduleTurn(long trainScheduleTurnId) throws Exception;

}
