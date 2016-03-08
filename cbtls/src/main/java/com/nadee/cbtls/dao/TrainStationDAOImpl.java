package com.nadee.cbtls.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainStation;

@Repository(value="trainStationDAO")
public class TrainStationDAOImpl implements TrainStationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long countActiveTrainStations() throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainStation.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		criteria.setProjection(Projections.countDistinct("trainStationId"));
		return (long) criteria.uniqueResult();
	}

	@Override
	public List<TrainStation> listAllTrainStations(YesNoStatus yesNoStatus) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainStation.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		return criteria.list();
	}

}
