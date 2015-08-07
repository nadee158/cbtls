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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;

@Entity(name="trainStation")
@Table(name = "train_station", uniqueConstraints =@UniqueConstraint(columnNames = "train_station_id"))
public class TrainStation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "train_station_id", nullable = false)
	private long trainStationId;
	
	@Column(name = "train_station_name")
	private String trainStationName;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@OneToMany(mappedBy = "trainStation", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<TrainLineStation> trainLineStations;
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	
	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("trainStationId", trainStationId);
		map.put("trainStationName", trainStationName);
		map.put("activeStatus", activeStatus);
		map.put("trainLineStations", trainLineStations);
		map.put("versionId", versionId);
		return map;
	}
	
	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}

	public long getTrainStationId() {
		return trainStationId;
	}

	public void setTrainStationId(long trainStationId) {
		this.trainStationId = trainStationId;
	}

	public String getTrainStationName() {
		return trainStationName;
	}

	public void setTrainStationName(String trainStationName) {
		this.trainStationName = trainStationName;
	}

	public YesNoStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(YesNoStatus activeStatus) {
		this.activeStatus = activeStatus;
	}

	public List<TrainLineStation> getTrainLineStations() {
		return trainLineStations;
	}

	public void setTrainLineStations(List<TrainLineStation> trainLineStations) {
		this.trainLineStations = trainLineStations;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}


	
	

}
