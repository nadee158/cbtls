package com.nadee.cbtls.dao;

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

@Repository(value="systemUserDAO")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class SystemUserDAOImpl implements SystemUserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public SystemUser getSystemUserByUserName(String userName) {
		System.out.println("CAME HERE IN TO DAO");
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SystemUser.class);
		criteria.add(Restrictions.ilike("userName", userName, MatchMode.EXACT));
		SystemUser systemUser=(SystemUser) criteria.uniqueResult();
		if(!(systemUser==null)){
			if(systemUser.getUserRoles()==null){
				Hibernate.initialize(systemUser.getUserRoles());
			}
		}
		//System.out.println("systemUser :" + systemUser);
		return systemUser;
	}

}
