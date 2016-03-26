package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class PassiveTrainLocationUpdateDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long trainStationScheduleId;
	
	private float latitude;

	private float longitude;
	
	private long trainScheduleId;
	
	private long lastStationId;
	
	private long updatedUser;
	
	private int locatedType;
	
	private String locatedTime;

	public long getTrainStationScheduleId() {
		return trainStationScheduleId;
	}

	public void setTrainStationScheduleId(long trainStationScheduleId) {
		this.trainStationScheduleId = trainStationScheduleId;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public long getTrainScheduleId() {
		return trainScheduleId;
	}

	public void setTrainScheduleId(long trainScheduleId) {
		this.trainScheduleId = trainScheduleId;
	}

	public long getLastStationId() {
		return lastStationId;
	}

	public void setLastStationId(long lastStationId) {
		this.lastStationId = lastStationId;
	}

	public long getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(long updatedUser) {
		this.updatedUser = updatedUser;
	}

	public int getLocatedType() {
		return locatedType;
	}

	public void setLocatedType(int locatedType) {
		this.locatedType = locatedType;
	}

	public String getLocatedTime() {
		return locatedTime;
	}
	
	public Date getLocatedTimeAsDate() {
		Date fromTimeDate = Calendar.getInstance().getTime();
		if (StringUtils.isNotEmpty(locatedTime)) {
			SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
			try {
				fromTimeDate = tf.parse(locatedTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return fromTimeDate;
	}
	

	public void setLocatedTime(String locatedTime) {
		this.locatedTime = locatedTime;
	}
	
	

}
