package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.Date;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.SystemUserRankings;

public class SystemUserRankingsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long systemUserRankingId;
	
	private int ranking;
	
	private long rankedUser;
	
	private Date rankedDate;
	
	private float averageRate;
	
	private YesNoStatus activeStatus;
	
	private long systemUserId;
	
	private int versionId;
	
	private String systemUserMobileDevice;
	
	private long updatedUser;
	
	private String comment;
	  

	public SystemUserRankingsDTO(SystemUserRankings systemUserRankings) {
		this.systemUserRankingId=systemUserRankings.getSystemUserRankingId();
		this.ranking=systemUserRankings.getRanking();
		this.rankedUser=systemUserRankings.getRankedUser();
		this.rankedDate=systemUserRankings.getRankedDate();
		this.averageRate=systemUserRankings.getAverageRate();
		this.activeStatus=systemUserRankings.getActiveStatus();
		if(!(systemUserRankings.getSystemUser()==null)){
		  this.systemUserId=systemUserRankings.getSystemUser().getUserId();
		}
		this.versionId=systemUserRankings.getVersionId();
		this.updatedUser=systemUserRankings.getRankedUser();
		this.comment=systemUserRankings.getComment();
	}

	public SystemUserRankingsDTO(UserRankDTO dtoUi) {
	  this.ranking=dtoUi.getRanking();
	  this.comment=dtoUi.getComment();
	  this.systemUserId=dtoUi.getSystemUserId();
  }
	
	public SystemUserRankingsDTO() {
	    // TODO Auto-generated constructor stub
	  }

  public long getSystemUserRankingId() {
		return systemUserRankingId;
	}

	public void setSystemUserRankingId(long systemUserRankingId) {
		this.systemUserRankingId = systemUserRankingId;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public long getRankedUser() {
		return rankedUser;
	}

	public void setRankedUser(long rankedUser) {
		this.rankedUser = rankedUser;
	}

	public Date getRankedDate() {
		return rankedDate;
	}

	public void setRankedDate(Date rankedDate) {
		this.rankedDate = rankedDate;
	}

	public float getAverageRate() {
		return averageRate;
	}

	public void setAverageRate(float averageRate) {
		this.averageRate = averageRate;
	}

	public YesNoStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(YesNoStatus activeStatus) {
		this.activeStatus = activeStatus;
	}

	public long getSystemUserId() {
		return systemUserId;
	}

	public void setSystemUserId(long systemUserId) {
		this.systemUserId = systemUserId;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public String getSystemUserMobileDevice() {
		return systemUserMobileDevice;
	}

	public void setSystemUserMobileDevice(String systemUserMobileDevice) {
		this.systemUserMobileDevice = systemUserMobileDevice;
	}

  public long getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(long updatedUser) {
    this.updatedUser = updatedUser;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
	
	

}
