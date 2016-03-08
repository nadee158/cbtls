package com.nadee.cbtls.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainScheduleTurn;

@Repository(value="trainScheduleTurnDAO")
public class TrainScheduleTurnDAOImpl implements TrainScheduleTurnDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long countActiveTrainScheduleTurns() throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainScheduleTurn.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		criteria.setProjection(Projections.countDistinct("trainScheduleTurnId"));
		return (long) criteria.uniqueResult();
	}

	@Override
	public List<TrainScheduleTurn> listAllTrainScheduleTurns(YesNoStatus yesNoStatus) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainScheduleTurn.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		return criteria.list();
	}

}
