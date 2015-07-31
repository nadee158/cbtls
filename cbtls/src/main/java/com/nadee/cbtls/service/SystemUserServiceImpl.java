package com.nadee.cbtls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.util.EncryptionUtil;

@Service("systemUserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class SystemUserServiceImpl implements SystemUserService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	public SystemUserServiceImpl(){}
	
	@Override
	public long saveSystemUser(SystemUser systemUser) {
		systemUser.setActiveStatus(YesNoStatus.YES);
		systemUser.setPassword(EncryptionUtil.getInstance().encrypt(systemUser.getPassword()));
		return commonDAO.<SystemUser> createEntity(systemUser);
	}


	
	
}
