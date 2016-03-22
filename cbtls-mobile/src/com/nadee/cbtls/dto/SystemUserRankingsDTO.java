package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.Date;

public class SystemUserRankingsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long systemUserRankingId;

	private int ranking;

	private long rankedUser;

	private Date rankedDate;

	private float averageRate;

	private String activeStatus;

	private long systemUserId;

	private int versionId;

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

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
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

}
