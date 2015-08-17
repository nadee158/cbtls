package com.nadee.cbtls.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;

@Entity(name="trainType")
@Table(name = "train_type", uniqueConstraints =@UniqueConstraint(columnNames = "train_type_id"))
public class TrainType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "train_type_id", nullable = false)
	private long trainTypeId;
	
	@Column(name = "train_type_name")
	private String trainTypeName;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	
	@Version
    @Column(name = "version_id")
	private int versionId;
	
	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("trainTypeId", trainTypeId);
		map.put("trainTypeName", trainTypeName);
		map.put("activeStatus", activeStatus);
		map.put("versionId", versionId);
		return map;
	}
	
	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}

	public long getTrainTypeId() {
		return trainTypeId;
	}

	public void setTrainTypeId(long trainTypeId) {
		this.trainTypeId = trainTypeId;
	}

	public String getTrainTypeName() {
		return trainTypeName;
	}

	public void setTrainTypeName(String trainTypeName) {
		this.trainTypeName = trainTypeName;
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



	
	

}
