package com.nadee.cbtls.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.service.TrainScheduleService;

@Controller
@RequestMapping(value = "/admin")
public class AdminViewFeedBacksController {

  @Autowired
  private TrainScheduleService trainScheduleService;

  @RequestMapping(value = "/manageUserFeedBack", method = RequestMethod.GET)
  public ModelAndView manageUserFeedBack(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    try {
      modelMap.put("scheduleList", trainScheduleService.listAllTrainSchedules(YesNoStatus.YES));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return new ModelAndView("manageUserFeedBack", modelMap);
  }

  @RequestMapping(value = "/viewFeedBacks", method = RequestMethod.GET)
  public ModelAndView viewFeedBacks(HttpServletRequest request,
      @RequestParam("tsid") long trainScheduleId) {
    ModelMap modelMap = new ModelMap();
    try {
      modelMap.put("feedBacks", trainScheduleService.listAllTrainScheduleComments(trainScheduleId));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return new ModelAndView("viewFeedBacks", modelMap);
  }

}
