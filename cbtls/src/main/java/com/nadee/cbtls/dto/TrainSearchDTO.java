package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.Date;

public class TrainSearchDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long startStation;
	private String startStationName;
	private long endStation;
	private String endStationName;
	private Date startDate;
	private Date endDate;
	private String startTime;
	private String endTime;
	private String searchType;
	
	public long getStartStation() {
		return startStation;
	}
	public void setStartStation(long startStation) {
		this.startStation = startStation;
	}
	public String getStartStationName() {
		return startStationName;
	}
	public void setStartStationName(String startStationName) {
		this.startStationName = startStationName;
	}
	public long getEndStation() {
		return endStation;
	}
	public void setEndStation(long endStation) {
		this.endStation = endStation;
	}
	public String getEndStationName() {
		return endStationName;
	}
	public void setEndStationName(String endStationName) {
		this.endStationName = endStationName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	

}
