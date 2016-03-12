package com.nadee.cbtls.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainStationSchedule;

@Repository(value="trainStationScheduleDAO")
public class TrainStationScheduleDAOImpl implements TrainStationScheduleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long countActiveTrainStationSchedules() throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainStationSchedule.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		criteria.setProjection(Projections.countDistinct("trainStationScheduleId"));
		return (long) criteria.uniqueResult();
	}

	@Override
	public List<TrainStationSchedule> listAllTrainStationSchedule(YesNoStatus yesNoStatus) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainStationSchedule.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		return criteria.list();
	}

	@Override
	public TrainStationSchedule fetchTrainStationSchedule(long trainScheduleId, long fromStationId, long toStationId,
			Date arrivalTime, Date departureTime) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainStationSchedule.class);
		criteria.createAlias("trainSchedule", "trainSchedule");
		criteria.createAlias("fromTrainStation", "fromTrainStation");
		criteria.createAlias("toTrainStation", "toTrainStation");
		criteria.add(Restrictions.eq("arrivalTime",arrivalTime));
		criteria.add(Restrictions.eq("departureTime",departureTime));
		criteria.add(Restrictions.eq("fromTrainStation.trainStationId",fromStationId));
		criteria.add(Restrictions.eq("toTrainStation.trainStationId",toStationId));
		criteria.add(Restrictions.eq("trainSchedule.trainScheduleId",trainScheduleId));
		TrainStationSchedule trainStationSchedule= (TrainStationSchedule) criteria.uniqueResult();
		return trainStationSchedule;
	}

}
