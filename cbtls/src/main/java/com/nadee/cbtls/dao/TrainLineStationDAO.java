package com.nadee.cbtls.dao;

import java.util.List;

import com.nadee.cbtls.model.TrainLineStation;

public interface TrainLineStationDAO {
	
	
	public List<TrainLineStation> listAllTrainLineStationsByTrainLine(long trainLineId) throws Exception;


}
