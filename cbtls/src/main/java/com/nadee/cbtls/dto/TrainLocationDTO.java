package com.nadee.cbtls.dto;

import java.io.Serializable;

public class TrainLocationDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private double latitude;
  
  private double longitude;
  
  private String providedUserName;
  
  private String updatedTime;
  
  private long updatedUserId;
  
  private float rank;
  
  private String note;


  public String getProvidedUserName() {
    return providedUserName;
  }

  public void setProvidedUserName(String providedUserName) {
    this.providedUserName = providedUserName;
  }

  public String getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
  }

  public long getUpdatedUserId() {
    return updatedUserId;
  }

  public void setUpdatedUserId(long updatedUserId) {
    this.updatedUserId = updatedUserId;
  }

  public float getRank() {
    return rank;
  }

  public void setRank(float rank) {
    this.rank = rank;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

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

  @Override
  public String toString() {
    return "TrainLocationDTO [latitude=" + latitude + ", longitude=" + longitude + ", providedUserName=" + providedUserName + ", updatedTime="
        + updatedTime + ", updatedUserId=" + updatedUserId + ", rank=" + rank + ", note=" + note + "]";
  }

  

}
