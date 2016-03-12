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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;

@Entity(name="trainLine")
@Table(name = "train_line", uniqueConstraints =@UniqueConstraint(columnNames = "train_line_id"))
public class TrainLine implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "train_line_id", nullable = false)
	private long trainLineId;
	
	@Column(name = "train_line_integration_id")
	private int trainLineIntegrationId;
	
	@Column(name = "train_line_name")
	private String trainLineName;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@OneToMany(mappedBy = "trainLine", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<TrainLineStation> trainLineStations;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="start_station_id")
	private TrainStation startStation;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="end_station_id")
	private TrainStation endStation;
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	
	
	
	public TrainLine() {
		super();
	}

	public TrainLine(int trainLineIntegrationId, String trainLineName) {
		this.trainLineIntegrationId=trainLineIntegrationId;
		this.trainLineName=trainLineName;
		this.activeStatus=YesNoStatus.YES;
	}

	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("trainLineId", trainLineId);
		map.put("trainLineIntegrationId", trainLineIntegrationId);
		map.put("trainLineName", trainLineName);
		map.put("activeStatus", activeStatus);
		map.put("trainLineStations", trainLineStations);
		map.put("versionId", versionId);
		map.put("startStation", startStation);
		map.put("endStation", endStation);
		return map;
	}
	
	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}

	public long getTrainLineId() {
		return trainLineId;
	}

	public void setTrainLineId(long trainLineId) {
		this.trainLineId = trainLineId;
	}

	public String getTrainLineName() {
		return trainLineName;
	}

	public void setTrainLineName(String trainLineName) {
		this.trainLineName = trainLineName;
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

	public int getTrainLineIntegrationId() {
		return trainLineIntegrationId;
	}

	public void setTrainLineIntegrationId(int trainLineIntegrationId) {
		this.trainLineIntegrationId = trainLineIntegrationId;
	}


	
	

}
