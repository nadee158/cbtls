package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.List;

public class ViewTrainlocationResponseDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private List<TrainLocationDTO> locationDTOs;
  
  
  private String status;
  
  private String message;
  
  private int totalNoOfFeedbacks;

  public List<TrainLocationDTO> getLocationDTOs() {
    return locationDTOs;
  }

  public void setLocationDTOs(List<TrainLocationDTO> locationDTOs) {
    this.locationDTOs = locationDTOs;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getTotalNoOfFeedbacks() {
    return totalNoOfFeedbacks;
  }

  public void setTotalNoOfFeedbacks(int totalNoOfFeedbacks) {
    this.totalNoOfFeedbacks = totalNoOfFeedbacks;
  }
  
  

}
