package com.nadee.cbtls.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.nadee.cbtls.dto.FavouriteScheduleDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.service.FavouriteScheduleService;
import com.nadee.cbtls.service.SystemUserService;
import com.nadee.cbtls.util.SessionUtil;

@Controller
public class FavouriteScheduleController {

  @Autowired
  private SystemUserService systemUserService;

  @Autowired
  private FavouriteScheduleService favouriteScheduleService;

  @RequestMapping(value = "/getFavourites", method = RequestMethod.POST)
  public ModelAndView getFavourites(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    FavouriteScheduleDTO favouriteScheduleDTO = new FavouriteScheduleDTO();
    List<TrainStationScheduleDTO> list = new ArrayList<TrainStationScheduleDTO>();
    try {
      System.out.println("favouriteScheduleDTO :" + favouriteScheduleDTO);
      System.out.println("favouriteScheduleDTO :" + favouriteScheduleDTO);
      SystemUser systemUser = SessionUtil.getFromSession(ApplicationConstants.SYSTEM_USER);
      boolean isUserNull = false;
      if (StringUtils.isEmpty(favouriteScheduleDTO.getSystemUserMobileDevice())) {
        if (!(systemUser == null)) {
          favouriteScheduleDTO.setUpdatedUser(systemUser.getUserId());
        } else {
          long systemUserId = SessionUtil.getUserIdFromCookie(request);
          if (systemUserId == 0) {
            isUserNull = true;
          } else {
            SystemUser user = systemUserService.getSystemUserById(systemUserId);
            SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER, user);
            favouriteScheduleDTO.setUpdatedUser(systemUserId);
          }
        }
      }
      System.out.println("favouriteScheduleDTO :" + favouriteScheduleDTO);
      list = favouriteScheduleService.listFavourites(favouriteScheduleDTO);
      System.out.println("list :" + list);
      modelMap.put("list", list);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return new ModelAndView("favouriteList", modelMap);
  }

  @RequestMapping(value = "/addToFavourite", method = RequestMethod.POST)
  public @ResponseBody Map<String, Object> addToFavourite(HttpServletResponse response,
      HttpServletRequest request, @RequestBody FavouriteScheduleDTO favouriteScheduleDTO) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      System.out.println("favouriteScheduleDTO :" + favouriteScheduleDTO);
      SystemUser systemUser = SessionUtil.getFromSession(ApplicationConstants.SYSTEM_USER);
      boolean isUserNull = false;
      if (StringUtils.isEmpty(favouriteScheduleDTO.getSystemUserMobileDevice())) {
        if (!(systemUser == null)) {
          favouriteScheduleDTO.setUpdatedUser(systemUser.getUserId());
        } else {
          long systemUserId = SessionUtil.getUserIdFromCookie(request);
          if (systemUserId == 0) {
            isUserNull = true;
          } else {
            SystemUser user = systemUserService.getSystemUserById(systemUserId);
            SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER, user);
            favouriteScheduleDTO.setUpdatedUser(systemUserId);
          }
        }
      }
      System.out.println("favouriteScheduleDTO :" + favouriteScheduleDTO);
      map = favouriteScheduleService.addToFavourites(favouriteScheduleDTO);
      if (isUserNull) {
        SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER,
            map.get(ApplicationConstants.SYSTEM_USER));
        SessionUtil.addUserCookie(response, (SystemUser) map.get(ApplicationConstants.SYSTEM_USER));
      }
    } catch (Exception e) {
      map.put(ApplicationConstants.RESULT, ApplicationConstants.ERROR);
      e.printStackTrace();
    }
    return map;
  }


  @RequestMapping(value = "/listFavourites", method = RequestMethod.POST)
  public @ResponseBody List<TrainStationScheduleDTO> listFavourites(HttpServletResponse response,
      HttpServletRequest request, @RequestBody FavouriteScheduleDTO favouriteScheduleDTO) {
    List<TrainStationScheduleDTO> list = new ArrayList<TrainStationScheduleDTO>();
    try {
      System.out.println("favouriteScheduleDTO :" + favouriteScheduleDTO);
      System.out.println("favouriteScheduleDTO :" + favouriteScheduleDTO);
      SystemUser systemUser = SessionUtil.getFromSession(ApplicationConstants.SYSTEM_USER);
      boolean isUserNull = false;
      if (StringUtils.isEmpty(favouriteScheduleDTO.getSystemUserMobileDevice())) {
        if (!(systemUser == null)) {
          favouriteScheduleDTO.setUpdatedUser(systemUser.getUserId());
        } else {
          long systemUserId = SessionUtil.getUserIdFromCookie(request);
          if (systemUserId == 0) {
            isUserNull = true;
          } else {
            SystemUser user = systemUserService.getSystemUserById(systemUserId);
            SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER, user);
            favouriteScheduleDTO.setUpdatedUser(systemUserId);
          }
        }
      }
      list = favouriteScheduleService.listFavourites(favouriteScheduleDTO);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

}
