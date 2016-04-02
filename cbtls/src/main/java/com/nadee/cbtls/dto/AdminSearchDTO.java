package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class AdminSearchDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private long fromStationId;
  private long toStationId;
  // in dd/MM/yyyy
  private String searchedFromDate;
  // in dd/MM/yyyy
  private String searchedToDate;

  private long trainLineId;

  private long trainStationScheduleId;

  public Date retieveFromDate() {
    Date searchedDateDate = null;
    if (StringUtils.isNotEmpty(searchedFromDate)) {
      SimpleDateFormat tf = new SimpleDateFormat("dd/MM/yyyy");
      try {
        searchedDateDate = tf.parse(searchedFromDate);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    return searchedDateDate;
  }

  public Date retieveToDate() {
    Date searchedDateDate = null;
    if (StringUtils.isNotEmpty(searchedToDate)) {
      SimpleDateFormat tf = new SimpleDateFormat("dd/MM/yyyy");
      try {
        searchedDateDate = tf.parse(searchedToDate);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    return searchedDateDate;
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

  public String getSearchedFromDate() {
    return searchedFromDate;
  }

  public void setSearchedFromDate(String searchedFromDate) {
    this.searchedFromDate = searchedFromDate;
  }

  public String getSearchedToDate() {
    return searchedToDate;
  }

  public void setSearchedToDate(String searchedToDate) {
    this.searchedToDate = searchedToDate;
  }

  public long getTrainLineId() {
    return trainLineId;
  }

  public void setTrainLineId(long trainLineId) {
    this.trainLineId = trainLineId;
  }

  @Override
  public String toString() {
    return "AdminSearchDTO [fromStationId=" + fromStationId + ", toStationId=" + toStationId
        + ", searchedFromDate=" + searchedFromDate + ", searchedToDate=" + searchedToDate
        + ", trainLineId=" + trainLineId + "]";
  }

  public long getTrainStationScheduleId() {
    return trainStationScheduleId;
  }

  public void setTrainStationScheduleId(long trainStationScheduleId) {
    this.trainStationScheduleId = trainStationScheduleId;
  }



}
