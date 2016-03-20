package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.nadee.cbtls.constant.GeneralEnumConstants.TrainFrequency;

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
	
	private String fromStationName;
	private String toStationName;
	private int searchTypeId;
	private String searchTypeText;

	public Date retieveFromTime() {
		Date fromTimeDate = null;
		if (StringUtils.isNotEmpty(fromTime)) {
			SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
			try {
				fromTimeDate = tf.parse(fromTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return fromTimeDate;
	}

	public Date retieveToTime() {
		Date toTimeDate = null;
		if (StringUtils.isNotEmpty(toTime)) {
			SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
			try {
				toTimeDate = tf.parse(toTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return toTimeDate;
	}

	public Date retieveSearchedDate() {
		Date searchedDateDate = null;
		if (StringUtils.isNotEmpty(searchedDate)) {
			SimpleDateFormat tf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				searchedDateDate = tf.parse(searchedDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return searchedDateDate;
	}

	public List<TrainFrequency> retrieveTrainFrequencies() {
		List<TrainFrequency> frequencies = new ArrayList<TrainFrequency>();
		Date serachedDate = retieveSearchedDate();
		if (!(serachedDate == null)) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(serachedDate);
			switch (cal.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.MONDAY:
				frequencies.add(TrainFrequency.DAILY);
				frequencies.add(TrainFrequency.MONDAY_TO_FRIDAY);
				break;
			case Calendar.TUESDAY:
				frequencies.add(TrainFrequency.DAILY);
				frequencies.add(TrainFrequency.MONDAY_TO_FRIDAY);
				break;
			case Calendar.WEDNESDAY:
				frequencies.add(TrainFrequency.DAILY);
				frequencies.add(TrainFrequency.MONDAY_TO_FRIDAY);
				break;
			case Calendar.THURSDAY:
				frequencies.add(TrainFrequency.DAILY);
				frequencies.add(TrainFrequency.MONDAY_TO_FRIDAY);
				break;
			case Calendar.FRIDAY:
				frequencies.add(TrainFrequency.DAILY);
				frequencies.add(TrainFrequency.MONDAY_TO_FRIDAY);
				break;
			case Calendar.SATURDAY:
				frequencies.add(TrainFrequency.DAILY);
				frequencies.add(TrainFrequency.SATURDAY_AND_SUNDAY);
				break;
			case Calendar.SUNDAY:
				frequencies.add(TrainFrequency.DAILY);
				frequencies.add(TrainFrequency.SATURDAY_AND_SUNDAY);
				frequencies.add(TrainFrequency.SUNDAYS_AND_HOLIDAYS);
				break;
			default:
				break;
			}

		}
		return frequencies;
	}

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
		return "TrainScheduleSearchDTO [fromStationId=" + fromStationId + ", toStationId=" + toStationId
				+ ", searchedDate=" + searchedDate + ", fromTime=" + fromTime + ", toTime=" + toTime + "]";
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
	
	

}
