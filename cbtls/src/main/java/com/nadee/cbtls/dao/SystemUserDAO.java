package com.nadee.cbtls.dao;

import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserMobileDevice;

public interface SystemUserDAO {
	
	public SystemUser getSystemUserByUserName(String userName);

	public SystemUserMobileDevice getSystemUserMobileDeviceByUniqueId(String mobileUniqueId)throws Exception;

}
