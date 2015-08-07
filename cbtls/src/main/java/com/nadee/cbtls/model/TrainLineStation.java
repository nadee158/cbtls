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
	
	@Column(name = "distance")
	private double distance;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="train_line",nullable=false)
	private TrainLine trainLine;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="train_station",nullable=false)
	private TrainStation trainStation;
	
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	
	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("trainLineStationId", trainLineStationId);
		map.put("distance", distance);
		map.put("activeStatus", activeStatus);
		map.put("trainLine", trainLine);
		map.put("trainStation", trainStation);
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
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

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}


	
	

}
