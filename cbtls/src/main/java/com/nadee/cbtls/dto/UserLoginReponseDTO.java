package com.nadee.cbtls.dto;

import java.io.Serializable;

public class UserLoginReponseDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String status;

  private String userType;

  private String userId;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }



}
