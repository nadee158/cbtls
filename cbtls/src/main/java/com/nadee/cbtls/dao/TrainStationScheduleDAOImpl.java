package com.nadee.cbtls.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nadee.cbtls.constant.GeneralEnumConstants.TrainFrequency;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.TrainScheduleSearchDTO;
import com.nadee.cbtls.model.TicketPrice;
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

	@Override
	public List<TrainStationSchedule> serachTrainStationSchedules(TrainScheduleSearchDTO trainScheduleSearchDTO)
			throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainStationSchedule.class);
		criteria.createAlias("trainSchedule", "trainSchedule");
		criteria.createAlias("fromTrainStation", "fromTrainStation");
		criteria.createAlias("toTrainStation", "toTrainStation");
		
		Conjunction and=Restrictions.conjunction();
		and.add(Restrictions.ge("arrivalTime",trainScheduleSearchDTO.retieveFromTime()));
		and.add(Restrictions.le("departureTime",trainScheduleSearchDTO.retieveToTime()));
		and.add(Restrictions.eq("fromTrainStation.trainStationId",trainScheduleSearchDTO.getFromStationId()));
		and.add(Restrictions.eq("toTrainStation.trainStationId",trainScheduleSearchDTO.getToStationId()));
		criteria.add(and);
		
		List<TrainFrequency> list=trainScheduleSearchDTO.retrieveTrainFrequencies();
		if(!(list==null || list.isEmpty())){
			Disjunction or = Restrictions.disjunction();
			for (TrainFrequency trainFrequency : list) {
				or.add(Restrictions.eq("trainSchedule.trainFrequency",trainFrequency));
			}
			criteria.add(or);
		}
		return criteria.list();
	}

	@Override
	public List<TicketPrice> getTicketPrices(long trainStationScheduleId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TicketPrice.class);
		criteria.createAlias("trainStationSchedule", "trainStationSchedule");
		criteria.add(Restrictions.eq("trainStationSchedule.trainStationScheduleId",trainStationScheduleId));
		return criteria.list();
	}

}
