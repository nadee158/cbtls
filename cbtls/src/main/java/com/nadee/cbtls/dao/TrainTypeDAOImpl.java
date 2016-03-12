package com.nadee.cbtls.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainType;

@Repository(value="trainTypeDAO")
public class TrainTypeDAOImpl implements TrainTypeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public long countActiveTrainTypes() throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainType.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		criteria.setProjection(Projections.countDistinct("trainTypeId"));
		return (long) criteria.uniqueResult();
	}

	@Override
	public List<TrainType> listAllTrainTypes(YesNoStatus yesNoStatus) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainType.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		return criteria.list();
	}

	@Override
	public TrainType getTrainTypeByName(String trainTypeName) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainType.class);
		criteria.add(Restrictions.ilike("trainTypeName",trainTypeName,MatchMode.EXACT));
		return (TrainType) criteria.uniqueResult();
	}

}
