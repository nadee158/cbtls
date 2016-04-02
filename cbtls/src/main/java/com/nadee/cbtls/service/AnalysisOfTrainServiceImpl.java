package com.nadee.cbtls.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.constant.GeneralEnumConstants.LocatedType;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.TrainScheduleDAO;
import com.nadee.cbtls.dao.TrainScheduleTurnDAO;
import com.nadee.cbtls.dao.TrainStationDAO;
import com.nadee.cbtls.dto.AdminSearchDTO;
import com.nadee.cbtls.dto.AdminTrainAnalyticsResultDTO;
import com.nadee.cbtls.dto.AnalysisOfTrainResponseDTO;
import com.nadee.cbtls.dto.AnalysisOfTrainrequestDTO;
import com.nadee.cbtls.dto.ChartItemDTO;
import com.nadee.cbtls.dto.TrainLineDTO;
import com.nadee.cbtls.dto.TrainLineStationDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.model.TicketPrice;
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.model.TrainLineStation;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainScheduleTurnLocationUpdate;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.model.TrainStationSchedule;
import com.nadee.cbtls.model.TrainStationScheduleTurn;

@Service("analysisOfTrainService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AnalysisOfTrainServiceImpl implements AnalysisOfTrainService {

  @Autowired
  private TrainScheduleDAO trainScheduleDAO;

  @Autowired
  private TrainStationDAO trainStationDAO;

  @Autowired
  private TrainScheduleTurnDAO trainScheduleTurnDAO;

  @Autowired
  private CommonDAO commonDAO;

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

  @Override
  public List<TrainStationScheduleDTO> searchTrainSchedulesList(AdminSearchDTO adminSearchDTO)
      throws Exception {
    List<TrainStationScheduleDTO> dtoList = new ArrayList<TrainStationScheduleDTO>();
    List<TrainStationScheduleTurn> trainStationScheduleTurns =
        trainScheduleTurnDAO.fetchTrainScheduleTurns(adminSearchDTO);

    TrainLine trainLine = commonDAO.getEntityById(TrainLine.class, adminSearchDTO.getTrainLineId());
    TrainLineDTO trainLineDTO = null;
    if (!(trainLine == null)) {
      trainLineDTO = new TrainLineDTO(trainLine, false);
    }

    TrainLineStation fromTrainLineStation =
        trainStationDAO.getTrainLineStationByStationAndTrainLine(adminSearchDTO.getFromStationId(),
            adminSearchDTO.getTrainLineId());
    TrainLineStationDTO fromDTO = null;
    if (!(fromTrainLineStation == null)) {
      fromDTO = new TrainLineStationDTO(fromTrainLineStation);
    }

    TrainLineStation toTrainLineStation = trainStationDAO.getTrainLineStationByStationAndTrainLine(
        adminSearchDTO.getToStationId(), adminSearchDTO.getTrainLineId());
    TrainLineStationDTO toDTO = null;
    if (!(toTrainLineStation == null)) {
      toDTO = new TrainLineStationDTO(toTrainLineStation);
    }


    if (!(trainStationScheduleTurns == null || trainStationScheduleTurns.isEmpty())) {
      for (TrainStationScheduleTurn trainStationScheduleTurn : trainStationScheduleTurns) {
        dtoList.add(new TrainStationScheduleDTO(trainStationScheduleTurn.getTrainStationSchedule(),
            fromDTO, toDTO, trainLineDTO));
      }
    }
    return dtoList;
  }


  @Override
  public AdminTrainAnalyticsResultDTO searchTrainSchedulesAnalytics(AdminSearchDTO adminSearchDTO)
      throws Exception {

    TrainLineStation fromTrainLineStation =
        trainStationDAO.getTrainLineStationByStationAndTrainLine(adminSearchDTO.getFromStationId(),
            adminSearchDTO.getTrainLineId());
    TrainLineStationDTO fromDTO = null;
    if (!(fromTrainLineStation == null)) {
      fromDTO = new TrainLineStationDTO(fromTrainLineStation);
    }

    TrainLineStation toTrainLineStation = trainStationDAO.getTrainLineStationByStationAndTrainLine(
        adminSearchDTO.getToStationId(), adminSearchDTO.getTrainLineId());
    TrainLineStationDTO toDTO = null;
    if (!(toTrainLineStation == null)) {
      toDTO = new TrainLineStationDTO(toTrainLineStation);
    }

    long nextStationid = adminSearchDTO.getFromStationId();
    long toStationid = adminSearchDTO.getToStationId();

    List<TrainStation> stationList = new ArrayList<TrainStation>();

    AdminTrainAnalyticsResultDTO dto = new AdminTrainAnalyticsResultDTO();
    dto.setLabels(new ArrayList<String>());

    while (true) {
      // System.out.println("inner iteartion : - " + j);
      TrainLineStation nextTrainLineStation = trainStationDAO
          .getTrainLineStationByStationAndTrainLine(nextStationid, adminSearchDTO.getTrainLineId());
      if (nextTrainLineStation == null) {
        break;
      }

      stationList.add(nextTrainLineStation.getTrainStation());
      dto.getLabels().add(nextTrainLineStation.getTrainStation().getTrainStationName());
      nextStationid = nextTrainLineStation.getNextStation().getTrainStationId();

      if (nextStationid == toStationid) {
        dto.getLabels().add(toTrainLineStation.getTrainStation().getTrainStationName());
        break;
      }

    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

    dto.setDatasets(new ArrayList<ChartItemDTO>());
    dto.setStatus(ApplicationConstants.RESULTS_FOUND);
    List<TrainStationScheduleTurn> trainStationScheduleTurns =
        trainScheduleTurnDAO.fetchTrainScheduleTurnsById(adminSearchDTO);


    if (!(trainStationScheduleTurns == null || trainStationScheduleTurns.isEmpty())) {
      for (TrainStationScheduleTurn trainStationScheduleTurn : trainStationScheduleTurns) {
        TrainScheduleTurn trainScheduleTurn = trainStationScheduleTurn.getTrainScheduleTurn();
        if (!(trainScheduleTurn == null)) {
          String label = trainScheduleTurn.getTrainSchedule().getTrainName() + " - "
              + dateFormat.format(trainScheduleTurn.getTrainScheduleTurnDate());
          List<Long> list = new ArrayList<Long>();
          if (!(trainScheduleTurn.getTrainScheduleTurnLocationUpdates() == null)) {
            for (TrainScheduleTurnLocationUpdate locationUpdate : trainScheduleTurn
                .getTrainScheduleTurnLocationUpdates()) {
              if (locationUpdate.getLocatedType().getCode() == LocatedType.IN_THE_STATION
                  .getCode()) {

                list.add(locationUpdate.getUpdatedTime().getTime());

              }

            }
          }
          java.util.Collections.sort(list);
          dto.getDatasets().add(new ChartItemDTO(label, list));
        }
      }
    } else {
      dto.setStatus(ApplicationConstants.NO_RESULTS);
    }
    return dto;
  }


}
