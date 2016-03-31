package com.nadee.cbtls.dto;

import java.io.Serializable;

public class UserLoginRequestDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String userId;

  private String password;

  private String userType;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }



}
