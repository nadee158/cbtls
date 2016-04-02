package com.nadee.cbtls.service;

import java.util.List;

import com.nadee.cbtls.dto.AdminSearchDTO;
import com.nadee.cbtls.dto.AdminTrainAnalyticsResultDTO;
import com.nadee.cbtls.dto.AnalysisOfTrainResponseDTO;
import com.nadee.cbtls.dto.AnalysisOfTrainrequestDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;

public interface AnalysisOfTrainService {

  AnalysisOfTrainResponseDTO viewAnalysisOfTrain(
      AnalysisOfTrainrequestDTO analysisOfTrainrequestDTO) throws Exception;

  AdminTrainAnalyticsResultDTO searchTrainSchedulesAnalytics(AdminSearchDTO adminSearchDTO)
      throws Exception;

  List<TrainStationScheduleDTO> searchTrainSchedulesList(AdminSearchDTO adminSearchDTO)
      throws Exception;

}
