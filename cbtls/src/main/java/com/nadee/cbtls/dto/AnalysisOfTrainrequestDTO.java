package com.nadee.cbtls.dto;

import java.io.Serializable;

public class AnalysisOfTrainrequestDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private long trainScheduleId;

  private long trainStationScheduleId;

  private long trainLineId;

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

  @Override
  public String toString() {
    return "AnalysisOfTrainrequestDTO [trainScheduleId=" + trainScheduleId
        + ", trainStationScheduleId=" + trainStationScheduleId + "]";
  }

  public long getTrainLineId() {
    return trainLineId;
  }

  public void setTrainLineId(long trainLineId) {
    this.trainLineId = trainLineId;
  }


}
