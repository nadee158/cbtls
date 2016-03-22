package com.nadee.cbtls.dto;

import java.io.Serializable;

public class TrainScheduleSearchDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long fromStationId;
	private long toStationId;
	// in dd/MM/yyyy
	private String searchedDate;
	// in HH:mm
	private String fromTime;
	// in HH:mm
	private String toTime;
	// //in dd/MM/yyyy
	// private String currentDate;

	private long trainLineId;

	private String fromStationName;
	private String toStationName;
	private int searchTypeId;
	private String searchTypeText;

	public long getFromStationId() {
		return fromStationId;
	}

	public void setFromStationId(long fromStationId) {
		this.fromStationId = fromStationId;
	}

	public long getToStationId() {
		return toStationId;
	}

	public void setToStationId(long toStationId) {
		this.toStationId = toStationId;
	}

	public String getSearchedDate() {
		return searchedDate;
	}

	public void setSearchedDate(String searchedDate) {
		this.searchedDate = searchedDate;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	@Override
	public String toString() {
		return "TrainScheduleSearchDTO [fromStationId=" + fromStationId
				+ ", toStationId=" + toStationId + ", searchedDate="
				+ searchedDate + ", fromTime=" + fromTime + ", toTime="
				+ toTime + "]";
	}

	public String getFromStationName() {
		return fromStationName;
	}

	public void setFromStationName(String fromStationName) {
		this.fromStationName = fromStationName;
	}

	public String getToStationName() {
		return toStationName;
	}

	public void setToStationName(String toStationName) {
		this.toStationName = toStationName;
	}

	public int getSearchTypeId() {
		return searchTypeId;
	}

	public void setSearchTypeId(int searchTypeId) {
		this.searchTypeId = searchTypeId;
	}

	public String getSearchTypeText() {
		return searchTypeText;
	}

	public void setSearchTypeText(String searchTypeText) {
		this.searchTypeText = searchTypeText;
	}

	public long getTrainLineId() {
		return trainLineId;
	}

	public void setTrainLineId(long trainLineId) {
		this.trainLineId = trainLineId;
	}

}
