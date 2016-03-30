package com.nadee.cbtls.dto;

import java.io.Serializable;

public class ActiveTrainLocationUpdateDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private long trainStationScheduleId;

  private double latitude;

  private double longitude;

  private long trainScheduleId;

  private long lastStationId;

  private int locatedType;

  private long updatedUser;

  private String systemUserMobileDevice;



  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
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

  public int getLocatedType() {
    return locatedType;
  }

  public void setLocatedType(int locatedType) {
    this.locatedType = locatedType;
  }

  public long getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(long updatedUser) {
    this.updatedUser = updatedUser;
  }

  public long getTrainStationScheduleId() {
    return trainStationScheduleId;
  }

  public void setTrainStationScheduleId(long trainStationScheduleId) {
    this.trainStationScheduleId = trainStationScheduleId;
  }

  public String getSystemUserMobileDevice() {
    return systemUserMobileDevice;
  }

  public void setSystemUserMobileDevice(String systemUserMobileDevice) {
    this.systemUserMobileDevice = systemUserMobileDevice;
  }



}
