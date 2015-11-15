package com.nadee.cbtls.model;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;

@Entity(name="trainLineStation")
@Table(name = "train_line_station", uniqueConstraints =@UniqueConstraint(columnNames = "train_line_station_id"))
public class TrainLineStation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "train_line_station_id", nullable = false)
	private long trainLineStationId;
	
	@Column(name = "distance_from_start_station")
	private double distanceFromStartStation;
	
	@Column(name = "distance_from_end_station")
	private double distanceFromEndStation;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="train_line_id",nullable=false)
	private TrainLine trainLine;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="train_station_id",nullable=false)
	private TrainStation trainStation;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="next_station_id",nullable=false)
	private TrainStation nextStation;
	
	@Column(name = "distance_to_next_station")
	private double distanceToNextStation;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="previous_station_id",nullable=false)
	private TrainStation previousStation;
	
	@Column(name = "distance_to_previous_station")
	private double distanceToPreviousStation;
	
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	
	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("trainLineStationId", trainLineStationId);
		map.put("distanceFromStartStation", distanceFromStartStation);
		map.put("distanceFromEndStation", distanceFromEndStation);
		map.put("activeStatus", activeStatus);
		map.put("trainLine", trainLine);
		map.put("trainStation", trainStation);
		map.put("nextStation", nextStation);
		map.put("distanceToNextStation", distanceToNextStation);
		map.put("previousStation", previousStation);
		map.put("distanceToPreviousStation", distanceToPreviousStation);
		map.put("versionId", versionId);
		return map;
	}
	
	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}

	public long getTrainLineStationId() {
		return trainLineStationId;
	}

	public void setTrainLineStationId(long trainLineStationId) {
		this.trainLineStationId = trainLineStationId;
	}

	public YesNoStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(YesNoStatus activeStatus) {
		this.activeStatus = activeStatus;
	}

	public TrainLine getTrainLine() {
		return trainLine;
	}

	public void setTrainLine(TrainLine trainLine) {
		this.trainLine = trainLine;
	}

	public TrainStation getTrainStation() {
		return trainStation;
	}

	public void setTrainStation(TrainStation trainStation) {
		this.trainStation = trainStation;
	}
	
	public TrainStation getNextStation() {
		return nextStation;
	}

	public void setNextStation(TrainStation nextStation) {
		this.nextStation = nextStation;
	}

	public TrainStation getPreviousStation() {
		return previousStation;
	}

	public void setPreviousStation(TrainStation previousStation) {
		this.previousStation = previousStation;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public double getDistanceFromStartStation() {
		return distanceFromStartStation;
	}

	public void setDistanceFromStartStation(double distanceFromStartStation) {
		this.distanceFromStartStation = distanceFromStartStation;
	}

	public double getDistanceFromEndStation() {
		return distanceFromEndStation;
	}

	public void setDistanceFromEndStation(double distanceFromEndStation) {
		this.distanceFromEndStation = distanceFromEndStation;
	}

	public double getDistanceToNextStation() {
		return distanceToNextStation;
	}

	public void setDistanceToNextStation(double distanceToNextStation) {
		this.distanceToNextStation = distanceToNextStation;
	}

	public double getDistanceToPreviousStation() {
		return distanceToPreviousStation;
	}

	public void setDistanceToPreviousStation(double distanceToPreviousStation) {
		this.distanceToPreviousStation = distanceToPreviousStation;
	}


	
	

}
