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

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;

/**
 * @author Nadeeshani
 *
 */
@Entity(name="systemUserMobileDevice")
@Table(name = "system_user_mobile_device")
public class SystemUserMobileDevice implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "system_user_mobile_device_id", nullable = false)
	private long systemUserMobileDeviceId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mobile_device_id", referencedColumnName = "mobile_device_id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)	
	private MobileDevice mobileDevice;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_user_id", referencedColumnName = "user_id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private SystemUser systemUser;
	
	@Column(name="total_location_updates")
	private int totalLocationUpdates;
	
	@Column(name="total_crowd_density_updates")
	private int totalCrowdDensityUpdates;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	
	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("systemUserMobileDeviceId", systemUserMobileDeviceId);
		map.put("mobileDevice", mobileDevice);
		map.put("activeStatus", activeStatus);
		map.put("systemUser", systemUser);
		map.put("totalLocationUpdates", totalLocationUpdates);
		map.put("totalCrowdDensityUpdates", totalCrowdDensityUpdates);
		map.put("versionId", versionId);
		return map;
	}
	
	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}
	
	
	public long getSystemUserMobileDeviceId() {
		return systemUserMobileDeviceId;
	}
	public void setSystemUserMobileDeviceId(long systemUserMobileDeviceId) {
		this.systemUserMobileDeviceId = systemUserMobileDeviceId;
	}
	public MobileDevice getMobileDevice() {
		return mobileDevice;
	}
	public void setMobileDevice(MobileDevice mobileDevice) {
		this.mobileDevice = mobileDevice;
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

	public int getTotalLocationUpdates() {
		return totalLocationUpdates;
	}

	public void setTotalLocationUpdates(int totalLocationUpdates) {
		this.totalLocationUpdates = totalLocationUpdates;
	}

	public int getTotalCrowdDensityUpdates() {
		return totalCrowdDensityUpdates;
	}

	public void setTotalCrowdDensityUpdates(int totalCrowdDensityUpdates) {
		this.totalCrowdDensityUpdates = totalCrowdDensityUpdates;
	}
	
	

}
