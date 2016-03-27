package com.nadee.cbtls.service;

import com.nadee.cbtls.constant.GeneralEnumConstants.UserRoleType;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserMobileDevice;

public interface SystemUserService {


	public long saveSystemUser(SystemUser systemUser, UserRoleType userRoleType);

	public String updateSystemUser(SystemUser systemUser);

	public SystemUserMobileDevice createMobileUser(String uniqueId)throws Exception;
	
	public SystemUserMobileDevice getSystemUserMobileDeviceByUniqueId(String mobileUniqueId)throws Exception;

	public SystemUser createWebUser()throws Exception;

	
	
	
	
}
