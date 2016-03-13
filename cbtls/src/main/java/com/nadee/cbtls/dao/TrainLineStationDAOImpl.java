package com.nadee.cbtls.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nadee.cbtls.model.TrainLineStation;

@Repository(value="trainLineStationDAO")
public class TrainLineStationDAOImpl implements TrainLineStationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TrainLineStation> listAllTrainLineStationsByTrainLine(long trainLineId) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainLineStation.class);
		criteria.createAlias("trainLine", "trainLine");
		criteria.add(Restrictions.eq("trainLine.trainLineId",trainLineId));
		return (List<TrainLineStation>) criteria.list();
	}

}
