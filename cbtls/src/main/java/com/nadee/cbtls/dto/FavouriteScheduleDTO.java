package com.nadee.cbtls.dto;

import java.io.Serializable;

public class FavouriteScheduleDTO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private long trainStationScheduleId;

  private long updatedUser;

  private String systemUserMobileDevice;


  public long getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(long updatedUser) {
    this.updatedUser = updatedUser;
  }

  public String getSystemUserMobileDevice() {
    return systemUserMobileDevice;
  }

  public void setSystemUserMobileDevice(String systemUserMobileDevice) {
    this.systemUserMobileDevice = systemUserMobileDevice;
  }

  public long getTrainStationScheduleId() {
    return trainStationScheduleId;
  }

  public void setTrainStationScheduleId(long trainStationScheduleId) {
    this.trainStationScheduleId = trainStationScheduleId;
  }

  @Override
  public String toString() {
    return "FavouriteScheduleDTO [trainStationScheduleId=" + trainStationScheduleId
        + ", updatedUser=" + updatedUser + ", systemUserMobileDevice=" + systemUserMobileDevice
        + "]";
  }



}
