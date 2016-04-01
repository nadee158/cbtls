package com.nadee.cbtls.dto;

import java.io.Serializable;

public class AnalysisOfTrainResponseDTO implements Serializable {

  private String status;

  private String stationOne;
  private String stationTwo;

  private String etaAtStation1;
  private String etaAtStation2;
  private String totalDistance;
  private String duration;
  private String trainType;
  private String frequency;
  private String averageDelay;
  private String averageCrowdDensity;
  private String ticketPriceFirstClass;
  private String ticketPriceSecondClass;
  private String ticketPriceThirdClass;


  public AnalysisOfTrainResponseDTO(String status) {
    this.status = status;
  }

  public AnalysisOfTrainResponseDTO() {
    // TODO Auto-generated constructor stub
  }



  public AnalysisOfTrainResponseDTO(String status, String etaAtStation1, String etaAtStation2,
      String totalDistance, String duration, String trainType, String frequency,
      String averageDelay, String averageCrowdDensity, String ticketPriceFirstClass,
      String ticketPriceSecondClass, String ticketPriceThirdClass) {
    super();
    this.status = status;
    this.etaAtStation1 = etaAtStation1;
    this.etaAtStation2 = etaAtStation2;
    this.totalDistance = totalDistance;
    this.duration = duration;
    this.trainType = trainType;
    this.frequency = frequency;
    this.averageDelay = averageDelay;
    this.averageCrowdDensity = averageCrowdDensity;
    this.ticketPriceFirstClass = ticketPriceFirstClass;
    this.ticketPriceSecondClass = ticketPriceSecondClass;
    this.ticketPriceThirdClass = ticketPriceThirdClass;
  }



  private static final long serialVersionUID = 1L;


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getEtaAtStation1() {
    return etaAtStation1;
  }

  public void setEtaAtStation1(String etaAtStation1) {
    this.etaAtStation1 = etaAtStation1;
  }

  public String getEtaAtStation2() {
    return etaAtStation2;
  }

  public void setEtaAtStation2(String etaAtStation2) {
    this.etaAtStation2 = etaAtStation2;
  }

  public String getTotalDistance() {
    return totalDistance;
  }

  public void setTotalDistance(String totalDistance) {
    this.totalDistance = totalDistance;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getTrainType() {
    return trainType;
  }

  public void setTrainType(String trainType) {
    this.trainType = trainType;
  }

  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public String getAverageDelay() {
    return averageDelay;
  }

  public void setAverageDelay(String averageDelay) {
    this.averageDelay = averageDelay;
  }

  public String getAverageCrowdDensity() {
    return averageCrowdDensity;
  }

  public void setAverageCrowdDensity(String averageCrowdDensity) {
    this.averageCrowdDensity = averageCrowdDensity;
  }

  public String getTicketPriceFirstClass() {
    return ticketPriceFirstClass;
  }

  public void setTicketPriceFirstClass(String ticketPriceFirstClass) {
    this.ticketPriceFirstClass = ticketPriceFirstClass;
  }

  public String getTicketPriceSecondClass() {
    return ticketPriceSecondClass;
  }

  public void setTicketPriceSecondClass(String ticketPriceSecondClass) {
    this.ticketPriceSecondClass = ticketPriceSecondClass;
  }

  public String getTicketPriceThirdClass() {
    return ticketPriceThirdClass;
  }

  public void setTicketPriceThirdClass(String ticketPriceThirdClass) {
    this.ticketPriceThirdClass = ticketPriceThirdClass;
  }

  public String getStationOne() {
    return stationOne;
  }

  public void setStationOne(String stationOne) {
    this.stationOne = stationOne;
  }

  public String getStationTwo() {
    return stationTwo;
  }

  public void setStationTwo(String stationTwo) {
    this.stationTwo = stationTwo;
  }



}
