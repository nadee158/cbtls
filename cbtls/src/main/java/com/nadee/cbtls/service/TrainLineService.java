package com.nadee.cbtls.service;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.TrainLineDTO;
import com.nadee.cbtls.model.TrainLine;

public interface TrainLineService {
	
	public long countActiveTrainLines() throws Exception;
	
	public List<TrainLineDTO> listAllTrainLines(YesNoStatus yesNoStatus, boolean isFullDto) throws Exception;	
	
	public String saveTrainLine(TrainLine trainLine) throws Exception;

	public String deleteTrainLine(long trainLineId) throws Exception;

	public TrainLine getTrainLineByTrainLineIntegrationId(int trainLineIntegrationId);

}
