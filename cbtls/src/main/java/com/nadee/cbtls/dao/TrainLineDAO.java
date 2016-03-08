package com.nadee.cbtls.dao;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainLine;

public interface TrainLineDAO {
	
	public long countActiveTrainLines() throws Exception;
	
	public List<TrainLine> listAllTrainLines(YesNoStatus yesNoStatus) throws Exception;	

}
