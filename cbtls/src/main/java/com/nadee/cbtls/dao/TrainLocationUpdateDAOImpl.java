package com.nadee.cbtls.dao;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainScheduleTurnCompartmentUpdate;
import com.nadee.cbtls.model.TrainScheduleTurnLocationPassiveUpdate;
import com.nadee.cbtls.model.TrainScheduleTurnLocationUpdate;
import com.nadee.cbtls.model.TrainStationScheduleTurn;

@Repository(value="trainLocationUpdateDAO")
public class TrainLocationUpdateDAOImpl implements TrainLocationUpdateDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public TrainScheduleTurn fetchTrainScheduleTurn(long trainScheduleId, Date turnDate) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainScheduleTurn.class);
		criteria.createAlias("trainSchedule", "trainSchedule");
		criteria.add(Restrictions.eq("trainSchedule.trainScheduleId",trainScheduleId));
		System.out.println("turnDate :" + turnDate);
		
		Date fromDate=getMinTimedDate(turnDate);
		Date toDate=getMaxTimedDate(turnDate);
		
		System.out.println("fromDate :" + fromDate);
		System.out.println("toDate :" + toDate);
		
		criteria.add(Restrictions.ge("trainScheduleTurnDate", fromDate));
		criteria.add(Restrictions.le("trainScheduleTurnDate", toDate));
		TrainScheduleTurn trainScheduleTurn= (TrainScheduleTurn) criteria.uniqueResult();
		if(!(trainScheduleTurn==null)){
			if(!(trainScheduleTurn.getTrainScheduleTurnLocationUpdates()==null)){
				for (TrainScheduleTurnLocationUpdate trainScheduleTurnLocationUpdate : trainScheduleTurn.getTrainScheduleTurnLocationUpdates()) {
					System.out.println("trainScheduleTurnLocationUpdate.getId() " + trainScheduleTurnLocationUpdate.getId());
					if(!(trainScheduleTurnLocationUpdate.getUpdatedUser()==null)){
                      Hibernate.initialize(trainScheduleTurnLocationUpdate.getUpdatedUser());
                    }
				}
			}
			
			if(!(trainScheduleTurn.getTrainScheduleTurnLocationPassiveUpdates()==null)){
				for (TrainScheduleTurnLocationPassiveUpdate trainScheduleTurnLocationPassiveUpdate : trainScheduleTurn.getTrainScheduleTurnLocationPassiveUpdates()) {
					System.out.println("trainScheduleTurnLocationPassiveUpdate.getId() "+ trainScheduleTurnLocationPassiveUpdate.getId());
					if(!(trainScheduleTurnLocationPassiveUpdate.getUpdatedUser()==null)){
					  Hibernate.initialize(trainScheduleTurnLocationPassiveUpdate.getUpdatedUser());
					}
				}
			}
			
			if(!(trainScheduleTurn.getTrainStationScheduleTurn()==null)){
				for (TrainStationScheduleTurn trainStationScheduleTurn : trainScheduleTurn.getTrainStationScheduleTurn()) {
					System.out.println("trainStationScheduleTurn.getTrainStationScheduleTurnId() " + trainStationScheduleTurn.getTrainStationScheduleTurnId());
				}
			}
			
			if(!(trainScheduleTurn.getTrainScheduleTurnCompartmentUpdates()==null)){
				for (TrainScheduleTurnCompartmentUpdate trainScheduleTurnCompartmentUpdate : trainScheduleTurn.getTrainScheduleTurnCompartmentUpdates()) {
					System.out.println("trainScheduleTurnCompartmentUpdate.getId() " + trainScheduleTurnCompartmentUpdate.getId());
					if(!(trainScheduleTurnCompartmentUpdate.getUpdatedUser()==null)){
                      Hibernate.initialize(trainScheduleTurnCompartmentUpdate.getUpdatedUser());
                    }
				}
			}
		}
		
		return trainScheduleTurn;
	}
	
	@Override
	public TrainSchedule getTrainScheduleById(long trainScheduleId) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainSchedule.class);
		criteria.add(Restrictions.eq("trainScheduleId",trainScheduleId));
		TrainSchedule  trainSchedule= (TrainSchedule) criteria.uniqueResult();
		if(!(trainSchedule==null)){
			if(!(trainSchedule.getStartStation()==null)){
				Hibernate.initialize(trainSchedule.getStartStation());
			}
			if(!(trainSchedule.getEndStation()==null)){
				Hibernate.initialize(trainSchedule.getEndStation());
			}
		}
		return trainSchedule;
	}
	
	@Override
	public TrainStationScheduleTurn fetchTrainStationScheduleTurn(long trainScheduleTurnId, long trainStationScheduleId) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainStationScheduleTurn.class);
		criteria.createAlias("trainScheduleTurn", "trainScheduleTurn");
		criteria.createAlias("trainStationSchedule", "trainStationSchedule");
		criteria.add(Restrictions.eq("trainScheduleTurn.trainScheduleTurnId",trainScheduleTurnId));
		criteria.add(Restrictions.eq("trainStationSchedule.trainStationScheduleId",trainStationScheduleId));
		TrainStationScheduleTurn trainStationScheduleTurn= (TrainStationScheduleTurn) criteria.uniqueResult();
		return trainStationScheduleTurn;
	}

	private Date getMaxTimedDate(Date turnDate) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(turnDate);
		cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
		cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, cal.getActualMaximum(Calendar.MILLISECOND));
		return cal.getTime();
	}

	private Date getMinTimedDate(Date turnDate) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(turnDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, cal.getActualMinimum(Calendar.MINUTE));
		cal.set(Calendar.SECOND, cal.getActualMinimum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, cal.getActualMinimum(Calendar.MILLISECOND));
		return cal.getTime();
	}

}
