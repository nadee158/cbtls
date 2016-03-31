package com.nadee.cbtls.service;

import java.util.List;

import com.nadee.cbtls.constant.GeneralEnumConstants.UserRoleType;
import com.nadee.cbtls.dto.UserLoginReponseDTO;
import com.nadee.cbtls.dto.UserLoginRequestDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserFavouriteSchedules;
import com.nadee.cbtls.model.SystemUserMobileDevice;

public interface SystemUserService {


  public long saveSystemUser(SystemUser systemUser, UserRoleType userRoleType);

  public String updateSystemUser(SystemUser systemUser);

  public SystemUserMobileDevice createMobileUser(String userUniqueId, String password)
      throws Exception;

  public SystemUserMobileDevice getSystemUserMobileDeviceByUniqueId(String mobileUniqueId)
      throws Exception;

  public SystemUser createWebUser(String userUniqueId, String password) throws Exception;

  public List<SystemUserFavouriteSchedules> listFavouriteSchedules(long userId);

  public SystemUser getSystemUserById(long systemUserId);

  public UserLoginReponseDTO loginUser(UserLoginRequestDTO userLoginRequestDTO) throws Exception;

  public SystemUser getSystemUserByUserName(String userId) throws Exception;



}
