package com.nadee.cbtls.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;

//record the train schedule details per station - master data
@Entity(name="trainStationSchedule")
@Table(name = "train_station_schedule", uniqueConstraints =@UniqueConstraint(columnNames = {"train_station_schedule_id"}))
public class TrainStationSchedule implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "train_station_schedule_id", nullable = false)
	private long trainStationScheduleId;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="train_schedule_id",nullable=false)
	private TrainSchedule trainSchedule;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="train_station_id",nullable=false)
	private TrainStation trainStation;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@Column(name="arrival_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalTime;	
	
	@Column(name="departure_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureTime;
	
	@OneToMany(mappedBy = "trainStationSchedule", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<TrainStationScheduleTurn> trainStationScheduleTurns;
	
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	

	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("trainStationScheduleId", trainStationScheduleId);
		map.put("trainSchedule", trainSchedule);
		map.put("trainStation", trainStation);
		map.put("activeStatus", activeStatus);
		map.put("versionId", versionId);
		map.put("arrivalTime", arrivalTime);
		map.put("departureTime", departureTime);
		return map;
	}
	
	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}

	public long getTrainStationScheduleId() {
		return trainStationScheduleId;
	}

	public void setTrainStationScheduleId(long trainStationScheduleId) {
		this.trainStationScheduleId = trainStationScheduleId;
	}

	public TrainSchedule getTrainSchedule() {
		return trainSchedule;
	}

	public void setTrainSchedule(TrainSchedule trainSchedule) {
		this.trainSchedule = trainSchedule;
	}

	public TrainStation getTrainStation() {
		return trainStation;
	}

	public void setTrainStation(TrainStation trainStation) {
		this.trainStation = trainStation;
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
