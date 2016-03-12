package com.nadee.cbtls.model;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.nadee.cbtls.constant.GeneralEnumConstants.TrainFrequency;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;

//record the train schedules - master data
@Entity(name="trainSchedule")
@Table(name = "train_schedule", uniqueConstraints =@UniqueConstraint(columnNames = "train_schedule_id"))
public class TrainSchedule implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "train_schedule_id", nullable = false)
	private long trainScheduleId;
	
	@Enumerated(EnumType.STRING)
    @Column(name="train_frequency")
	private TrainFrequency trainFrequency;
	
	@Column(name="train_name")
	private String trainName;
	
	@Column(name="train_number")
	private String trainNumber;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="start_station_id",nullable=false)
	private TrainStation startStation;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="end_station_id",nullable=false)
	private TrainStation endStation;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="train_type_id",nullable=false)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private TrainType trainType;
	
	@OneToMany(mappedBy = "trainSchedule", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<TrainStationSchedule> trainStationSchedules;
	
	@OneToMany(mappedBy = "trainSchedule", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<TrainScheduleTurn> trainScheduleTurns;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	
	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("trainScheduleId", trainScheduleId);
		map.put("trainFrequency", trainFrequency);
		map.put("trainName", trainName);
		map.put("trainNumber", trainNumber);
		map.put("startStation", startStation);
		map.put("endStation", endStation);
		map.put("trainType", trainType);
		map.put("activeStatus", activeStatus);
		map.put("versionId", versionId);
		return map;
	}
	
	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}

	public long getTrainScheduleId() {
		return trainScheduleId;
	}

	public void setTrainScheduleId(long trainScheduleId) {
		this.trainScheduleId = trainScheduleId;
	}

	public TrainFrequency getTrainFrequency() {
		return trainFrequency;
	}

	public void setTrainFrequency(TrainFrequency trainFrequency) {
		this.trainFrequency = trainFrequency;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public TrainStation getStartStation() {
		return startStation;
	}

	public void setStartStation(TrainStation startStation) {
		this.startStation = startStation;
	}

	public TrainStation getEndStation() {
		return endStation;
	}

	public void setEndStation(TrainStation endStation) {
		this.endStation = endStation;
	}


	public TrainType getTrainType() {
		return trainType;
	}

	public void setTrainType(TrainType trainType) {
		this.trainType = trainType;
	}

	public YesNoStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(YesNoStatus activeStatus) {
		this.activeStatus = activeStatus;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public List<TrainStationSchedule> getTrainStationSchedules() {
		return trainStationSchedules;
	}

	public void setTrainStationSchedules(List<TrainStationSchedule> trainStationSchedules) {
		this.trainStationSchedules = trainStationSchedules;
	}

	public List<TrainScheduleTurn> getTrainScheduleTurns() {
		return trainScheduleTurns;
	}

	public void setTrainScheduleTurns(List<TrainScheduleTurn> trainScheduleTurns) {
		this.trainScheduleTurns = trainScheduleTurns;
	}


	



	
	

}
