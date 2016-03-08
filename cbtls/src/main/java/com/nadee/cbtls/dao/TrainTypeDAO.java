package com.nadee.cbtls.dao;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainType;

public interface TrainTypeDAO {
	
	public long countActiveTrainTypes() throws Exception;
	
	public List<TrainType> listAllTrainTypes(YesNoStatus yesNoStatus) throws Exception;	

}
