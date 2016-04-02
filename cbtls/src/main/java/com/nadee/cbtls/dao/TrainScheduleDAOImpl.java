package com.nadee.cbtls.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nadee.cbtls.constant.GeneralEnumConstants.TrainFrequency;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TicketPrice;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleComment;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainScheduleTurnCompartmentUpdate;
import com.nadee.cbtls.model.TrainScheduleTurnLocationPassiveUpdate;
import com.nadee.cbtls.model.TrainScheduleTurnLocationUpdate;
import com.nadee.cbtls.model.TrainStationSchedule;
import com.nadee.cbtls.model.TrainStationScheduleTurn;

@Repository(value = "trainScheduleDAO")
public class TrainScheduleDAOImpl implements TrainScheduleDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public long countActiveTrainSchedules() throws Exception {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainSchedule.class);
    criteria.add(Restrictions.eq("activeStatus", YesNoStatus.YES));
    criteria.setProjection(Projections.countDistinct("trainScheduleId"));
    return (long) criteria.uniqueResult();
  }

  @Override
  public List<TrainSchedule> listAllTrainSchedules(YesNoStatus yesNoStatus) throws Exception {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainSchedule.class);
    criteria.add(Restrictions.eq("activeStatus", YesNoStatus.YES));
    return criteria.list();
  }

  @Override
  public TrainSchedule fetchTrainSchedule(String trainNumber, TrainFrequency trainFrequency,
      String startStationName, String endStationName, String trainTypeName) throws Exception {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainSchedule.class);
    criteria.createAlias("startStation", "startStation");
    criteria.createAlias("endStation", "endStation");
    criteria.createAlias("trainType", "trainType");
    criteria.add(Restrictions.eq("trainNumber", trainNumber));
    criteria.add(Restrictions.eq("trainFrequency", trainFrequency));
    criteria.add(Restrictions.eq("startStation.trainStationName", startStationName));
    criteria.add(Restrictions.eq("endStation.trainStationName", endStationName));
    criteria.add(Restrictions.eq("trainType.trainTypeName", trainTypeName));
    TrainSchedule trainSchedule = (TrainSchedule) criteria.uniqueResult();
    if (!(trainSchedule == null)) {
      trainSchedule.getTrainStationSchedules();
      if (!(trainSchedule.getTrainStationSchedules() == null
          || trainSchedule.getTrainStationSchedules().isEmpty())) {
        for (TrainStationSchedule trainStationSchedule : trainSchedule.getTrainStationSchedules()) {

          System.out.println("trainStationSchedule.getTrainStationScheduleId(); "
              + trainStationSchedule.getTrainStationScheduleId());
        }
      }
    }

    return trainSchedule;
  }

  @Override
  public TrainSchedule loadTrainSchedule(long trainScheduleId) throws Exception {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainSchedule.class);
    criteria.add(Restrictions.eq("trainScheduleId", trainScheduleId));
    TrainSchedule trainSchedule = (TrainSchedule) criteria.uniqueResult();

    if (!(trainSchedule == null)) {
      if (!(trainSchedule.getTrainScheduleTurns() == null)) {
        for (TrainScheduleTurn trainScheduleTurn : trainSchedule.getTrainScheduleTurns()) {
          if (!(trainScheduleTurn == null)) {
            if (!(trainScheduleTurn.getTrainScheduleTurnLocationUpdates() == null)) {
              for (TrainScheduleTurnLocationUpdate trainScheduleTurnLocationUpdate : trainScheduleTurn
                  .getTrainScheduleTurnLocationUpdates()) {
                System.out.println("trainScheduleTurnLocationUpdate.getId() "
                    + trainScheduleTurnLocationUpdate.getId());
                if (!(trainScheduleTurnLocationUpdate.getUpdatedUser() == null)) {
                  Hibernate.initialize(trainScheduleTurnLocationUpdate.getUpdatedUser());
                }
              }
            }

            if (!(trainScheduleTurn.getTrainScheduleTurnLocationPassiveUpdates() == null)) {
              for (TrainScheduleTurnLocationPassiveUpdate trainScheduleTurnLocationPassiveUpdate : trainScheduleTurn
                  .getTrainScheduleTurnLocationPassiveUpdates()) {
                System.out.println("trainScheduleTurnLocationPassiveUpdate.getId() "
                    + trainScheduleTurnLocationPassiveUpdate.getId());
                if (!(trainScheduleTurnLocationPassiveUpdate.getUpdatedUser() == null)) {
                  Hibernate.initialize(trainScheduleTurnLocationPassiveUpdate.getUpdatedUser());
                }
              }
            }

            if (!(trainScheduleTurn.getTrainStationScheduleTurn() == null)) {
              for (TrainStationScheduleTurn trainStationScheduleTurn : trainScheduleTurn
                  .getTrainStationScheduleTurn()) {
                System.out.println("trainStationScheduleTurn.getTrainStationScheduleTurnId() "
                    + trainStationScheduleTurn.getTrainStationScheduleTurnId());
              }
            }

            if (!(trainScheduleTurn.getTrainScheduleTurnCompartmentUpdates() == null)) {
              for (TrainScheduleTurnCompartmentUpdate trainScheduleTurnCompartmentUpdate : trainScheduleTurn
                  .getTrainScheduleTurnCompartmentUpdates()) {
                System.out.println("trainScheduleTurnCompartmentUpdate.getId() "
                    + trainScheduleTurnCompartmentUpdate.getId());
                if (!(trainScheduleTurnCompartmentUpdate.getUpdatedUser() == null)) {
                  Hibernate.initialize(trainScheduleTurnCompartmentUpdate.getUpdatedUser());
                }
              }
            }
          }
        }
      }
    }

    return trainSchedule;
  }


  @Override
  public TrainStationSchedule loadTrainStationSchedule(long trainStationScheduleId) {
    Criteria criteria =
        sessionFactory.getCurrentSession().createCriteria(TrainStationSchedule.class);
    criteria.add(Restrictions.eq("trainStationScheduleId", trainStationScheduleId));
    TrainStationSchedule trainStationSchedule = (TrainStationSchedule) criteria.uniqueResult();
    if (!(trainStationSchedule == null)) {
      if (!(trainStationSchedule.getTrainStationScheduleTurns() == null)) {
        for (TrainStationScheduleTurn scheduleTurn : trainStationSchedule
            .getTrainStationScheduleTurns()) {
          Hibernate.initialize(scheduleTurn);
        }
      }

      if (!(trainStationSchedule.getFromTrainStation() == null)) {
        Hibernate.initialize(trainStationSchedule.getFromTrainStation());
      }

      if (!(trainStationSchedule.getToTrainStation() == null)) {
        Hibernate.initialize(trainStationSchedule.getToTrainStation());
      }

      if (!(trainStationSchedule.getTicketPrice() == null)) {
        for (TicketPrice ticketPrice : trainStationSchedule.getTicketPrice()) {
          Hibernate.initialize(ticketPrice);
        }
      }
    }
    return trainStationSchedule;
  }

  @Override
  public List<TrainScheduleComment> listAllTrainScheduleComments(long trainScheduleId)
      throws Exception {
    Criteria criteria =
        sessionFactory.getCurrentSession().createCriteria(TrainScheduleComment.class);
    criteria.add(Restrictions.eq("trainScheduleId", trainScheduleId));
    return criteria.list();
  }

}
