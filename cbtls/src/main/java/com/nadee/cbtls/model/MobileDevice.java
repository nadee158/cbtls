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

@Entity(name="mobileDevice")
@Table(name = "mobile_device", uniqueConstraints =@UniqueConstraint(columnNames = "unique_mobile_device_number"))
public class MobileDevice implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mobile_device_id", nullable = false)
	private long mobileDeviceId;
	
	@Column(name = "unique_mobile_device_number")
	private String uniqueMobileDeviceNumber;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@OneToMany(mappedBy = "mobileDevice", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<SystemUserMobileDevice> systemUserMobileDevices;
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	
	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("mobileDeviceId", mobileDeviceId);
		map.put("uniqueMobileDeviceNumber", uniqueMobileDeviceNumber);
		map.put("activeStatus", activeStatus);
		map.put("systemUserMobileDevices", systemUserMobileDevices);
		map.put("versionId", versionId);
		return map;
	}
	
	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}


	public long getMobileDeviceId() {
		return mobileDeviceId;
	}

	public void setMobileDeviceId(long mobileDeviceId) {
		this.mobileDeviceId = mobileDeviceId;
	}

	public String getUniqueMobileDeviceNumber() {
		return uniqueMobileDeviceNumber;
	}

	public void setUniqueMobileDeviceNumber(String uniqueMobileDeviceNumber) {
		this.uniqueMobileDeviceNumber = uniqueMobileDeviceNumber;
	}

	public YesNoStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(YesNoStatus activeStatus) {
		this.activeStatus = activeStatus;
	}

	public List<SystemUserMobileDevice> getSystemUserMobileDevices() {
		return systemUserMobileDevices;
	}

	public void setSystemUserMobileDevices(List<SystemUserMobileDevice> systemUserMobileDevices) {
		this.systemUserMobileDevices = systemUserMobileDevices;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	
	

}
