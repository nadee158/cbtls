package com.nadee.cbtls.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;


// record the train schedule details daily per station
@Entity(name = "trainStationScheduleTurn")
@Table(name = "train_station_schedule_turn",
    uniqueConstraints = @UniqueConstraint(columnNames = {"train_station_schedule_turn_id"}))
public class TrainStationScheduleTurn implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "train_station_schedule_turn_id", nullable = false)
  private long trainStationScheduleTurnId;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "train_schedule_turn_id", nullable = false)
  private TrainScheduleTurn trainScheduleTurn;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "train_station_schedule_id", nullable = false)
  private TrainStationSchedule trainStationSchedule;

  @Enumerated(EnumType.STRING)
  @Column(name = "active_status")
  private YesNoStatus activeStatus;

  @Column(name = "arrival_time")
  @Temporal(TemporalType.TIMESTAMP)
  private Date arrivalTime;

  @Column(name = "departure_time")
  @Temporal(TemporalType.TIMESTAMP)
  private Date departureTime;


  @Version
  @Column(name = "version_id")
  private int versionId;


  public Map<String, Object> toBasicMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("trainStationScheduleTurnId", trainStationScheduleTurnId);
    map.put("trainScheduleTurn", trainScheduleTurn);
    map.put("trainStationSchedule", trainStationSchedule);
    map.put("activeStatus", activeStatus);
    map.put("arrivalTime", arrivalTime);
    map.put("departureTime", departureTime);
    map.put("versionId", versionId);
    return map;
  }

  @Override
  public String toString() {
    return this.trainStationScheduleTurnId + "";
  }

  public long getTrainStationScheduleTurnId() {
    return trainStationScheduleTurnId;
  }

  public void setTrainStationScheduleTurnId(long trainStationScheduleTurnId) {
    this.trainStationScheduleTurnId = trainStationScheduleTurnId;
  }


  public TrainScheduleTurn getTrainScheduleTurn() {
    return trainScheduleTurn;
  }

  public void setTrainScheduleTurn(TrainScheduleTurn trainScheduleTurn) {
    this.trainScheduleTurn = trainScheduleTurn;
  }

  public TrainStationSchedule getTrainStationSchedule() {
    return trainStationSchedule;
  }

  public void setTrainStationSchedule(TrainStationSchedule trainStationSchedule) {
    this.trainStationSchedule = trainStationSchedule;
  }

  public YesNoStatus getActiveStatus() {
    return activeStatus;
  }

  public void setActiveStatus(YesNoStatus activeStatus) {
    this.activeStatus = activeStatus;
  }

  public Date getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(Date arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public Date getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
  }

  public int getVersionId() {
    return versionId;
  }

  public void setVersionId(int versionId) {
    this.versionId = versionId;
  }



}
