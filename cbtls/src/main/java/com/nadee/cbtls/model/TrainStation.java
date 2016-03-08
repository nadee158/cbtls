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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;

@Entity(name="trainStation")
@Table(name = "train_station", uniqueConstraints =@UniqueConstraint(columnNames = {"train_station_id","train_station_code"}))
public class TrainStation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "train_station_id", nullable = false)
	private long trainStationId;
	
	@Column(name = "train_station_reference_id", nullable = false)
	private String trainStationReferenceId;
	
	
	@OneToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="geo_location_id",nullable=false)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private GeoLocation geoLocation;
	
	@Column(name = "train_station_code", nullable = false, length=3)
	private String trainStationCode;
	
	@Column(name = "train_station_name", length=255)
	private String trainStationName;
	
	@Column(name = "train_station_contact_number", length=10)
	private String trainStationContactNumber;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@OneToMany(mappedBy = "trainStation")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<TrainLineStation> trainLineStations;
	
	@OneToMany(mappedBy = "trainStation")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<TrainStationSchedule> trainStationSchedules;
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	
	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("trainStationId", trainStationId);
		map.put("trainStationName", trainStationName);
		map.put("trainStationContactNumber", trainStationContactNumber);
		map.put("activeStatus", activeStatus);
		map.put("trainLineStations", trainLineStations);
		map.put("versionId", versionId);
		map.put("trainStationReferenceId", trainStationReferenceId);
		map.put("trainStationCode", trainStationCode);
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

	public String getTrainStationContactNumber() {
		return trainStationContactNumber;
	}

	public void setTrainStationContactNumber(String trainStationContactNumber) {
		this.trainStationContactNumber = trainStationContactNumber;
	}

	public String getTrainStationReferenceId() {
		return trainStationReferenceId;
	}

	public void setTrainStationReferenceId(String trainStationReferenceId) {
		this.trainStationReferenceId = trainStationReferenceId;
	}

	public String getTrainStationCode() {
		return trainStationCode;
	}

	public void setTrainStationCode(String trainStationCode) {
		this.trainStationCode = trainStationCode;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	public List<TrainStationSchedule> getTrainStationSchedules() {
		return trainStationSchedules;
	}

	public void setTrainStationSchedules(List<TrainStationSchedule> trainStationSchedules) {
		this.trainStationSchedules = trainStationSchedules;
	}


	
	

}
