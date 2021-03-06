package com.nadee.cbtls.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.constant.GeneralEnumConstants.CrowdDensity;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.CompartmentDetailDAO;
import com.nadee.cbtls.dao.TrainLocationUpdateDAO;
import com.nadee.cbtls.dto.CompartmentDetailItemDTO;
import com.nadee.cbtls.dto.CompartmentDetailResponseDTO;
import com.nadee.cbtls.dto.CompartmentDetailUpdateDTO;
import com.nadee.cbtls.dto.ViewCompartmentDetailRequestDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserMobileDevice;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainScheduleTurnCompartmentUpdate;
import com.nadee.cbtls.model.TrainStationSchedule;
import com.nadee.cbtls.model.TrainStationScheduleTurn;

@Service("compartmentDetailService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CompartmentDetailServiceImpl implements CompartmentDetailService {

  @Autowired
  private CommonDAO commonDAO;

  @Autowired
  private CompartmentDetailDAO compartmentDetailDAO;

  @Autowired
  private TrainLocationUpdateDAO trainLocationUpdateDAO;

  @Autowired
  private SystemUserService systemUserService;

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public Map<String, Object> updateCompartmentDetails(CompartmentDetailUpdateDTO dto)
      throws Exception {
    Map<String, Object> resultMap = new HashMap<String, Object>();

    TrainScheduleTurnCompartmentUpdate update = new TrainScheduleTurnCompartmentUpdate();

    update.setCompartmentDensity(CrowdDensity.fromCode(dto.getCompartmentDensity()));
    update.setCompartmentNumber(dto.getCompartmentNumber());
    update.setOverallDensity(CrowdDensity.fromCode(dto.getOverallDensity()));
    update.setTotalCompartments(dto.getTotalCompartments());

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

    if (trainScheduleTurn.getTrainScheduleTurnCompartmentUpdates() == null) {
      trainScheduleTurn.setTrainScheduleTurnCompartmentUpdates(
          new ArrayList<TrainScheduleTurnCompartmentUpdate>());
    }


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

    update.setTrainScheduleTurn(trainScheduleTurn);
    update.setUpdatedTime(Calendar.getInstance().getTime());

    update.setUpdatedUser(systemUser);

    trainScheduleTurn.getTrainScheduleTurnCompartmentUpdates().add(update);

    TrainStationScheduleTurn trainStationScheduleTurn = null;
    if (!(isNewRecord)) {
      trainStationScheduleTurn = trainLocationUpdateDAO.fetchTrainStationScheduleTurn(
          trainScheduleTurn.getTrainScheduleTurnId(), dto.getTrainStationScheduleId());
    }
    Date arrivalTime = Calendar.getInstance().getTime();
    Date departureTime = Calendar.getInstance().getTime();


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
  public CompartmentDetailResponseDTO viewCompartmentDetails(ViewCompartmentDetailRequestDTO dto)
      throws Exception {
    CompartmentDetailResponseDTO compartmentDetailResponseDTO = null;
    TrainScheduleTurn trainScheduleTurn = trainLocationUpdateDAO
        .fetchTrainScheduleTurn(dto.getTrainScheduleId(), Calendar.getInstance().getTime());
    System.out.println("trainScheduleTurn :" + trainScheduleTurn);
    if (!(trainScheduleTurn == null)) {
      if (!(trainScheduleTurn.getTrainScheduleTurnCompartmentUpdates() == null
          || trainScheduleTurn.getTrainScheduleTurnCompartmentUpdates().isEmpty())) {
        compartmentDetailResponseDTO =
            new CompartmentDetailResponseDTO(ApplicationConstants.RESULTS_FOUND);
        int totalCompartments = 0;
        int overallCrowdDensity = 0;
        int noOfFeedBacks = 0;

        Map<Integer, CompartmentDetailItemDTO> map =
            new HashMap<Integer, CompartmentDetailItemDTO>();
        for (TrainScheduleTurnCompartmentUpdate update : trainScheduleTurn
            .getTrainScheduleTurnCompartmentUpdates()) {
          totalCompartments = totalCompartments + update.getTotalCompartments();
          overallCrowdDensity = overallCrowdDensity + update.getOverallDensity().getCode();
          noOfFeedBacks++;
          if (map.get(update.getCompartmentNumber()) == null) {
            CompartmentDetailItemDTO compartmentDetailItemDTO = new CompartmentDetailItemDTO();
            compartmentDetailItemDTO.setComaprtmentNumber(update.getCompartmentNumber());
            compartmentDetailItemDTO.setCrowdDensity(update.getCompartmentDensity().getCode());
            compartmentDetailItemDTO.setNoOfFeedBacks(1);
            map.put(update.getCompartmentNumber(), compartmentDetailItemDTO);
          } else {
            CompartmentDetailItemDTO compartmentDetailItemDTO =
                map.get(update.getCompartmentNumber());
            compartmentDetailItemDTO.setCrowdDensity(compartmentDetailItemDTO.getCrowdDensity()
                + update.getCompartmentDensity().getCode());
            compartmentDetailItemDTO
                .setNoOfFeedBacks(compartmentDetailItemDTO.getNoOfFeedBacks() + 1);
            map.put(update.getCompartmentNumber(), compartmentDetailItemDTO);
          }
        }
        System.out.println("map :" + map);
        List<CompartmentDetailItemDTO> detailItems = new ArrayList<CompartmentDetailItemDTO>();
        for (Entry<Integer, CompartmentDetailItemDTO> item : map.entrySet()) {
          CompartmentDetailItemDTO compartmentDetailItemDTO = item.getValue();
          compartmentDetailItemDTO.setCrowdDensity(compartmentDetailItemDTO.getCrowdDensity()
              / compartmentDetailItemDTO.getNoOfFeedBacks());
          detailItems.add(compartmentDetailItemDTO);
        }
        compartmentDetailResponseDTO.setDetailItems(detailItems);
        compartmentDetailResponseDTO.setNoOfFeedBacks(noOfFeedBacks);
        compartmentDetailResponseDTO.setOverallCrowdDensity(overallCrowdDensity / noOfFeedBacks);
        compartmentDetailResponseDTO.setTotalCompartments(totalCompartments / noOfFeedBacks);
        System.out.println("compartmentDetailResponseDTO :" + compartmentDetailResponseDTO);
        return compartmentDetailResponseDTO;
      }
    }
    return new CompartmentDetailResponseDTO(ApplicationConstants.NO_RESULTS);
  }

}
