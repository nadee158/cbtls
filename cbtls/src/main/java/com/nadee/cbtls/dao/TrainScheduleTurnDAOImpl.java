package com.nadee.cbtls.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.AdminSearchDTO;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainScheduleTurnLocationUpdate;
import com.nadee.cbtls.model.TrainStationScheduleTurn;

@Repository(value = "trainScheduleTurnDAO")
public class TrainScheduleTurnDAOImpl implements TrainScheduleTurnDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public long countActiveTrainScheduleTurns() throws Exception {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainScheduleTurn.class);
    criteria.add(Restrictions.eq("activeStatus", YesNoStatus.YES));
    criteria.setProjection(Projections.countDistinct("trainScheduleTurnId"));
    return (long) criteria.uniqueResult();
  }

  @Override
  public List<TrainScheduleTurn> listAllTrainScheduleTurns(YesNoStatus yesNoStatus)
      throws Exception {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainScheduleTurn.class);
    criteria.add(Restrictions.eq("activeStatus", YesNoStatus.YES));
    return criteria.list();
  }

  @Override
  public List<TrainStationScheduleTurn> fetchTrainScheduleTurns(AdminSearchDTO adminSearchDTO)
      throws Exception {
    Criteria criteria =
        sessionFactory.getCurrentSession().createCriteria(TrainStationScheduleTurn.class);
    criteria.createAlias("trainStationSchedule", "trainStationSchedule");
    criteria.createAlias("trainStationSchedule.fromTrainStation", "fromTrainStation");
    criteria.createAlias("trainStationSchedule.toTrainStation", "toTrainStation");

    Conjunction and = Restrictions.conjunction();
    Date fromdate = getMinTimedDate(adminSearchDTO.retieveFromDate());
    System.out.println("fromdate :" + fromdate);
    Date toDate = getMaxTimedDate(adminSearchDTO.retieveToDate());
    System.out.println("toDate :" + toDate);

    System.out.println("adminSearchDTO.getFromStationId() :" + adminSearchDTO.getFromStationId());
    System.out.println("adminSearchDTO.getToStationId() :" + adminSearchDTO.getToStationId());

    and.add(Restrictions.ge("arrivalTime", fromdate));
    and.add(Restrictions.le("departureTime", toDate));
    and.add(Restrictions.eq("fromTrainStation.trainStationId", adminSearchDTO.getFromStationId()));
    and.add(Restrictions.eq("toTrainStation.trainStationId", adminSearchDTO.getToStationId()));
    criteria.add(and);


    List<TrainStationScheduleTurn> list = criteria.list();
    if (!(list == null || list.isEmpty())) {
      for (TrainStationScheduleTurn trainStationScheduleTurn : list) {
        if (!(trainStationScheduleTurn.getTrainStationSchedule() == null)) {
          Hibernate.initialize(trainStationScheduleTurn.getTrainStationSchedule());
        }

        if (!(trainStationScheduleTurn.getTrainScheduleTurn() == null)) {
          Hibernate.initialize(trainStationScheduleTurn.getTrainScheduleTurn());
          TrainScheduleTurn trainScheduleTurn = trainStationScheduleTurn.getTrainScheduleTurn();
          if (!(trainScheduleTurn.getTrainScheduleTurnLocationUpdates() == null)) {
            for (TrainScheduleTurnLocationUpdate update : trainScheduleTurn
                .getTrainScheduleTurnLocationUpdates()) {
              Hibernate.initialize(update);
            }
          }
        }

      }
    }
    return list;

  }

  @Override
  public List<TrainStationScheduleTurn> fetchTrainScheduleTurnsById(AdminSearchDTO adminSearchDTO)
      throws Exception {
    Criteria criteria =
        sessionFactory.getCurrentSession().createCriteria(TrainStationScheduleTurn.class);
    criteria.createAlias("trainStationSchedule", "trainStationSchedule");
    criteria.createAlias("trainStationSchedule.fromTrainStation", "fromTrainStation");
    criteria.createAlias("trainStationSchedule.toTrainStation", "toTrainStation");

    Conjunction and = Restrictions.conjunction();
    Date fromdate = getMinTimedDate(adminSearchDTO.retieveFromDate());
    System.out.println("fromdate :" + fromdate);
    Date toDate = getMaxTimedDate(adminSearchDTO.retieveToDate());
    System.out.println("toDate :" + toDate);

    System.out.println("adminSearchDTO.getFromStationId() :" + adminSearchDTO.getFromStationId());
    System.out.println("adminSearchDTO.getToStationId() :" + adminSearchDTO.getToStationId());

    and.add(Restrictions.ge("arrivalTime", fromdate));
    and.add(Restrictions.le("departureTime", toDate));
    and.add(Restrictions.eq("trainStationSchedule.trainStationScheduleId",
        adminSearchDTO.getTrainStationScheduleId()));
    criteria.add(and);


    List<TrainStationScheduleTurn> list = criteria.list();
    if (!(list == null || list.isEmpty())) {
      for (TrainStationScheduleTurn trainStationScheduleTurn : list) {
        if (!(trainStationScheduleTurn.getTrainStationSchedule() == null)) {
          Hibernate.initialize(trainStationScheduleTurn.getTrainStationSchedule());
        }

        if (!(trainStationScheduleTurn.getTrainScheduleTurn() == null)) {
          Hibernate.initialize(trainStationScheduleTurn.getTrainScheduleTurn());
          TrainScheduleTurn trainScheduleTurn = trainStationScheduleTurn.getTrainScheduleTurn();
          if (!(trainScheduleTurn.getTrainScheduleTurnLocationUpdates() == null)) {
            for (TrainScheduleTurnLocationUpdate update : trainScheduleTurn
                .getTrainScheduleTurnLocationUpdates()) {
              Hibernate.initialize(update);
            }
          }
        }

      }
    }
    return list;
  }

  private Date getMaxTimedDate(Date turnDate) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(turnDate);
    cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
    cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
    cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
    cal.set(Calendar.MILLISECOND, cal.getActualMaximum(Calendar.MILLISECOND));
    return cal.getTime();
  }

  private Date getMinTimedDate(Date turnDate) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(turnDate);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, cal.getActualMinimum(Calendar.MINUTE));
    cal.set(Calendar.SECOND, cal.getActualMinimum(Calendar.SECOND));
    cal.set(Calendar.MILLISECOND, cal.getActualMinimum(Calendar.MILLISECOND));
    return cal.getTime();
  }


}
