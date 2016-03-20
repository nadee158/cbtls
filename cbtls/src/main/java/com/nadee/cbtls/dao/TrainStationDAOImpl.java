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
import com.nadee.cbtls.model.TrainLineStation;
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

	@Override
	public TrainStation getTrainStationByName(String trainStationName) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainStation.class);
		criteria.add(Restrictions.ilike("trainStationName",trainStationName,MatchMode.EXACT));
		return (TrainStation) criteria.uniqueResult();
	}

	@Override
	public TrainStation getTrainStationByCode(String trainStationCode) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainStation.class);
		criteria.add(Restrictions.ilike("trainStationCode",trainStationCode,MatchMode.EXACT));
		return (TrainStation) criteria.uniqueResult();
	}

	@Override
	public TrainLineStation getTrainLineStationByStationAndTrainLine(long trainStationId, long trainLineId)
			throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainLineStation.class);
		criteria.createAlias("trainStation", "trainStation");
		criteria.createAlias("trainLine", "trainLine");
		criteria.add(Restrictions.eq("trainStation.trainStationId",trainStationId));
		criteria.add(Restrictions.eq("trainLine.trainLineId",trainLineId));
		return (TrainLineStation) criteria.uniqueResult();
	}

}
