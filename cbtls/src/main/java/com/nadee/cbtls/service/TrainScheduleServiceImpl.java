package com.nadee.cbtls.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.constant.GeneralEnumConstants.TrainFrequency;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.TrainScheduleDAO;
import com.nadee.cbtls.dto.TrainScheduleCommentDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserMobileDevice;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleComment;

@Service("trainScheduleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainScheduleServiceImpl implements TrainScheduleService {

  @Autowired
  private TrainScheduleDAO trainScheduleDAO;

  @Autowired
  private SystemUserService systemUserService;

  @Autowired
  private CommonDAO commonDAO;

  @Override
  public long countActiveTrainSchedules() throws Exception {
    return trainScheduleDAO.countActiveTrainSchedules();
  }

  @Override
  public List<TrainSchedule> listAllTrainSchedules(YesNoStatus yesNoStatus) throws Exception {
    return trainScheduleDAO.listAllTrainSchedules(yesNoStatus);
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
  public String saveTrainSchedule(TrainSchedule trainSchedule) throws Exception {
    return commonDAO.saveOrUpdateEntity(trainSchedule);
  }

  @Override
  public String deleteTrainSchedule(long trainScheduleId) throws Exception {
    TrainSchedule trainSchedule = new TrainSchedule();
    trainSchedule.setTrainScheduleId(trainScheduleId);
    return commonDAO.deleteEntity(trainSchedule);
  }

  @Override
  public TrainSchedule fetchTrainSchedule(String trainNumber, TrainFrequency trainFrequency,
      String startStationName, String endStationName, String trainType) throws Exception {
    return trainScheduleDAO.fetchTrainSchedule(trainNumber, trainFrequency, startStationName,
        endStationName, trainType);
  }


  @Override
  public Map<String, Object> saverainScheduleComment(TrainScheduleCommentDTO dto) throws Exception {
    Map<String, Object> resultMap = new HashMap<String, Object>();

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

    dto.setUpdatedUser(systemUser.getUserId());
    dto.setUpdatedUserName(systemUser.getUserName());

    TrainScheduleComment comment = new TrainScheduleComment(dto);

    String result = commonDAO.saveOrUpdateEntity(comment);
    resultMap.put(ApplicationConstants.RESULT, result);


    return resultMap;
  }

  @Override
  public List<TrainScheduleComment> listAllTrainScheduleComments(long trainScheduleId)
      throws Exception {
    return trainScheduleDAO.listAllTrainScheduleComments(trainScheduleId);
  }

}
