package com.nadee.cbtls.dao;

import com.nadee.cbtls.model.SystemUser;

public interface SystemUserDAO {
	
	public SystemUser getSystemUserByUserName(String userName);

}
