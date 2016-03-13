package com.nadee.cbtls.dto;

import java.io.Serializable;

public class TrainStationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long trainStationId;

	private GeoLocation geoLocation;

	private String trainStationCode;

	private String trainStationName;

	private String trainStationContactNumber;

	private String activeStatus;

	public long getTrainStationId() {
		return trainStationId;
	}

	public void setTrainStationId(long trainStationId) {
		this.trainStationId = trainStationId;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	public String getTrainStationCode() {
		return trainStationCode;
	}

	public void setTrainStationCode(String trainStationCode) {
		this.trainStationCode = trainStationCode;
	}

	public String getTrainStationName() {
		return trainStationName;
	}

	public void setTrainStationName(String trainStationName) {
		this.trainStationName = trainStationName;
	}

	public String getTrainStationContactNumber() {
		return trainStationContactNumber;
	}

	public void setTrainStationContactNumber(String trainStationContactNumber) {
		this.trainStationContactNumber = trainStationContactNumber;
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
