package com.nadee.cbtls.dto;

import java.io.Serializable;

public class ViewTrainlocationRequestDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private long trainStationScheduleId;
  
  private long trainScheduleId;
  
  private long trainLine;

  public long getTrainStationScheduleId() {
    return trainStationScheduleId;
  }

  public void setTrainStationScheduleId(long trainStationScheduleId) {
    this.trainStationScheduleId = trainStationScheduleId;
  }

  public long getTrainScheduleId() {
    return trainScheduleId;
  }

  public void setTrainScheduleId(long trainScheduleId) {
    this.trainScheduleId = trainScheduleId;
  }

  public long getTrainLine() {
    return trainLine;
  }

  public void setTrainLine(long trainLine) {
    this.trainLine = trainLine;
  }
  
  

}
