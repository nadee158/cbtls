package com.nadee.cbtls.service;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainType;

public interface TrainTypeService {
	
	public long countActiveTrainTypes() throws Exception;
	
	public List<TrainType> listAllTrainTypes(YesNoStatus yesNoStatus) throws Exception;	
	
	public String saveTrainType(TrainType trainType) throws Exception;

	public String deleteTrainType(long trainTypeId) throws Exception;

}
