package com.nadee.cbtls.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserFavouriteSchedules;
import com.nadee.cbtls.model.SystemUserMobileDevice;

@Repository(value = "systemUserDAO")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SystemUserDAOImpl implements SystemUserDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
  public SystemUser getSystemUserByUserName(String userName) {
    System.out.println("CAME HERE IN TO DAO");
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SystemUser.class);
    criteria.add(Restrictions.ilike("userName", userName, MatchMode.EXACT));
    SystemUser systemUser = (SystemUser) criteria.uniqueResult();
    if (!(systemUser == null)) {
      if (systemUser.getUserRoles() == null) {
        Hibernate.initialize(systemUser.getUserRoles());
      }
    }
    // System.out.println("systemUser :" + systemUser);
    return systemUser;
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
  @Override
  public SystemUserMobileDevice getSystemUserMobileDeviceByUniqueId(String mobileUniqueId)
      throws Exception {
    Criteria criteria =
        sessionFactory.getCurrentSession().createCriteria(SystemUserMobileDevice.class);
    criteria.createAlias("mobileDevice", "mobileDevice");
    criteria.add(Restrictions.ilike("mobileDevice.uniqueMobileDeviceNumber", mobileUniqueId,
        MatchMode.EXACT));
    SystemUserMobileDevice systemUserMobileDevice =
        (SystemUserMobileDevice) criteria.uniqueResult();
    if (!(systemUserMobileDevice == null)) {
      if (systemUserMobileDevice.getSystemUser() == null) {
        Hibernate.initialize(systemUserMobileDevice.getSystemUser());
        if (systemUserMobileDevice.getSystemUser().getUserRoles() == null) {
          Hibernate.initialize(systemUserMobileDevice.getSystemUser().getUserRoles());
        }
      }

      if (systemUserMobileDevice.getMobileDevice() == null) {
        Hibernate.initialize(systemUserMobileDevice.getMobileDevice());
      }
    }
    // System.out.println("systemUser :" + systemUser);
    return systemUserMobileDevice;
  }

  @Override
  public List<SystemUserFavouriteSchedules> listFavouriteSchedules(long userId) {
    Criteria criteria =
        sessionFactory.getCurrentSession().createCriteria(SystemUserFavouriteSchedules.class);
    criteria.createAlias("systemUser", "systemUser");
    criteria.add(Restrictions.eq("systemUser.userId", userId));
    List<SystemUserFavouriteSchedules> systemUserFavouriteSchedules = criteria.list();
    if (!(systemUserFavouriteSchedules == null || systemUserFavouriteSchedules.isEmpty())) {
      for (SystemUserFavouriteSchedules systemUserFavouriteSchedule : systemUserFavouriteSchedules) {
        if (!(systemUserFavouriteSchedule.getTrainStationSchedule() == null)) {
          Hibernate.initialize(systemUserFavouriteSchedule.getTrainStationSchedule());
        }
      }
    }
    // System.out.println("systemUser :" + systemUser);
    return systemUserFavouriteSchedules;
  }

  @Override
  public List<SystemUser> listSystemUsers() throws Exception {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SystemUser.class);
    return criteria.list();
  }

}
