package com.nadee.cbtls.service;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.constant.GeneralEnumConstants.LocatedType;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.SystemUserDAO;
import com.nadee.cbtls.dao.TrainLocationUpdateDAO;
import com.nadee.cbtls.dto.ActiveTrainLocationUpdateDTO;
import com.nadee.cbtls.dto.DatagenerationObjectMaster;
import com.nadee.cbtls.dto.GeoLocationDTO;
import com.nadee.cbtls.dto.TrainScheduleSearchDTO;
import com.nadee.cbtls.dto.TrainStationDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserMobileDevice;
import com.nadee.cbtls.model.TrainLineStation;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainScheduleTurnLocationUpdate;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.model.TrainStationSchedule;
import com.nadee.cbtls.model.TrainStationScheduleTurn;

@Service(value = "dataGenerationService")
public class DataGenerationServiceImpl implements DataGenerationService {

  @Autowired
  private TrainStationScheduleService trainStationScheduleService;

  @Autowired
  private TrainStationService trainStationService;

  @Autowired
  private CommonDAO commonDAO;

  @Autowired
  private TrainLocationUpdateDAO trainLocationUpdateDAO;

  @Autowired
  private SystemUserService systemUserService;

  @Autowired
  private SystemUserDAO systemUserDAO;

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  @Override
  public Map<String, Object> generateData() throws Exception {
    Map<String, Object> map = new HashMap<String, Object>();
    TrainScheduleSearchDTO trainScheduleSearchDTO = new TrainScheduleSearchDTO();
    long trainLineId = 3;
    trainScheduleSearchDTO.setFromStationId(46);
    trainScheduleSearchDTO.setFromTime("00:00:00");
    trainScheduleSearchDTO.setToTime("23:59:59");
    trainScheduleSearchDTO.setTrainLineId(trainLineId);
    trainScheduleSearchDTO.setToStationId(107);

    List<TrainStationScheduleDTO> scheduleDTOs =
        trainStationScheduleService.serachTrainStationSchedules(trainScheduleSearchDTO);
    System.out.println("scheduleDTOs :" + scheduleDTOs);
    int i = 0;

    Map<Long, DatagenerationObjectMaster> dataMap =
        DatagenerationObjectMaster.generateDefaultList();

    FileWriter writer =
        new FileWriter("D:/CBTLS_Final_Project_MsC/cbtls/db_backups/generated_data.csv");



    for (TrainStationScheduleDTO trainStationScheduleDTO : scheduleDTOs) {

      long trainStationScheduleId = trainStationScheduleDTO.getTrainStationScheduleId();
      long trainScheduleId = trainStationScheduleDTO.getTrainSchedule().getTrainScheduleId();

      Calendar cal = Calendar.getInstance();
      cal.setTime(trainStationScheduleDTO.getDepartureTime());


      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      Date startDate = formatter.parse("2016-03-01");
      Date endDate = formatter.parse("2016-04-04");
      Calendar start = Calendar.getInstance();
      start.setTime(startDate);
      Calendar end = Calendar.getInstance();
      end.setTime(endDate);

      for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date =
          start.getTime()) {
        // Do your job here with `date`.
        System.out.println("DATE ITERATION :" + date);

        Calendar calToday = Calendar.getInstance();
        calToday.setTime(date);
        calToday.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
        calToday.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
        calToday.set(Calendar.SECOND, cal.get(Calendar.SECOND));
        calToday.set(Calendar.MILLISECOND, cal.get(Calendar.MILLISECOND));

        Date departureDateTimeFromStartStation = calToday.getTime();

        appendLineToWriter(writer,
            trainStationScheduleDTO.getFromTrainLineStation().getTrainStation());

        DatagenerationObjectMaster fromMaster = dataMap.get(trainStationScheduleDTO
            .getFromTrainLineStation().getTrainStation().getTrainStationId());

        List<ActiveTrainLocationUpdateDTO> masterDTOList =
            constructActiveTrainLocationUpdateDTOList(fromMaster, departureDateTimeFromStartStation,
                trainStationScheduleId, trainScheduleId);
        for (ActiveTrainLocationUpdateDTO activeTrainLocationUpdateDTO : masterDTOList) {
          activeUpdateTrainLocation(activeTrainLocationUpdateDTO);
        }

        appendLineToWriter(writer,
            trainStationScheduleDTO.getFromTrainLineStation().getNextStation());

        DatagenerationObjectMaster firstNextMaster = dataMap.get(
            trainStationScheduleDTO.getFromTrainLineStation().getNextStation().getTrainStationId());

        masterDTOList.clear();
        masterDTOList = constructActiveTrainLocationUpdateDTOList(firstNextMaster,
            departureDateTimeFromStartStation, trainStationScheduleId, trainScheduleId);
        for (ActiveTrainLocationUpdateDTO activeTrainLocationUpdateDTO : masterDTOList) {
          activeUpdateTrainLocation(activeTrainLocationUpdateDTO);
        }


        long nextStationid =
            trainStationScheduleDTO.getFromTrainLineStation().getNextStation().getTrainStationId();
        long toStationid =
            trainStationScheduleDTO.getToTrainLineStation().getTrainStation().getTrainStationId();

        int j = 0;
        while (true) {
          // System.out.println("inner iteartion : - " + j);
          TrainLineStation nextTrainLineStation = trainStationService
              .getTrainLineStationByStationAndTrainLine(nextStationid, trainLineId);
          if (nextTrainLineStation == null) {
            break;
          }

          nextStationid = nextTrainLineStation.getNextStation().getTrainStationId();


          DatagenerationObjectMaster nextMaster = dataMap.get(nextStationid);
          masterDTOList.clear();
          masterDTOList = constructActiveTrainLocationUpdateDTOList(nextMaster,
              departureDateTimeFromStartStation, trainStationScheduleId, trainScheduleId);
          for (ActiveTrainLocationUpdateDTO activeTrainLocationUpdateDTO : masterDTOList) {
            activeUpdateTrainLocation(activeTrainLocationUpdateDTO);
          }



          appendLineToWriter(writer, nextTrainLineStation.getNextStation());


          if (nextStationid == toStationid) {
            break;
          }


          j++;

        }



      }

      i++;

    }

