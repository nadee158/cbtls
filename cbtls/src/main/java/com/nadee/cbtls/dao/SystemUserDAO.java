package com.nadee.cbtls.dao;

import java.util.List;

import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserFavouriteSchedules;
import com.nadee.cbtls.model.SystemUserMobileDevice;

public interface SystemUserDAO {
	
	public SystemUser getSystemUserByUserName(String userName);

	public SystemUserMobileDevice getSystemUserMobileDeviceByUniqueId(String mobileUniqueId)throws Exception;

	public List<SystemUserFavouriteSchedules> listFavouriteSchedules(long userId);

}
