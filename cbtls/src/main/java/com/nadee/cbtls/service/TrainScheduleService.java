package com.nadee.cbtls.service;

import java.util.List;
import java.util.Map;

import com.nadee.cbtls.constant.GeneralEnumConstants.TrainFrequency;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.TrainScheduleCommentDTO;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleComment;

public interface TrainScheduleService {

  public long countActiveTrainSchedules() throws Exception;

  public List<TrainSchedule> listAllTrainSchedules(YesNoStatus yesNoStatus) throws Exception;

  public String saveTrainSchedule(TrainSchedule trainSchedule) throws Exception;

  public String deleteTrainSchedule(long trainScheduleId) throws Exception;

  public TrainSchedule fetchTrainSchedule(String trainNumber, TrainFrequency trainFrequency,
      String startStationName, String endStationName, String trainType) throws Exception;

  public Map<String, Object> saverainScheduleComment(
      TrainScheduleCommentDTO trainScheduleCommentDTO) throws Exception;

  public List<TrainScheduleComment> listAllTrainScheduleComments(long trainScheduleId)
      throws Exception;


}
