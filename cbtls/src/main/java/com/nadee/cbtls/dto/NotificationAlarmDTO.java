package com.nadee.cbtls.dto;

import java.io.Serializable;

public class NotificationAlarmDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String systemUserMobileDevice;
	
	private long destinationStation;
	
	private int alarmType;
	
	private float distanceToStation;

	public String getSystemUserMobileDevice() {
		return systemUserMobileDevice;
	}

	public void setSystemUserMobileDevice(String systemUserMobileDevice) {
		this.systemUserMobileDevice = systemUserMobileDevice;
	}

	public long getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(long destinationStation) {
		this.destinationStation = destinationStation;
	}

	public int getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(int alarmType) {
		this.alarmType = alarmType;
	}

	public float getDistanceToStation() {
		return distanceToStation;
	}

	public void setDistanceToStation(float distanceToStation) {
		this.distanceToStation = distanceToStation;
	}
	
	

}
