package com.nadee.cbtls.dto;

import java.io.Serializable;

public class TrainScheduleDTO implements Serializable {

	public static final String MONDAY_TO_FRIDAY = "MONDAY TO FRIDAY";
	public static final String SUNDAYS_AND_HOLIDAYS = "SUNDAYS AND HOLIDAYS";
	public static final String SATURDAY_AND_SUNDAY = "SATURDAY AND SUNDAY";
	public static final String DAILY = "DAILY";

	private static final long serialVersionUID = 1L;

	private long trainScheduleId;

	private String trainFrequency;

	private String trainName;

	private String trainNumber;

	private TrainStationDTO startStation;

	private TrainStationDTO endStation;

	private String trainType;

	public TrainScheduleDTO() {
		super();
	}

	public TrainScheduleDTO(long trainScheduleId, String trainFrequency,
			String trainName, String trainNumber, TrainStationDTO startStation,
			TrainStationDTO endStation, String trainType) {
		super();
		this.trainScheduleId = trainScheduleId;
		this.trainFrequency = trainFrequency;
		this.trainName = trainName;
		this.trainNumber = trainNumber;
		this.startStation = startStation;
		this.endStation = endStation;
		this.trainType = trainType;
	}

	public long getTrainScheduleId() {
		return trainScheduleId;
	}

	public void setTrainScheduleId(long trainScheduleId) {
		this.trainScheduleId = trainScheduleId;
	}

	public String getTrainFrequency() {
		return trainFrequency;
	}

	public void setTrainFrequency(String trainFrequency) {
		this.trainFrequency = trainFrequency;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
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

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

}