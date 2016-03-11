package com.nadee.cbtls.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.SystemUserRankingsDTO;

/**
 * @author Nadeeshani
 *
 */
@Entity(name="systemUserRankings")
@Table(name = "system_user_rankings")
public class SystemUserRankings implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "system_user_ranking_id", nullable = false)
	private long systemUserRankingId;
	
	@Column(name = "ranking", nullable = false)
	private int ranking;
	
	@Column(name = "ranked_user", nullable = true)
	private long rankedUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ranked_date", nullable = true)
	private Date rankedDate;
	
	@Column(name = "average_rate", nullable = false)
	private float averageRate;
	
	@Enumerated(EnumType.STRING)
    @Column(name="active_status")
	private YesNoStatus activeStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_user_id", referencedColumnName = "user_id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private SystemUser systemUser;
	
	@Version
    @Column(name = "version_id")
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

	

	public SystemUserRankings(SystemUserRankingsDTO systemUserRankingsDTO) {
		super();
		this.ranking = systemUserRankingsDTO.getRanking();
		this.rankedUser = systemUserRankingsDTO.getRankedUser();
	}

	public SystemUserRankings() {
		super();
	}
	
	

	

}
