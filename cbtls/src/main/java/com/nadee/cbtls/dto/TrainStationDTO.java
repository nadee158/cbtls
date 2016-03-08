package com.nadee.cbtls.dto;

import java.io.Serializable;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.GeoLocation;
import com.nadee.cbtls.model.TrainStation;

public class TrainStationDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private long trainStationId;

	private String trainStationReferenceId;

	private GeoLocation geoLocation;

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

	public String getTrainStationReferenceId() {
		return trainStationReferenceId;
	}

	public void setTrainStationReferenceId(String trainStationReferenceId) {
		this.trainStationReferenceId = trainStationReferenceId;
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
		this.trainStationId = trainStation.getTrainStationId();
		this.trainStationReferenceId = trainStation.getTrainStationReferenceId();
		this.geoLocation = trainStation.getGeoLocation();
		this.trainStationCode = trainStation.getTrainStationCode();
		this.trainStationName = trainStation.getTrainStationName();
		this.trainStationContactNumber = trainStation.getTrainStationContactNumber();
		this.activeStatus = trainStation.getActiveStatus();
	}
	
	

}
