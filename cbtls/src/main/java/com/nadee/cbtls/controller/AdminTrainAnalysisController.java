package com.nadee.cbtls.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dto.AdminSearchDTO;
import com.nadee.cbtls.dto.AdminTrainAnalyticsResultDTO;
import com.nadee.cbtls.dto.TrainLineDTO;
import com.nadee.cbtls.dto.TrainStationDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.service.AnalysisOfTrainService;
import com.nadee.cbtls.service.TrainLineService;
import com.nadee.cbtls.service.TrainStationService;

@Controller
@RequestMapping(value = "/admin")
public class AdminTrainAnalysisController {

  @Autowired
  private TrainLineService trainLineService;

  @Autowired
  private TrainStationService trainStationService;

  @Autowired
  private AnalysisOfTrainService analysisOfTrainService;

  @RequestMapping(value = "/viewAnalysis", method = RequestMethod.GET)
  public ModelAndView getLoginPage(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    try {
      List<TrainLineDTO> trainLines = trainLineService.listAllTrainLines(YesNoStatus.YES, false);
      modelMap.put("trainLines", trainLines);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return new ModelAndView("viewAnalysis", modelMap);
  }

  @RequestMapping(value = "/listTrainLinesAdmin", method = RequestMethod.GET)
  public @ResponseBody List<TrainLineDTO> listAllTrainLines() {
    List<TrainLineDTO> trainLines = new ArrayList<TrainLineDTO>();
    try {
      trainLines = trainLineService.listAllTrainLines(YesNoStatus.YES, false);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return trainLines;
  }

  @RequestMapping(value = "/listTrainStationsByTrainLineAdmin", method = RequestMethod.GET)
  public @ResponseBody List<TrainStationDTO> listAllTrainStationsByTrainLine(
      @RequestParam("trainLineId") long trainLineId) {
    List<TrainStationDTO> trainStations = new ArrayList<TrainStationDTO>();
    try {
      trainStations =
          trainStationService.listAllTrainStationsByTrainLine(YesNoStatus.YES, trainLineId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return trainStations;
  }

  @RequestMapping(value = "/searchTrainSchedulesList", method = RequestMethod.POST)
  public @ResponseBody List<TrainStationScheduleDTO> searchTrainSchedulesList(
      @RequestBody AdminSearchDTO adminSearchDTO) {
    List<TrainStationScheduleDTO> list = new ArrayList<TrainStationScheduleDTO>();
    try {
      System.out.println("trainScheduleSearchDTO :" + adminSearchDTO);
      list = analysisOfTrainService.searchTrainSchedulesList(adminSearchDTO);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  @RequestMapping(value = "/searchTrainSchedulesAnalytics", method = RequestMethod.POST)
  public @ResponseBody AdminTrainAnalyticsResultDTO searchTrainSchedulesAnalytics(
      @RequestBody AdminSearchDTO adminSearchDTO) {
    AdminTrainAnalyticsResultDTO dto = new AdminTrainAnalyticsResultDTO();
    try {
      System.out.println("trainScheduleSearchDTO :" + adminSearchDTO);
      dto = analysisOfTrainService.searchTrainSchedulesAnalytics(adminSearchDTO);
    } catch (Exception e) {
      dto.setStatus(ApplicationConstants.ERROR);
      e.printStackTrace();
    }
    return dto;
  }

}
