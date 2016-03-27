package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewCompartmentDetailRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long trainScheduleId;
	
	private long trainStationScheduleId;
	
	
	private String date;
	
	public Date getDateAsDate() throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		return format.parse(date);
	}

	public long getTrainScheduleId() {
		return trainScheduleId;
	}

	public void setTrainScheduleId(long trainScheduleId) {
		this.trainScheduleId = trainScheduleId;
	}

	public long getTrainStationScheduleId() {
		return trainStationScheduleId;
	}

	public void setTrainStationScheduleId(long trainStationScheduleId) {
		this.trainStationScheduleId = trainStationScheduleId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
