package com.nadee.cbtls.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
import com.nadee.cbtls.dto.PassiveTrainLocationUpdateDTO;
import com.nadee.cbtls.dto.TrainLocationDTO;
import com.nadee.cbtls.dto.ViewTrainlocationRequestDTO;
import com.nadee.cbtls.dto.ViewTrainlocationResponseDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserMobileDevice;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainScheduleTurnLocationPassiveUpdate;
import com.nadee.cbtls.model.TrainScheduleTurnLocationUpdate;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.model.TrainStationSchedule;
import com.nadee.cbtls.model.TrainStationScheduleTurn;

@Service("trainLocationUpdateService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainLocationUpdateServiceImpl implements TrainLocationUpdateService {

  @Autowired
  private CommonDAO commonDAO;

  @Autowired
  private TrainLocationUpdateDAO trainLocationUpdateDAO;

  @Autowired
  private SystemUserService systemUserService;

  @Autowired
  private SystemUserDAO systemUserDAO;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
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
        .fetchTrainScheduleTurn(dto.getTrainScheduleId(), Calendar.getInstance().getTime());
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
      trainScheduleTurn.setTrainScheduleTurnDate(Calendar.getInstance().getTime());
    }

    if (trainScheduleTurn.getTrainScheduleTurnLocationUpdates() == null) {
      trainScheduleTurn
          .setTrainScheduleTurnLocationUpdates(new ArrayList<TrainScheduleTurnLocationUpdate>());
    }

    trainScheduleTurnLocationUpdate.setTrainScheduleTurn(trainScheduleTurn);
    trainScheduleTurnLocationUpdate.setUpdatedTime(Calendar.getInstance().getTime());

    SystemUser systemUser = null;

    if (StringUtils.isNotEmpty(dto.getSystemUserMobileDevice())) {
      SystemUserMobileDevice systemUserMobileDevice =
          systemUserDAO.getSystemUserMobileDeviceByUniqueId(dto.getSystemUserMobileDevice());

      if (systemUserMobileDevice == null) {
        systemUserMobileDevice =
            systemUserService.createMobileUser(dto.getSystemUserMobileDevice(), null);
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
      }
      System.out.println("systemUser.getUserId() " + systemUser.getUserId());
      resultMap.put(ApplicationConstants.USER_TYPE, ApplicationConstants.WEB_USER);
      resultMap.put(ApplicationConstants.USER_ID, systemUser.getUserId());
    }
    resultMap.put(ApplicationConstants.SYSTEM_USER, systemUser);
    trainScheduleTurnLocationUpdate.setUpdatedUser(systemUser);

    trainScheduleTurn.getTrainScheduleTurnLocationUpdates().add(trainScheduleTurnLocationUpdate);

    TrainStationScheduleTurn trainStationScheduleTurn = null;
    if (!(isNewRecord)) {
      trainStationScheduleTurn = trainLocationUpdateDAO.fetchTrainStationScheduleTurn(
          trainScheduleTurn.getTrainScheduleTurnId(), dto.getTrainStationScheduleId());
    }
    Date arrivalTime = Calendar.getInstance().getTime();
    Date departureTime = Calendar.getInstance().getTime();

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


  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Map<String, Object> passiveUpdateTrainLocation(PassiveTrainLocationUpdateDTO dto)
      throws Exception {
    Map<String, Object> resultMap = new HashMap<String, Object>();

    TrainScheduleTurnLocationPassiveUpdate update = new TrainScheduleTurnLocationPassiveUpdate();
    TrainStation lastStation = commonDAO.getEntityById(TrainStation.class, dto.getLastStationId());
    update.setLastStation(lastStation);

    update.setLatitude(dto.getLatitude());
    update.setLongitude(dto.getLongitude());

    LocatedType locatedType = LocatedType.fromCode(dto.getLocatedType());
    update.setLocatedType(locatedType);
    TrainScheduleTurn trainScheduleTurn = trainLocationUpdateDAO
        .fetchTrainScheduleTurn(dto.getTrainScheduleId(), Calendar.getInstance().getTime());
    System.out.println("trainScheduleTurn :" + trainScheduleTurn);


    boolean isNewRecord = false;


    if (trainScheduleTurn == null) {
      isNewRecord = true;
      trainScheduleTurn = new TrainScheduleTurn();
      trainScheduleTurn.setActiveStatus(YesNoStatus.YES);
      TrainSchedule trainSchedule =
          commonDAO.getEntityById(TrainSchedule.class, dto.getTrainScheduleId());
      trainScheduleTurn.setTrainSchedule(trainSchedule);
      trainScheduleTurn.setTrainScheduleTurnDate(Calendar.getInstance().getTime());
    }

    if (trainScheduleTurn.getTrainScheduleTurnLocationPassiveUpdates() == null) {
      trainScheduleTurn.setTrainScheduleTurnLocationPassiveUpdates(
          new ArrayList<TrainScheduleTurnLocationPassiveUpdate>());
    }

    update.setTrainScheduleTurn(trainScheduleTurn);
    update.setLocatedTime(dto.getLocatedTimeAsDate());

    SystemUser systemUser = null;

    if (StringUtils.isNotEmpty(dto.getSystemUserMobileDevice())) {
      SystemUserMobileDevice systemUserMobileDevice =
          systemUserService.getSystemUserMobileDeviceByUniqueId(dto.getSystemUserMobileDevice());
      if (systemUserMobileDevice == null) {
        systemUserMobileDevice =
            systemUserService.createMobileUser(dto.getSystemUserMobileDevice(), null);
      }
      systemUser = systemUserMobileDevice.getSystemUser();
      resultMap.put(ApplicationConstants.USER_TYPE, ApplicationConstants.MOBILE_USER);
      resultMap.put(ApplicationConstants.USER_ID,
          systemUserMobileDevice.getMobileDevice().getUniqueMobileDeviceNumber());
    } else {
      if (!(dto.getUpdatedUser() == 0)) {
        systemUser = commonDAO.getEntityById(SystemUser.class, dto.getUpdatedUser());
      }
      if (systemUser == null) {
        systemUser = systemUserService.createWebUser(null, null);
      }
      resultMap.put(ApplicationConstants.USER_TYPE, ApplicationConstants.WEB_USER);
      resultMap.put(ApplicationConstants.USER_ID, systemUser.getUserId());
    }

    update.setUpdatedUser(systemUser);
    resultMap.put(ApplicationConstants.SYSTEM_USER, systemUser);
    trainScheduleTurn.getTrainScheduleTurnLocationPassiveUpdates().add(update);

    TrainStationScheduleTurn trainStationScheduleTurn = null;
    if (!(isNewRecord)) {
      trainStationScheduleTurn = trainLocationUpdateDAO.fetchTrainStationScheduleTurn(
          trainScheduleTurn.getTrainScheduleTurnId(), dto.getTrainStationScheduleId());
    }
    Date arrivalTime = Calendar.getInstance().getTime();
    Date departureTime = Calendar.getInstance().getTime();

    if (trainScheduleTurn.getTrainSchedule().getStartStation().getTrainStationId() == dto
        .getLastStationId()) {
      trainScheduleTurn.setDepartureTime(departureTime);
    } else if (trainScheduleTurn.getTrainSchedule().getEndStation().getTrainStationId() == dto
        .getLastStationId()) {
      trainScheduleTurn.setArrivalTime(arrivalTime);
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


  @Override
  public ViewTrainlocationResponseDTO listTrainLocation(ViewTrainlocationRequestDTO requestDTO)
      throws Exception {
    ViewTrainlocationResponseDTO dto = new ViewTrainlocationResponseDTO();
    String status = ApplicationConstants.ERROR;
    String message = null;
    TrainScheduleTurn trainScheduleTurn = trainLocationUpdateDAO
        .fetchTrainScheduleTurn(requestDTO.getTrainScheduleId(), Calendar.getInstance().getTime());
    if (trainScheduleTurn == null) {
      message = "No data regading this schedule is curretly available!";
    } else {
      boolean isDataAvailable = false;
      List<TrainLocationDTO> locationDTOs = new ArrayList<TrainLocationDTO>();
      if (!(trainScheduleTurn.getTrainScheduleTurnLocationUpdates() == null
          || trainScheduleTurn.getTrainScheduleTurnLocationUpdates().isEmpty())) {
        isDataAvailable = true;
        for (TrainScheduleTurnLocationUpdate locationUpdate : trainScheduleTurn
            .getTrainScheduleTurnLocationUpdates()) {
          TrainLocationDTO trainLocationDTO = new TrainLocationDTO();
          trainLocationDTO.setLatitude(locationUpdate.getLatitude());
          trainLocationDTO.setLongitude(locationUpdate.getLongitude());
          SystemUser systemUser = locationUpdate.getUpdatedUser();
          trainLocationDTO.setProvidedUserName(systemUser.getUserDisplayName());
          trainLocationDTO.setRank(systemUser.getAverageRanking());
          SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
          trainLocationDTO.setUpdatedTime(format.format(locationUpdate.getUpdatedTime()));
          trainLocationDTO.setUpdatedUserId(systemUser.getUserId());
          trainLocationDTO.setNote(locationUpdate.getLocatedType().toString());
          locationDTOs.add(trainLocationDTO);
          dto.setTotalNoOfFeedbacks(dto.getTotalNoOfFeedbacks() + 1);
        }
      }

      if (!(trainScheduleTurn.getTrainScheduleTurnLocationPassiveUpdates() == null
          || trainScheduleTurn.getTrainScheduleTurnLocationPassiveUpdates().isEmpty())) {
        isDataAvailable = true;
        for (TrainScheduleTurnLocationPassiveUpdate locationUpdate : trainScheduleTurn
            .getTrainScheduleTurnLocationPassiveUpdates()) {
          TrainLocationDTO trainLocationDTO = new TrainLocationDTO();
          TrainStation trainStation = locationUpdate.getLastStation();
          trainLocationDTO.setLatitude(trainStation.getGeoLocation().getLatitude());
          trainLocationDTO.setLongitude(trainStation.getGeoLocation().getLongitude());
          SystemUser systemUser = locationUpdate.getUpdatedUser();
          trainLocationDTO.setProvidedUserName(systemUser.getUserDisplayName());
          trainLocationDTO.setRank(systemUser.getAverageRanking());
          SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
          trainLocationDTO.setUpdatedTime(format.format(locationUpdate.getLocatedTime()));
          trainLocationDTO.setUpdatedUserId(systemUser.getUserId());
          trainLocationDTO.setNote(locationUpdate.getLocatedType().toString());
          locationDTOs.add(trainLocationDTO);
          dto.setTotalNoOfFeedbacks(dto.getTotalNoOfFeedbacks() + 1);
        }
      }
      dto.setLocationDTOs(locationDTOs);
      System.out.println("locationDTOs :" + locationDTOs);

      if (!(isDataAvailable)) {
        message = "No data regading this schedule is curretly available!";
        status = ApplicationConstants.ERROR;
      } else {
        status = ApplicationConstants.SUCCESS;
      }

    }

    dto.setMessage(message);
    dto.setStatus(status);
    return dto;
  }


}
