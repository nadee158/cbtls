package com.nadee.cbtls.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nadee.cbtls.model.SystemUserRankings;

@Repository(value="systemUserRankingDAO")
public class SystemUserRankingDAOImpl implements SystemUserRankingDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SystemUserRankings> getSystemUserRankingsByUserId(long userId) {
		System.out.println("CAME HERE IN TO DAO");
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SystemUserRankings.class);
		criteria.createAlias("systemUser", "systemUser");
		criteria.add(Restrictions.eq("systemUser.userId", userId));
		return criteria.list();
	}
	
	

}
