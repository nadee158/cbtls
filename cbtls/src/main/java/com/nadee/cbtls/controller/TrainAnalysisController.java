package com.nadee.cbtls.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.dto.AnalysisOfTrainResponseDTO;
import com.nadee.cbtls.dto.AnalysisOfTrainrequestDTO;
import com.nadee.cbtls.service.AnalysisOfTrainService;
import com.nadee.cbtls.util.SessionUtil;

@Controller
public class TrainAnalysisController {

  @Autowired
  private AnalysisOfTrainService analysisOfTrainService;


  @RequestMapping(value = "/getViewAnalysisOfTrain", method = RequestMethod.POST)
  public ModelAndView getViewAnalysisOfTrain(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    long tssid = SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL_ID");
    modelMap.put("tssid", tssid);
    modelMap.put("trainStationScheduleDTO", SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL"));
    return new ModelAndView("viewAnalysisOfTrain", modelMap);
  }


  @RequestMapping(value = "/viewAnalysisOfTrain", method = RequestMethod.POST)
  public @ResponseBody AnalysisOfTrainResponseDTO viewCompartmentDetails(
      @RequestBody AnalysisOfTrainrequestDTO analysisOfTrainrequestDTO) {
    try {
      System.out.println("analysisOfTrainrequestDTO :" + analysisOfTrainrequestDTO);
      return analysisOfTrainService.viewAnalysisOfTrain(analysisOfTrainrequestDTO);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new AnalysisOfTrainResponseDTO(ApplicationConstants.NO_RESULTS);
  }


}
