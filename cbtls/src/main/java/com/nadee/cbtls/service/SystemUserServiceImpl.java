package com.nadee.cbtls.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.constant.GeneralEnumConstants.PassengerType;
import com.nadee.cbtls.constant.GeneralEnumConstants.UserRoleType;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.SystemUserDAO;
import com.nadee.cbtls.dto.UserLoginReponseDTO;
import com.nadee.cbtls.dto.UserLoginRequestDTO;
import com.nadee.cbtls.model.MobileDevice;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserFavouriteSchedules;
import com.nadee.cbtls.model.SystemUserMobileDevice;
import com.nadee.cbtls.model.SystemUserRankings;
import com.nadee.cbtls.model.UserRole;

@Service("systemUserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class SystemUserServiceImpl implements SystemUserService {

  @Autowired
  private CommonDAO commonDAO;

  @Autowired
  private SystemUserDAO systemUserDAO;

  public SystemUserServiceImpl() {}

  @Override
  public long saveSystemUser(SystemUser systemUser, UserRoleType userRoleType) {
    systemUser.setActiveStatus(YesNoStatus.YES);
    Md5PasswordEncoder encoder = new Md5PasswordEncoder();
    systemUser.setPassword(encoder.encodePassword(systemUser.getPassword(), null));
    List<UserRole> userRoles = new ArrayList<UserRole>();
    userRoles.add(new UserRole(userRoleType));
    systemUser.setUserRoles(userRoles);
    return commonDAO.<SystemUser>createEntity(systemUser);
  }

  @Override
  public String updateSystemUser(SystemUser systemUser) {
    SystemUser userFromDB = commonDAO.getEntityById(SystemUser.class, systemUser.getUserId());
    if (!(userFromDB == null)) {
      userFromDB.updateUser(systemUser);
      return ApplicationConstants.SUCCESS;
    }
    return null;
  }

  @Override
  public SystemUserMobileDevice createMobileUser(String userUniqueId, String password)
      throws Exception {
    SystemUserMobileDevice systemUserMobileDevice = new SystemUserMobileDevice();
    systemUserMobileDevice.setActiveStatus(YesNoStatus.YES);
    MobileDevice mobileDevice = new MobileDevice();
    mobileDevice.setActiveStatus(YesNoStatus.YES);
    mobileDevice.setUniqueMobileDeviceNumber(userUniqueId);
    systemUserMobileDevice.setMobileDevice(mobileDevice);
    SystemUser systemUser = new SystemUser();
    systemUser.setActiveStatus(YesNoStatus.YES);
    systemUser.setEmailAddress(ApplicationConstants.ANNONYMOUS_MOBILE_USER);
    systemUser.setPassengerType(PassengerType.DAILY);
    if (StringUtils.isEmpty(password)) {
      Md5PasswordEncoder encoder = new Md5PasswordEncoder();
      systemUser.setPassword(encoder.encodePassword(userUniqueId, null));
    } else {
      Md5PasswordEncoder encoder = new Md5PasswordEncoder();
      systemUser.setPassword(encoder.encodePassword(password, null));
    }

    systemUser.setSystemUserMobileDevices(new ArrayList<SystemUserMobileDevice>());
    systemUser.getSystemUserMobileDevices().add(systemUserMobileDevice);
    systemUserMobileDevice.setSystemUser(systemUser);
    systemUser.setUserDisplayName(ApplicationConstants.ANNONYMOUS_MOBILE_USER);
    systemUser.setUserName(ApplicationConstants.ANNONYMOUS_MOBILE_USER + "_" + userUniqueId);
    List<UserRole> userRoles = new ArrayList<UserRole>();
    userRoles.add(new UserRole(UserRoleType.ROLE_GUEST));
    userRoles.add(new UserRole(UserRoleType.ROLE_PASSENGER));
    systemUser.setUserRoles(userRoles);
    systemUser.setTotalNumberOfFeedBacks(1);
    long userId = commonDAO.createEntity(systemUser);
    systemUser.setUserId(userId);
    return getSystemUserMobileDeviceByUniqueId(userUniqueId);
  }

  public SystemUserMobileDevice getSystemUserMobileDeviceByUniqueId(String mobileUniqueId)
      throws Exception {
    return systemUserDAO.getSystemUserMobileDeviceByUniqueId(mobileUniqueId);
  }

  @Override
  public SystemUser createWebUser(String userUniqueId, String password) throws Exception {
    if (StringUtils.isEmpty(userUniqueId)) {
      userUniqueId = UUID.randomUUID().toString();
    }
    SystemUser systemUser = new SystemUser();
    systemUser.setActiveStatus(YesNoStatus.YES);
    systemUser.setEmailAddress(ApplicationConstants.ANNONYMOUS_WEB_USER);
    systemUser.setPassengerType(PassengerType.DAILY);
    if (StringUtils.isEmpty(password)) {
      Md5PasswordEncoder encoder = new Md5PasswordEncoder();
      systemUser.setPassword(encoder.encodePassword(userUniqueId, null));
    } else {
      Md5PasswordEncoder encoder = new Md5PasswordEncoder();
      systemUser.setPassword(encoder.encodePassword(password, null));
    }
    List<UserRole> userRoles = new ArrayList<UserRole>();
    userRoles.add(new UserRole(UserRoleType.ROLE_GUEST));
    userRoles.add(new UserRole(UserRoleType.ROLE_PASSENGER));
    systemUser.setUserDisplayName(ApplicationConstants.ANNONYMOUS_WEB_USER);
    systemUser.setUserName(ApplicationConstants.ANNONYMOUS_WEB_USER + "_" + userUniqueId);
    systemUser.setUserRoles(userRoles);
    systemUser.setTotalNumberOfFeedBacks(1);
    long userId = commonDAO.createEntity(systemUser);
    systemUser.setUserId(userId);
    return systemUser;
  }

  @Override
  public List<SystemUserFavouriteSchedules> listFavouriteSchedules(long userId) {
    return systemUserDAO.listFavouriteSchedules(userId);
  }

  @Override
  public SystemUser getSystemUserById(long systemUserId) {
    return commonDAO.getEntityById(SystemUser.class, systemUserId);
  }

  @Override
  public UserLoginReponseDTO loginUser(UserLoginRequestDTO userLoginRequestDTO) throws Exception {
    UserLoginReponseDTO reponseDTO = new UserLoginReponseDTO();
    SystemUser systemUser = null;
    if (StringUtils.equals(userLoginRequestDTO.getUserType(), ApplicationConstants.MOBILE_USER)) {
      SystemUserMobileDevice systemUserMobileDevice =
          systemUserDAO.getSystemUserMobileDeviceByUniqueId(userLoginRequestDTO.getUserId());
      if (!(systemUserMobileDevice == null)) {
        systemUser = systemUserMobileDevice.getSystemUser();
      }
    } else {
      systemUser = systemUserDAO.getSystemUserByUserName(userLoginRequestDTO.getUserId());
    }

    if (systemUser == null) {
      if (StringUtils.equals(userLoginRequestDTO.getUserType(), ApplicationConstants.MOBILE_USER)) {
        createMobileUser(userLoginRequestDTO.getUserId(), userLoginRequestDTO.getPassword());
      } else {
        createWebUser(userLoginRequestDTO.getUserId(), userLoginRequestDTO.getPassword());
      }
      reponseDTO.setStatus(ApplicationConstants.NEW_USER_CREATED);
    } else {
      Md5PasswordEncoder encoder = new Md5PasswordEncoder();
      String encryptedPassword = encoder.encodePassword(userLoginRequestDTO.getPassword(), null);
      if (StringUtils.equals(encryptedPassword, userLoginRequestDTO.getPassword())) {
        reponseDTO.setStatus(ApplicationConstants.SUCCESS);
      } else {
        reponseDTO.setStatus(ApplicationConstants.LOGIN_FAILED);
      }
    }
    reponseDTO.setUserId(userLoginRequestDTO.getUserId());
    reponseDTO.setUserType(userLoginRequestDTO.getUserType());
    return reponseDTO;
  }

  @Override
  public SystemUser getSystemUserByUserName(String userId) throws Exception {
    return systemUserDAO.getSystemUserByUserName(userId);
  }

  @Override
  public List<SystemUser> listSystemUsers() throws Exception {
    return systemUserDAO.listSystemUsers();
  }

  @Override
  public List<SystemUserRankings> listSystemUserFeedBacks(long userId) throws Exception {
    return systemUserDAO.listSystemUserFeedBacks(userId);
  }


}
