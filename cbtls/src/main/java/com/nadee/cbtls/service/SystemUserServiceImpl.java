package com.nadee.cbtls.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.UserRoleType;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.UserRole;

@Service("systemUserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class SystemUserServiceImpl implements SystemUserService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	public SystemUserServiceImpl(){}
	
	@Override
	public long saveSystemUser(SystemUser systemUser, UserRoleType userRoleType) {
		systemUser.setActiveStatus(YesNoStatus.YES);
		Md5PasswordEncoder encoder=new Md5PasswordEncoder();
		systemUser.setPassword(encoder.encodePassword(systemUser.getPassword(), null));
		List<UserRole> userRoles=new ArrayList<UserRole>();
		userRoles.add(new UserRole(userRoleType));
		systemUser.setUserRoles(userRoles);
		return commonDAO.<SystemUser> createEntity(systemUser);
	}


	
	
}