    writer.flush();
    writer.close();

    return map;
  }

  private List<ActiveTrainLocationUpdateDTO> constructActiveTrainLocationUpdateDTOList(
      DatagenerationObjectMaster fromMaster, Date departureTimeFromStartStation,
      long trainStationScheduleId, long trainScheduleId) {
    List<ActiveTrainLocationUpdateDTO> dtos = new ArrayList<ActiveTrainLocationUpdateDTO>();
    long duration = fromMaster.getDuration();
    duration = getRandomNumber((int) duration, (int) (duration + 30));
    Date locatedTime = addMinsToDate(departureTimeFromStartStation, duration);
    dtos.add(
        constructActiveTrainLocationUpdateDTO(fromMaster, fromMaster.getGeoLocation(), locatedTime,
            LocatedType.IN_THE_STATION.getCode(), trainStationScheduleId, trainScheduleId));


    int i = 0;
    for (GeoLocationDTO dto : fromMaster.getGeoLocations()) {
      i++;
      locatedTime =
          addMinsToDate(departureTimeFromStartStation, (duration + getRandomNumber(0, 10)));
      dtos.add(constructActiveTrainLocationUpdateDTO(fromMaster, dto, locatedTime,
          LocatedType.ON_THE_MOVE.getCode(), trainStationScheduleId, trainScheduleId));
    }

    return dtos;
  }

  private int getRandomNumber(int Low, int High) {
    Random r = new Random();
    return r.nextInt(High - Low) + Low;
  }

  private ActiveTrainLocationUpdateDTO constructActiveTrainLocationUpdateDTO(
      DatagenerationObjectMaster fromMaster, GeoLocationDTO geoLocation, Date locatedTime,
      int locatedType, long trainStationScheduleId, long trainScheduleId) {
    ActiveTrainLocationUpdateDTO dto = new ActiveTrainLocationUpdateDTO();
    dto.setLastStationId(fromMaster.getTrainStationId());
    dto.setLatitude((float) geoLocation.getLatitude());
    dto.setLongitude((float) geoLocation.getLongitude());
    dto.setLocatedDate(locatedTime);
    dto.setLocatedType(locatedType);
    dto.setTrainScheduleId(trainScheduleId);
    dto.setTrainStationScheduleId(trainStationScheduleId);
    dto.setUpdatedUser(getRandomNumber(1, 157));
    System.out.println("dto    --- " + dto);
    return dto;
  }

  private void appendLineToWriter(FileWriter writer, TrainStation trainStation) throws IOException {
    writer.append(Long.toString(trainStation.getTrainStationId()));
    writer.append(',');
    writer.append(trainStation.getTrainStationName());
    writer.append(',');
    writer.append(Double.toString(trainStation.getGeoLocation().getLatitude()));
    writer.append(',');
    writer.append(Double.toString(trainStation.getGeoLocation().getLongitude()));
    writer.append('\n');

  }

  private void appendLineToWriter(FileWriter writer, TrainStationDTO trainStation)
      throws IOException {
    writer.append(Long.toString(trainStation.getTrainStationId()));
    writer.append(',');
    writer.append(trainStation.getTrainStationName());
    writer.append(',');
    writer.append(Double.toString(trainStation.getGeoLocation().getLatitude()));
    writer.append(',');
    writer.append(Double.toString(trainStation.getGeoLocation().getLongitude()));
    writer.append('\n');

  }


  public Map<String, Object> activeUpdateTrainLocation(ActiveTrainLocationUpdateDTO dto)
      throws Exception {
    Map<String, Object> resultMap = new HashMap<String, Object>();

    TrainScheduleTurnLocationUpdate trainScheduleTurnLocationUpdate =
        new TrainScheduleTurnLocationUpdate();
    TrainStation lastStation = commonDAO.getEntityById(TrainStation.class, dto.getLastStationId());
    trainScheduleTurnLocationUpdate.setLastStation(lastStation);
    trainScheduleTurnLocationUpdate.setLatitude(dto.getLatitude());
    trainScheduleTurnLocationUpdate.setLongitude(dto.getLongitude());
    LocatedType locatedType = LocatedType.fromCode(dto.getLocatedType());
    trainScheduleTurnLocationUpdate.setLocatedType(locatedType);
    TrainScheduleTurn trainScheduleTurn = trainLocationUpdateDAO
        .fetchTrainScheduleTurn(dto.getTrainScheduleId(), dto.getLocatedDate());
    System.out.println("trainScheduleTurn :" + trainScheduleTurn);


    boolean isNewRecord = false;


    if (trainScheduleTurn == null) {
      isNewRecord = true;
      trainScheduleTurn = new TrainScheduleTurn();
      trainScheduleTurn.setActiveStatus(YesNoStatus.YES);
      TrainSchedule trainSchedule =
          trainLocationUpdateDAO.getTrainScheduleById(dto.getTrainScheduleId());
      System.out.println("trainSchedule :" + trainSchedule);
      trainScheduleTurn.setTrainSchedule(trainSchedule);
      trainScheduleTurn.setTrainScheduleTurnDate(dto.getLocatedDate());
    }

    if (trainScheduleTurn.getTrainScheduleTurnLocationUpdates() == null) {
      trainScheduleTurn
          .setTrainScheduleTurnLocationUpdates(new ArrayList<TrainScheduleTurnLocationUpdate>());
    }

    trainScheduleTurnLocationUpdate.setTrainScheduleTurn(trainScheduleTurn);
    trainScheduleTurnLocationUpdate.setUpdatedTime(dto.getLocatedDate());

    SystemUser systemUser = null;

    boolean isNewUser = false;

    if (StringUtils.isNotEmpty(dto.getSystemUserMobileDevice())) {
      SystemUserMobileDevice systemUserMobileDevice =
          systemUserDAO.getSystemUserMobileDeviceByUniqueId(dto.getSystemUserMobileDevice());

      if (systemUserMobileDevice == null) {
        systemUserMobileDevice =
            systemUserService.createMobileUser(dto.getSystemUserMobileDevice(), null);
        isNewUser = true;
      } else {
        System.out.println("systemUserMobileDevice.getSystemUserMobileDeviceId() "
            + systemUserMobileDevice.getSystemUserMobileDeviceId());
      }
      System.out.println("systemUserMobileDevice.getSystemUserMobileDeviceId() "
          + systemUserMobileDevice.getSystemUserMobileDeviceId());
      systemUser = systemUserMobileDevice.getSystemUser();
      System.out.println("systemUser.getUserId() " + systemUser.getUserId());
      resultMap.put(ApplicationConstants.USER_TYPE, ApplicationConstants.MOBILE_USER);
      resultMap.put(ApplicationConstants.USER_ID,
          systemUserMobileDevice.getMobileDevice().getUniqueMobileDeviceNumber());
    } else {
      if (!(dto.getUpdatedUser() == 0)) {
        systemUser = commonDAO.getEntityById(SystemUser.class, dto.getUpdatedUser());
      }
      if (systemUser == null) {
        systemUser = systemUserService.createWebUser(null, null);
        isNewUser = true;
      }
      System.out.println("systemUser.getUserId() " + systemUser.getUserId());
      resultMap.put(ApplicationConstants.USER_TYPE, ApplicationConstants.WEB_USER);
      resultMap.put(ApplicationConstants.USER_ID, systemUser.getUserId());
    }

    if (!(isNewUser)) {
      systemUser.setTotalNumberOfFeedBacks(systemUser.getTotalNumberOfFeedBacks() + 1);
    }

    resultMap.put(ApplicationConstants.SYSTEM_USER, systemUser);
    trainScheduleTurnLocationUpdate.setUpdatedUser(systemUser);

    trainScheduleTurn.getTrainScheduleTurnLocationUpdates().add(trainScheduleTurnLocationUpdate);

    TrainStationScheduleTurn trainStationScheduleTurn = null;
    if (!(isNewRecord)) {
      trainStationScheduleTurn = trainLocationUpdateDAO.fetchTrainStationScheduleTurn(
          trainScheduleTurn.getTrainScheduleTurnId(), dto.getTrainStationScheduleId());
    }
    Date arrivalTime = dto.getLocatedDate();
    Date departureTime = addMinsToDate(arrivalTime, 2);

    if (!(trainScheduleTurn.getTrainSchedule().getStartStation() == null
        || trainScheduleTurn.getTrainSchedule().getEndStation() == null)) {
      if (trainScheduleTurn.getTrainSchedule().getStartStation().getTrainStationId() == dto
          .getLastStationId()) {
        trainScheduleTurn.setDepartureTime(departureTime);
      } else if (trainScheduleTurn.getTrainSchedule().getEndStation().getTrainStationId() == dto
          .getLastStationId()) {
        trainScheduleTurn.setArrivalTime(arrivalTime);
      }
    }


    if (trainStationScheduleTurn == null) {
      if (trainScheduleTurn.getTrainStationScheduleTurn() == null) {
        trainScheduleTurn.setTrainStationScheduleTurn(new ArrayList<TrainStationScheduleTurn>());
      }
      trainStationScheduleTurn = new TrainStationScheduleTurn();
      trainStationScheduleTurn.setActiveStatus(YesNoStatus.YES);
      trainStationScheduleTurn.setArrivalTime(arrivalTime);
      trainStationScheduleTurn.setDepartureTime(departureTime);
      TrainStationSchedule trainStationSchedule =
          commonDAO.getEntityById(TrainStationSchedule.class, dto.getTrainStationScheduleId());
      trainStationScheduleTurn.setTrainStationSchedule(trainStationSchedule);
      trainStationScheduleTurn.setTrainScheduleTurn(trainScheduleTurn);
      trainScheduleTurn.getTrainStationScheduleTurn().add(trainStationScheduleTurn);

    }
    String result = commonDAO.saveOrUpdateEntity(trainScheduleTurn);
    resultMap.put(ApplicationConstants.RESULT, result);

    return resultMap;
  }

  private Date addMinsToDate(Date arrivalTime, long minuted) {
    System.out.println("original_date :" + arrivalTime);
    Date newDate = DateUtils.addMinutes(arrivalTime, (int) minuted);
    System.out.println("newDate :" + newDate);
    return newDate;
  }



}
