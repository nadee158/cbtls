package com.nadee.cbtls.service;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainLine;

public interface TrainLineService {
	
	public long countActiveTrainLines() throws Exception;
	
	public List<TrainLine> listAllTrainLines(YesNoStatus yesNoStatus) throws Exception;	
	
	public String saveTrainLine(TrainLine trainLine) throws Exception;

	public String deleteTrainLine(long trainLineId) throws Exception;

}
