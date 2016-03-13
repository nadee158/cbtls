package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.List;

public class TrainLineDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long trainLineId;

	private String trainLineName;

	private String activeStatus;

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

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

}
