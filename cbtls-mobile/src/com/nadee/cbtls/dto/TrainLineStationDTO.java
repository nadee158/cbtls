package com.nadee.cbtls.dto;

import java.io.Serializable;

public class TrainLineStationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long trainLineStationId;

	private double distanceFromStartStation;

	private double distanceFromEndStation;

	private String activeStatus;

	private TrainStationDTO trainStation;

	private TrainStationDTO nextStation;

	private double distanceToNextStation;

	private TrainStationDTO previousStation;

	private double distanceToPreviousStation;

	private int versionId;

	public long getTrainLineStationId() {
		return trainLineStationId;
	}

	public void setTrainLineStationId(long trainLineStationId) {
		this.trainLineStationId = trainLineStationId;
	}

	public double getDistanceFromStartStation() {
		return distanceFromStartStation;
	}

	public void setDistanceFromStartStation(double distanceFromStartStation) {
		this.distanceFromStartStation = distanceFromStartStation;
	}

	public double getDistanceFromEndStation() {
		return distanceFromEndStation;
	}

	public void setDistanceFromEndStation(double distanceFromEndStation) {
		this.distanceFromEndStation = distanceFromEndStation;
	}

	public TrainStationDTO getTrainStation() {
		return trainStation;
	}

	public void setTrainStation(TrainStationDTO trainStation) {
		this.trainStation = trainStation;
	}

	public TrainStationDTO getNextStation() {
		return nextStation;
	}

	public void setNextStation(TrainStationDTO nextStation) {
		this.nextStation = nextStation;
	}

	public double getDistanceToNextStation() {
		return distanceToNextStation;
	}

	public void setDistanceToNextStation(double distanceToNextStation) {
		this.distanceToNextStation = distanceToNextStation;
	}

	public TrainStationDTO getPreviousStation() {
		return previousStation;
	}

	public void setPreviousStation(TrainStationDTO previousStation) {
		this.previousStation = previousStation;
	}

	public double getDistanceToPreviousStation() {
		return distanceToPreviousStation;
	}

	public void setDistanceToPreviousStation(double distanceToPreviousStation) {
		this.distanceToPreviousStation = distanceToPreviousStation;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

}
