package com.nadee.cbtls.dto;

import java.io.Serializable;

public class UserRankDTO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String comment;

  private int ranking;

  private long systemUserId;

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public int getRanking() {
    return ranking;
  }

  public void setRanking(int ranking) {
    this.ranking = ranking;
  }

  public long getSystemUserId() {
    return systemUserId;
  }

  public void setSystemUserId(long systemUserId) {
    this.systemUserId = systemUserId;
  }



}
