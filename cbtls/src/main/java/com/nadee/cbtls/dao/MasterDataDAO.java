package com.nadee.cbtls.dao;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.model.TrainType;

public interface MasterDataDAO {
	
	public long countActiveTrainTypes() throws Exception;
	
	public long countActiveTrainLines() throws Exception;
	
	public long countActiveTrainStations() throws Exception;
	
	public long countActiveTrainSchedules() throws Exception;
	
	public long countActiveTrainScheduleTurns() throws Exception;
	
	public List<TrainType> listAllTrainTypes(YesNoStatus yesNoStatus) throws Exception;	
	
	public List<TrainLine> listAllTrainLines(YesNoStatus yesNoStatus) throws Exception;	
	
	public List<TrainStation> listAllTrainStations(YesNoStatus yesNoStatus) throws Exception;
	
	public List<TrainSchedule> listAllTrainSchedules(YesNoStatus yesNoStatus) throws Exception;
	
	public List<TrainScheduleTurn> listAllTrainScheduleTurns(YesNoStatus yesNoStatus) throws Exception;

}
