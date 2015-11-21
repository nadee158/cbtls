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

import com.nadee.cbtls.constant.GeneralEnumConstants.LocatedType;

@Entity(name = "trainScheduleTurnLocationPassiveUpdate")
@Table(name = "train_schedule_turn_location_passive_update", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class TrainScheduleTurnLocationPassiveUpdate implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;

	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="train_schedule_turn_id",nullable=false)
	private TrainScheduleTurn trainScheduleTurn;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="last_station_id",nullable=false)
	private TrainStation lastStation;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="user_id",nullable=false)
	private SystemUser updatedUser;
	
	@Column(name="located_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date locatedTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "located_type")
	private LocatedType locatedType;
	
	@Version
	@Column(name = "version_id")
	private int versionId;



	public Map<String, Object> toBasicMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("trainScheduleTurn", trainScheduleTurn);
		map.put("lastStation", lastStation);
		
		map.put("trainScheduleTurn", trainScheduleTurn);
		map.put("updatedUser", updatedUser);
		map.put("locatedTime", locatedTime);
		
		map.put("locatedType", locatedType);
		
		map.put("versionId", versionId);
		return map;
	}

	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TrainScheduleTurn getTrainScheduleTurn() {
		return trainScheduleTurn;
	}

	public void setTrainScheduleTurn(TrainScheduleTurn trainScheduleTurn) {
		this.trainScheduleTurn = trainScheduleTurn;
	}

	public TrainStation getLastStation() {
		return lastStation;
	}

	public void setLastStation(TrainStation lastStation) {
		this.lastStation = lastStation;
	}

	public SystemUser getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(SystemUser updatedUser) {
		this.updatedUser = updatedUser;
	}

	public Date getLocatedTime() {
		return locatedTime;
	}

	public void setLocatedTime(Date locatedTime) {
		this.locatedTime = locatedTime;
	}

	public LocatedType getLocatedType() {
		return locatedType;
	}

	public void setLocatedType(LocatedType locatedType) {
		this.locatedType = locatedType;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	
	
}
