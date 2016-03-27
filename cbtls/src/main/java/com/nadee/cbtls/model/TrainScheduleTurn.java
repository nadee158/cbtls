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

@Entity(name="trainScheduleTurn")
@Table(name = "train_schedule_turn", uniqueConstraints =@UniqueConstraint(columnNames = "train_schedule_turn_id"))
public class TrainScheduleTurn implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "train_schedule_turn_id", nullable = false)
	private long trainScheduleTurnId;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="train_schedule_id",nullable=false)
	private TrainSchedule trainSchedule;
	
	@Column(name="train_schedule_turn_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date trainScheduleTurnDate;
	
	@Column(name="departure_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureTime;
	
	@Column(name="arrival_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalTime;
	
	@OneToMany(mappedBy = "trainScheduleTurn", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<TrainStationScheduleTurn> trainStationScheduleTurn;
	
	@OneToMany(mappedBy = "trainScheduleTurn", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<TrainScheduleTurnLocationUpdate> trainScheduleTurnLocationUpdates;
	
	@OneToMany(mappedBy = "trainScheduleTurn", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<TrainScheduleTurnLocationPassiveUpdate> trainScheduleTurnLocationPassiveUpdates;
	
	@OneToMany(mappedBy = "trainScheduleTurn", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<TrainScheduleTurnCompartmentUpdate> trainScheduleTurnCompartmentUpdates;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	

	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("trainScheduleTurnId", trainScheduleTurnId);
		map.put("trainSchedule", trainSchedule);
		map.put("trainScheduleTurnDate", trainScheduleTurnDate);
		map.put("departureTime", departureTime);
		map.put("arrivalTime", arrivalTime);
		map.put("trainStationScheduleTurn", trainStationScheduleTurn);
		map.put("activeStatus", activeStatus);
		map.put("arrivalTime", arrivalTime);
		map.put("versionId", versionId);
		return map;
	}
	
	@Override
	public String toString() {
		return this.trainScheduleTurnId + "";
	}

	public TrainSchedule getTrainSchedule() {
		return trainSchedule;
	}

	public void setTrainSchedule(TrainSchedule trainSchedule) {
		this.trainSchedule = trainSchedule;
	}

	
	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public List<TrainStationScheduleTurn> getTrainStationScheduleTurn() {
		return trainStationScheduleTurn;
	}

	public void setTrainStationScheduleTurn(List<TrainStationScheduleTurn> trainStationScheduleTurn) {
		this.trainStationScheduleTurn = trainStationScheduleTurn;
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

	public long getTrainScheduleTurnId() {
		return trainScheduleTurnId;
	}

	public void setTrainScheduleTurnId(long trainScheduleTurnId) {
		this.trainScheduleTurnId = trainScheduleTurnId;
	}

	public Date getTrainScheduleTurnDate() {
		return trainScheduleTurnDate;
	}

	public void setTrainScheduleTurnDate(Date trainScheduleTurnDate) {
		this.trainScheduleTurnDate = trainScheduleTurnDate;
	}

	public List<TrainScheduleTurnLocationUpdate> getTrainScheduleTurnLocationUpdates() {
		return trainScheduleTurnLocationUpdates;
	}

	public void setTrainScheduleTurnLocationUpdates(
			List<TrainScheduleTurnLocationUpdate> trainScheduleTurnLocationUpdates) {
		this.trainScheduleTurnLocationUpdates = trainScheduleTurnLocationUpdates;
	}

	public List<TrainScheduleTurnLocationPassiveUpdate> getTrainScheduleTurnLocationPassiveUpdates() {
		return trainScheduleTurnLocationPassiveUpdates;
	}

	public void setTrainScheduleTurnLocationPassiveUpdates(
			List<TrainScheduleTurnLocationPassiveUpdate> trainScheduleTurnLocationPassiveUpdates) {
		this.trainScheduleTurnLocationPassiveUpdates = trainScheduleTurnLocationPassiveUpdates;
	}

	public List<TrainScheduleTurnCompartmentUpdate> getTrainScheduleTurnCompartmentUpdates() {
		return trainScheduleTurnCompartmentUpdates;
	}

	public void setTrainScheduleTurnCompartmentUpdates(
			List<TrainScheduleTurnCompartmentUpdate> trainScheduleTurnCompartmentUpdates) {
		this.trainScheduleTurnCompartmentUpdates = trainScheduleTurnCompartmentUpdates;
	}

	
	



	
	

}
