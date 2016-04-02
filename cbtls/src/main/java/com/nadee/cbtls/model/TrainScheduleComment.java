package com.nadee.cbtls.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.TrainScheduleCommentDTO;

@Entity(name = "trainScheduleComment")
@Table(name = "train_schedule_comment",
    uniqueConstraints = @UniqueConstraint(columnNames = "train_schedule_comment_id"))
public class TrainScheduleComment implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "train_schedule_comment_id", nullable = false)
  private long trainScheduleCommentId;

  @Column(name = "train_schedule_id")
  private long trainScheduleId;

  @Column(name = "train_station_schedule_id")
  private long trainStationScheduleId;

  @Column(name = "updated_user_id")
  private long updatedUserId;

  @Column(name = "updated_user_name")
  private String updatedUserName;

  @Column(name = "updated_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedDate;

  @Column(name = "rating")
  private int rating;

  @Column(name = "comment")
  private String comment;

  @Enumerated(EnumType.STRING)
  @Column(name = "active_status")
  private YesNoStatus activeStatus;

  @Version
  @Column(name = "version_id")
  private int versionId;



  public TrainScheduleComment(TrainScheduleCommentDTO dto) {
    super();
    this.trainScheduleId = dto.getTrainScheduleId();
    this.trainStationScheduleId = dto.getTrainStationScheduleId();
    this.updatedUserId = dto.getUpdatedUser();
    this.updatedUserName = dto.getUpdatedUserName();
    this.updatedDate = Calendar.getInstance().getTime();
    this.rating = dto.getRating();
    this.comment = dto.getComment();
    this.activeStatus = YesNoStatus.YES;
  }



  public TrainScheduleComment(long trainScheduleCommentId, long trainScheduleId,
      long trainStationScheduleId, long updatedUserId, String updatedUserName, Date updatedDate,
      int rating, String comment, YesNoStatus activeStatus, int versionId) {
    super();
    this.trainScheduleCommentId = trainScheduleCommentId;
    this.trainScheduleId = trainScheduleId;
    this.trainStationScheduleId = trainStationScheduleId;
    this.updatedUserId = updatedUserId;
    this.updatedUserName = updatedUserName;
    this.updatedDate = updatedDate;
    this.rating = rating;
    this.comment = comment;
    this.activeStatus = activeStatus;
    this.versionId = versionId;
  }



  public TrainScheduleComment() {
    // TODO Auto-generated constructor stub
  }

  public long getTrainScheduleCommentId() {
    return trainScheduleCommentId;
  }

  public void setTrainScheduleCommentId(long trainScheduleCommentId) {
    this.trainScheduleCommentId = trainScheduleCommentId;
  }

  public long getTrainScheduleId() {
    return trainScheduleId;
  }

  public void setTrainScheduleId(long trainScheduleId) {
    this.trainScheduleId = trainScheduleId;
  }

  public long getTrainStationScheduleId() {
    return trainStationScheduleId;
  }

  public void setTrainStationScheduleId(long trainStationScheduleId) {
    this.trainStationScheduleId = trainStationScheduleId;
  }


  public long getUpdatedUserId() {
    return updatedUserId;
  }

  public void setUpdatedUserId(long updatedUserId) {
    this.updatedUserId = updatedUserId;
  }

  public String getUpdatedUserName() {
    return updatedUserName;
  }

  public void setUpdatedUserName(String updatedUserName) {
    this.updatedUserName = updatedUserName;
  }

  public Date getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
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

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }



}
