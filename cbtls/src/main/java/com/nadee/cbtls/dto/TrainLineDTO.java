package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.model.TrainLineStation;

public class TrainLineDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long trainLineId;
	
	private String trainLineName;
	
	private YesNoStatus activeStatus;
	
	private List<TrainLineStationDTO> trainLineStations;
	
	private TrainStationDTO startStation;
	
	private TrainStationDTO endStation;

	public long getTrainLineId() {
		return trainLineId;
	}

	public void setTrainLineId(long trainLineId) {
		this.trainLineId = trainLineId;
	}

	public String getTrainLineName() {
		return trainLineName;
	}

	public void setTrainLineName(String trainLineName) {
		this.trainLineName = trainLineName;
	}

	public YesNoStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(YesNoStatus activeStatus) {
		this.activeStatus = activeStatus;
	}


	public TrainLineDTO(TrainLine trainLine, boolean full) {
		super();
		this.trainLineId = trainLine.getTrainLineId();
		this.trainLineName = trainLine.getTrainLineName();
		this.activeStatus = trainLine.getActiveStatus();
		if(full){
			this.trainLineStations = new ArrayList<TrainLineStationDTO>();
			if(!(trainLine.getTrainLineStations()==null)){
				for (TrainLineStation trainLineStation : trainLine.getTrainLineStations()) {
					trainLineStations.add(new TrainLineStationDTO(trainLineStation));
				}
			}
			this.startStation = new TrainStationDTO(trainLine.getStartStation());
			this.endStation = new TrainStationDTO(trainLine.getEndStation());
		}
		
	}

	public List<TrainLineStationDTO> getTrainLineStations() {
		return trainLineStations;
	}

	public void setTrainLineStations(List<TrainLineStationDTO> trainLineStations) {
		this.trainLineStations = trainLineStations;
	}

	public TrainStationDTO getStartStation() {
		return startStation;
	}

	public void setStartStation(TrainStationDTO startStation) {
		this.startStation = startStation;
	}

	public TrainStationDTO getEndStation() {
		return endStation;
	}

	public void setEndStation(TrainStationDTO endStation) {
		this.endStation = endStation;
	}
	
	

}
