package com.nadee.cbtls.dto;

import java.io.Serializable;

public class CompartmentDetailUpdateDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private int compartmentNumber;

  private int compartmentDensity;

  private int totalCompartments;

  private int overallDensity;

  private long trainStationScheduleId;

  private double latitude;

  private double longitude;

  private long trainScheduleId;

  private long updatedUser;

  private String systemUserMobileDevice;

  public int getCompartmentNumber() {
    return compartmentNumber;
  }

  public void setCompartmentNumber(int compartmentNumber) {
    this.compartmentNumber = compartmentNumber;
  }

  public int getCompartmentDensity() {
    return compartmentDensity;
  }

  public void setCompartmentDensity(int compartmentDensity) {
    this.compartmentDensity = compartmentDensity;
  }

  public int getTotalCompartments() {
    return totalCompartments;
  }

  public void setTotalCompartments(int totalCompartments) {
    this.totalCompartments = totalCompartments;
  }

  public int getOverallDensity() {
    return overallDensity;
  }

  public void setOverallDensity(int overallDensity) {
    this.overallDensity = overallDensity;
  }

  public long getTrainStationScheduleId() {
    return trainStationScheduleId;
  }

  public void setTrainStationScheduleId(long trainStationScheduleId) {
    this.trainStationScheduleId = trainStationScheduleId;
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

  public long getTrainScheduleId() {
    return trainScheduleId;
  }

  public void setTrainScheduleId(long trainScheduleId) {
    this.trainScheduleId = trainScheduleId;
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



}
