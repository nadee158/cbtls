package com.nadee.cbtls.dto;

import java.io.Serializable;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainLine;

public class TrainLineDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long trainLineId;
	
	private String trainLineName;
	
	private YesNoStatus activeStatus;

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

	public TrainLineDTO(TrainLine trainLine) {
		super();
		this.trainLineId = trainLine.getTrainLineId();
		this.trainLineName = trainLine.getTrainLineName();
		this.activeStatus = trainLine.getActiveStatus();
	}
	
	

}
