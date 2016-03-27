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
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.nadee.cbtls.constant.GeneralEnumConstants.AlarmType;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;

/**
 * @author Nadeeshani
 *
 */
@Entity(name="systemUserAlarm")
@Table(name = "system_user_alarm")
public class SystemUserAlarm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "system_user_alarm_id", nullable = false)
	private long systemUserAlarmId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_user_mobile_device_id", referencedColumnName = "system_user_mobile_device_id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private SystemUserMobileDevice systemUserMobileDevice;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private SystemUser systemUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_station_id", referencedColumnName = "train_station_id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private TrainStation destinationStation;
	
	@Enumerated(EnumType.STRING)
    @Column(name="alarm_type")
	private AlarmType alarmType;
	
	@Column(name="distance_to_station")
	private float distanceToStation;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	
	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("systemUserAlarmId", systemUserAlarmId);
		map.put("systemUserMobileDevice", systemUserMobileDevice);
		map.put("destinationStation", destinationStation);
		map.put("alarmType", alarmType);
		map.put("distanceToStation", distanceToStation);
		map.put("activeStatus", activeStatus);
		map.put("versionId", versionId);
		return map;
	}
	
	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}

	public long getSystemUserAlarmId() {
		return systemUserAlarmId;
	}

	public void setSystemUserAlarmId(long systemUserAlarmId) {
		this.systemUserAlarmId = systemUserAlarmId;
	}

	public SystemUserMobileDevice getSystemUserMobileDevice() {
		return systemUserMobileDevice;
	}

	public void setSystemUserMobileDevice(SystemUserMobileDevice systemUserMobileDevice) {
		this.systemUserMobileDevice = systemUserMobileDevice;
	}

	public TrainStation getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(TrainStation destinationStation) {
		this.destinationStation = destinationStation;
	}

	public AlarmType getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(AlarmType alarmType) {
		this.alarmType = alarmType;
	}

	public float getDistanceToStation() {
		return distanceToStation;
	}

	public void setDistanceToStation(float distanceToStation) {
		this.distanceToStation = distanceToStation;
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

	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}
	

	

}
