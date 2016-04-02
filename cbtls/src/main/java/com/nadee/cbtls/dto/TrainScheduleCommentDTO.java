package com.nadee.cbtls.dto;

import java.io.Serializable;

public class TrainScheduleCommentDTO implements Serializable {

  private static final long serialVersionUID = 1L;


  private long trainScheduleId;

  private long trainStationScheduleId;

  private long updatedUser;

  private String systemUserMobileDevice;

  private String updatedUserName;

  private int rating;

  private String comment;

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

  public String getUpdatedUserName() {
    return updatedUserName;
  }

  public void setUpdatedUserName(String updatedUserName) {
    this.updatedUserName = updatedUserName;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

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

  @Override
  public String toString() {
    return "TrainScheduleCommentDTO [trainScheduleId=" + trainScheduleId
        + ", trainStationScheduleId=" + trainStationScheduleId + ", updatedUser=" + updatedUser
        + ", systemUserMobileDevice=" + systemUserMobileDevice + ", updatedUserName="
        + updatedUserName + ", rating=" + rating + ", comment=" + comment + "]";
  }



}
