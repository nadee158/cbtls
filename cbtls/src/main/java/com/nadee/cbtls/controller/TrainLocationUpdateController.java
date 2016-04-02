package com.nadee.cbtls.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.dto.ActiveTrainLocationUpdateDTO;
import com.nadee.cbtls.dto.PassiveTrainLocationUpdateDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.service.SystemUserService;
import com.nadee.cbtls.service.TrainLocationUpdateService;
import com.nadee.cbtls.util.SessionUtil;

@Controller
public class TrainLocationUpdateController {

  @Autowired
  private TrainLocationUpdateService trainLocationUpdateService;

  @Autowired
  private SystemUserService systemUserService;

  @RequestMapping(value = "/getActiveUpdateLocation", method = RequestMethod.POST)
  public ModelAndView getActiveUpdateLocation(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    long tssid = SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL_ID");
    modelMap.put("tssid", tssid);
    modelMap.put("trainStationScheduleDTO", SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL"));
    return new ModelAndView("activeUpdateLocation", modelMap);
  }

  @RequestMapping(value = "/activeUpdateTrainLocation", method = RequestMethod.POST)
  public @ResponseBody Map<String, Object> activeUpdateTrainLocation(HttpServletResponse response,
      HttpServletRequest request,
      @RequestBody ActiveTrainLocationUpdateDTO activeTrainLocationUpdateDTO) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      System.out.println("activeTrainLocationUpdateDTO :" + activeTrainLocationUpdateDTO);
      SystemUser systemUser = SessionUtil.getFromSession(ApplicationConstants.SYSTEM_USER);
      boolean isUserNull = false;
      if (StringUtils.isEmpty(activeTrainLocationUpdateDTO.getSystemUserMobileDevice())) {
        if (!(systemUser == null)) {
          activeTrainLocationUpdateDTO.setUpdatedUser(systemUser.getUserId());
        } else {
          long systemUserId = SessionUtil.getUserIdFromCookie(request);
          if (systemUserId == 0) {
            isUserNull = true;
          } else {
            SystemUser user = systemUserService.getSystemUserById(systemUserId);
            SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER, user);
            activeTrainLocationUpdateDTO.setUpdatedUser(systemUserId);
          }
        }
      }
      System.out.println("isUserNull :" + isUserNull);
      map = trainLocationUpdateService.activeUpdateTrainLocation(activeTrainLocationUpdateDTO);
      if (isUserNull) {
        SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER,
            map.get(ApplicationConstants.SYSTEM_USER));
        SessionUtil.addUserCookie(response, (SystemUser) map.get(ApplicationConstants.SYSTEM_USER));
      }
      map.remove(ApplicationConstants.SYSTEM_USER);
      return map;
    } catch (Exception e) {
      e.printStackTrace();
    }
    map.put(ApplicationConstants.RESULT, ApplicationConstants.ERROR);
    return map;
  }



  @RequestMapping(value = "/getPassiveUpdateLocation", method = RequestMethod.POST)
  public ModelAndView getPassiveUpdateLocation(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    long tssid = SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL_ID");
    modelMap.put("tssid", tssid);
    modelMap.put("trainStationScheduleDTO", SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL"));
    return new ModelAndView("passiveUpdateLocation", modelMap);
  }



  @RequestMapping(value = "/passiveUpdateTrainLocation", method = RequestMethod.POST)
  public @ResponseBody Map<String, Object> passiveUpdateTrainLocation(HttpServletResponse response,
      HttpServletRequest request,
      @RequestBody PassiveTrainLocationUpdateDTO passiveTrainLocationUpdateDTO) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      System.out.println("passiveTrainLocationUpdateDTO :" + passiveTrainLocationUpdateDTO);
      SystemUser systemUser = SessionUtil.getFromSession(ApplicationConstants.SYSTEM_USER);
      boolean isUserNull = false;
      if (StringUtils.isEmpty(passiveTrainLocationUpdateDTO.getSystemUserMobileDevice())) {
        if (!(systemUser == null)) {
          passiveTrainLocationUpdateDTO.setUpdatedUser(systemUser.getUserId());
        } else {
          long systemUserId = SessionUtil.getUserIdFromCookie(request);
          if (systemUserId == 0) {
            isUserNull = true;
          } else {
            SystemUser user = systemUserService.getSystemUserById(systemUserId);
            SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER, user);
            passiveTrainLocationUpdateDTO.setUpdatedUser(systemUserId);
          }
        }
      }
      map = trainLocationUpdateService.passiveUpdateTrainLocation(passiveTrainLocationUpdateDTO);
      if (isUserNull) {
        SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER,
            map.get(ApplicationConstants.SYSTEM_USER));
        SessionUtil.addUserCookie(response, (SystemUser) map.get(ApplicationConstants.SYSTEM_USER));
      }
      map.remove(ApplicationConstants.SYSTEM_USER);
      System.out.println("CAME HERE :" + map);
      return map;
    } catch (Exception e) {
      e.printStackTrace();
    }
    map.put(ApplicationConstants.RESULT, ApplicationConstants.ERROR);
    System.out.println("CAME HERE fsfsdfsd :" + map);
    return map;
  }

}
