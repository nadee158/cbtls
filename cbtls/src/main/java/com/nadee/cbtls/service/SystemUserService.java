package com.nadee.cbtls.service;

import com.nadee.cbtls.constant.GeneralEnumConstants.UserRoleType;
import com.nadee.cbtls.model.SystemUser;

public interface SystemUserService {


	public long saveSystemUser(SystemUser systemUser, UserRoleType userRoleType);

	
	
	
	
}
