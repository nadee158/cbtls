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

import com.nadee.cbtls.constant.GeneralEnumConstants.CrowdDensity;

@Entity(name = "trainScheduleTurnCompartmentUpdate")
@Table(name = "train_schedule_turn_compartment_update", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class TrainScheduleTurnCompartmentUpdate implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "compartment_number", nullable = false)
	private int compartmentNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "compartment_density")
	private CrowdDensity compartmentDensity;
	
	@Column(name = "total_compartments", nullable = false)
	private int totalCompartments;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "overall_density")
	private CrowdDensity overallDensity;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="train_schedule_turn_id",nullable=false)
	private TrainScheduleTurn trainScheduleTurn;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="user_id",nullable=false)
	private SystemUser updatedUser;
	
	@Column(name="updated_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTime;
	
	
	@Version
	@Column(name = "version_id")
	private int versionId;

		
	
	public Map<String, Object> toBasicMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("compartmentNumber", compartmentNumber);
		map.put("compartmentDensity", compartmentDensity);
		map.put("totalCompartments", totalCompartments);
		map.put("overallDensity", overallDensity);
		map.put("trainScheduleTurn", trainScheduleTurn);
		map.put("updatedUser", updatedUser);
		map.put("updatedTime", updatedTime);
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

	public int getCompartmentNumber() {
		return compartmentNumber;
	}

	public void setCompartmentNumber(int compartmentNumber) {
		this.compartmentNumber = compartmentNumber;
	}

	public CrowdDensity getCompartmentDensity() {
		return compartmentDensity;
	}

	public void setCompartmentDensity(CrowdDensity compartmentDensity) {
		this.compartmentDensity = compartmentDensity;
	}

	public int getTotalCompartments() {
		return totalCompartments;
	}

	public void setTotalCompartments(int totalCompartments) {
		this.totalCompartments = totalCompartments;
	}

	public CrowdDensity getOverallDensity() {
		return overallDensity;
	}

	public void setOverallDensity(CrowdDensity overallDensity) {
		this.overallDensity = overallDensity;
	}

	public TrainScheduleTurn getTrainScheduleTurn() {
		return trainScheduleTurn;
	}

	public void setTrainScheduleTurn(TrainScheduleTurn trainScheduleTurn) {
		this.trainScheduleTurn = trainScheduleTurn;
	}

	public SystemUser getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(SystemUser updatedUser) {
		this.updatedUser = updatedUser;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}



	
	
	
}
