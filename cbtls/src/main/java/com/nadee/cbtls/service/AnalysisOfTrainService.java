package com.nadee.cbtls.service;

import com.nadee.cbtls.dto.AnalysisOfTrainResponseDTO;
import com.nadee.cbtls.dto.AnalysisOfTrainrequestDTO;

public interface AnalysisOfTrainService {

  AnalysisOfTrainResponseDTO viewAnalysisOfTrain(
      AnalysisOfTrainrequestDTO analysisOfTrainrequestDTO) throws Exception;

}
