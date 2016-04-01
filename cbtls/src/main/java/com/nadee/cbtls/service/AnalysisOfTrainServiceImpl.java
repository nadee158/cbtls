package com.nadee.cbtls.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.dao.TrainScheduleDAO;
import com.nadee.cbtls.dao.TrainStationDAO;
import com.nadee.cbtls.dto.AnalysisOfTrainResponseDTO;
import com.nadee.cbtls.dto.AnalysisOfTrainrequestDTO;
import com.nadee.cbtls.model.TicketPrice;
import com.nadee.cbtls.model.TrainLineStation;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.model.TrainStationSchedule;

@Service("analysisOfTrainService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AnalysisOfTrainServiceImpl implements AnalysisOfTrainService {

  @Autowired
  private TrainScheduleDAO trainScheduleDAO;

  @Autowired
  private TrainStationDAO trainStationDAO;

  @Override
  public AnalysisOfTrainResponseDTO viewAnalysisOfTrain(
      AnalysisOfTrainrequestDTO analysisOfTrainrequestDTO) throws Exception {

    String status = ApplicationConstants.RESULTS_FOUND;
    String etaAtStation1 = null;
    String etaAtStation2 = null;
    String totalDistance = null;
    String duration = null;
    String trainType = null;
    String frequency = null;
    String averageDelay = null;
    String averageCrowdDensity = "High";
    String ticketPriceFirstClass = null;
    String ticketPriceSecondClass = null;
    String ticketPriceThirdClass = null;

    TrainSchedule trainSchedule =
        trainScheduleDAO.loadTrainSchedule(analysisOfTrainrequestDTO.getTrainScheduleId());

    trainType = trainSchedule.getTrainType().getTrainTypeName();
    frequency = trainSchedule.getTrainFrequency().toString();

    TrainStationSchedule trainStationSchedule = trainScheduleDAO
        .loadTrainStationSchedule(analysisOfTrainrequestDTO.getTrainStationScheduleId());

    for (TicketPrice ticketPrice : trainStationSchedule.getTicketPrice()) {
      switch (ticketPrice.getTicketType()) {
        case FIRST_CLASS:
          ticketPriceFirstClass = "Rs." + ticketPrice.getTicketPrice();
          break;
        case SECOND_CLASS:
          ticketPriceSecondClass = "Rs." + ticketPrice.getTicketPrice();
          break;
        case THIRD_CLASS:
          ticketPriceThirdClass = "Rs." + ticketPrice.getTicketPrice();
          break;
        default:
          break;
      }

    }

    TrainStation fromStation = trainStationSchedule.getFromTrainStation();
    TrainStation toStation = trainStationSchedule.getToTrainStation();

    SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");

    etaAtStation1 = dateFormat.format(trainStationSchedule.getArrivalTime());
    etaAtStation2 = dateFormat.format(trainStationSchedule.getArrivalAtDestinationTime());

    TrainLineStation fromTrainLineStation =
        trainStationDAO.getTrainLineStationByStationAndTrainLine(fromStation.getTrainStationId(),
            analysisOfTrainrequestDTO.getTrainLineId());

    TrainLineStation toTrainLineStation = trainStationDAO.getTrainLineStationByStationAndTrainLine(
        toStation.getTrainStationId(), analysisOfTrainrequestDTO.getTrainLineId());


    duration = calculateDuration(trainStationSchedule.getArrivalTime(),
        trainStationSchedule.getArrivalAtDestinationTime());

    totalDistance = Double.toString(calculateDistance(fromTrainLineStation, toTrainLineStation));


    AnalysisOfTrainResponseDTO dto = new AnalysisOfTrainResponseDTO(status, etaAtStation1,
        etaAtStation2, totalDistance, duration, trainType, frequency, averageDelay,
        averageCrowdDensity, ticketPriceFirstClass, ticketPriceSecondClass, ticketPriceThirdClass);

    dto.setStationOne(fromStation.getTrainStationName());
    dto.setStationTwo(toStation.getTrainStationName());
    return dto;

  }

  private double calculateDistance(TrainLineStation fromTrainLineStation,
      TrainLineStation toTrainLineStation) {
    if (!(toTrainLineStation == null || fromTrainLineStation == null)) {
      return toTrainLineStation.getDistanceFromStartStation()
          - fromTrainLineStation.getDistanceFromStartStation();
    }
    return 0;

  }

  private String calculateDuration(Date arriValTime, Date departureTime) {
    long duration = Math.abs(arriValTime.getTime() - departureTime.getTime());
    return String.format("%02d h, %02d min", TimeUnit.MILLISECONDS.toHours(duration),

        TimeUnit.MILLISECONDS.toMinutes(duration)
            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration))


    );
  }


}
