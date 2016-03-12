package com.nadee.cbtls.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nadee.cbtls.constant.GeneralEnumConstants.TrainFrequency;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainStationSchedule;

@Repository(value="trainScheduleDAO")
public class TrainScheduleDAOImpl implements TrainScheduleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long countActiveTrainSchedules() throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainSchedule.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		criteria.setProjection(Projections.countDistinct("trainScheduleId"));
		return (long) criteria.uniqueResult();
	}

	@Override
	public List<TrainSchedule> listAllTrainSchedules(YesNoStatus yesNoStatus) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainSchedule.class);
		criteria.add(Restrictions.eq("activeStatus",YesNoStatus.YES));
		return criteria.list();
	}

	@Override
	public TrainSchedule fetchTrainSchedule(String trainNumber, TrainFrequency trainFrequency,String startStationName, String endStationName,
			String trainTypeName) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainSchedule.class);
		criteria.createAlias("startStation", "startStation");
		criteria.createAlias("endStation", "endStation");
		criteria.createAlias("trainType", "trainType");
		criteria.add(Restrictions.eq("trainNumber",trainNumber));
		criteria.add(Restrictions.eq("trainFrequency",trainFrequency));
		criteria.add(Restrictions.eq("startStation.trainStationName",startStationName));
		criteria.add(Restrictions.eq("endStation.trainStationName",endStationName));
		criteria.add(Restrictions.eq("trainType.trainTypeName",trainTypeName));
		TrainSchedule trainSchedule= (TrainSchedule) criteria.uniqueResult();
		if(!(trainSchedule==null)){
			trainSchedule.getTrainStationSchedules();
			if(!(trainSchedule.getTrainStationSchedules()==null || trainSchedule.getTrainStationSchedules().isEmpty())){
				for (TrainStationSchedule trainStationSchedule : trainSchedule.getTrainStationSchedules()) {
					
					System.out.println("trainStationSchedule.getTrainStationScheduleId(); " + trainStationSchedule.getTrainStationScheduleId());
				}
			}
		}
		
		return trainSchedule;
	}

}
