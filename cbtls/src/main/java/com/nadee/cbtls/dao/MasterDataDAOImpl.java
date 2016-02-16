package com.nadee.cbtls.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.model.TrainType;

@Repository(value="masterDataDAO")
public class MasterDataDAOImpl implements MasterDataDAO {
	
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
	public long countActiveTrainLines() throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainLine.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		criteria.setProjection(Projections.countDistinct("trainLineId"));
		return (long) criteria.uniqueResult();
	}

	@Override
	public long countActiveTrainStations() throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainStation.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		criteria.setProjection(Projections.countDistinct("trainStationId"));
		return (long) criteria.uniqueResult();
	}

	@Override
	public long countActiveTrainSchedules() throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainSchedule.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		criteria.setProjection(Projections.countDistinct("trainScheduleId"));
		return (long) criteria.uniqueResult();
	}

	@Override
	public long countActiveTrainScheduleTurns() throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainScheduleTurn.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		criteria.setProjection(Projections.countDistinct("trainScheduleTurnId"));
		return (long) criteria.uniqueResult();
	}

	@Override
	public List<TrainType> listAllTrainTypes(YesNoStatus yesNoStatus) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainType.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		return criteria.list();
	}

	@Override
	public List<TrainLine> listAllTrainLines(YesNoStatus yesNoStatus) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainLine.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		return criteria.list();
	}

	@Override
	public List<TrainStation> listAllTrainStations(YesNoStatus yesNoStatus) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainStation.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		return criteria.list();
	}

	@Override
	public List<TrainSchedule> listAllTrainSchedules(YesNoStatus yesNoStatus) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainSchedule.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		return criteria.list();
	}

	@Override
	public List<TrainScheduleTurn> listAllTrainScheduleTurns(YesNoStatus yesNoStatus) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainScheduleTurn.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		return criteria.list();
	}

}
