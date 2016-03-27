package com.nadee.cbtls.model;

import java.io.Serializable;

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
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;

/**
 * @author Nadeeshani
 *
 */
@Entity(name="systemUserFavouriteSchedules")
@Table(name = "system_user_favourite_schedule")
public class SystemUserFavouriteSchedules implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "system_user_favourite_schedule_id", nullable = false)
	private long systemUserFavouriteScheduleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_station_schedule_id", referencedColumnName = "train_station_schedule_id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)	
	private TrainStationSchedule trainStationSchedule;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_user_id", referencedColumnName = "user_id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private SystemUser systemUser;
		
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	
	
	
	@Override
	public String toString() {
		return "SystemUserFavouriteSchedules [systemUserFavouriteScheduleId=" + systemUserFavouriteScheduleId
				+ ", trainStationSchedule=" + trainStationSchedule + ", systemUser=" + systemUser + ", activeStatus="
				+ activeStatus + ", versionId=" + versionId + "]";
	}
	public SystemUser getSystemUser() {
		return systemUser;
	}
	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
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

	public long getSystemUserFavouriteScheduleId() {
		return systemUserFavouriteScheduleId;
	}

	public void setSystemUserFavouriteScheduleId(long systemUserFavouriteScheduleId) {
		this.systemUserFavouriteScheduleId = systemUserFavouriteScheduleId;
	}
	public TrainStationSchedule getTrainStationSchedule() {
		return trainStationSchedule;
	}
	public void setTrainStationSchedule(TrainStationSchedule trainStationSchedule) {
		this.trainStationSchedule = trainStationSchedule;
	}


	
	

}
