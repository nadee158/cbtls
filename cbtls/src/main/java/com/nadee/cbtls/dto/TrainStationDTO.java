package com.nadee.cbtls.dto;

import java.io.Serializable;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainStation;

public class TrainStationDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private long trainStationId;

	private GeoLocationDTO geoLocation;

	private String trainStationCode;

	private String trainStationName;

	private String trainStationContactNumber;

	private YesNoStatus activeStatus;

	public long getTrainStationId() {
		return trainStationId;
	}

	public void setTrainStationId(long trainStationId) {
		this.trainStationId = trainStationId;
	}


	public GeoLocationDTO getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocationDTO geoLocation) {
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

	public YesNoStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(YesNoStatus activeStatus) {
		this.activeStatus = activeStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TrainStationDTO(TrainStation trainStation) {
		super();
		if(!(trainStation==null)){
			this.trainStationId = trainStation.getTrainStationId();
			this.geoLocation = new GeoLocationDTO(trainStation.getGeoLocation());
			this.trainStationCode = trainStation.getTrainStationCode();
			this.trainStationName = trainStation.getTrainStationName();
			this.trainStationContactNumber = trainStation.getTrainStationContactNumber();
			this.activeStatus = trainStation.getActiveStatus();
		}
	}
	
	

}
