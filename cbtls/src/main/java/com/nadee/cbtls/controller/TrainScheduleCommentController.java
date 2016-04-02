package com.nadee.cbtls.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.dto.TrainScheduleCommentDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.service.SystemUserService;
import com.nadee.cbtls.service.TrainScheduleService;
import com.nadee.cbtls.util.SessionUtil;

@Controller
public class TrainScheduleCommentController {

  @Autowired
  private SystemUserService systemUserService;

  @Autowired
  private TrainScheduleService trainScheduleService;

  @RequestMapping(value = "/saveComment", method = RequestMethod.POST)
  public @ResponseBody Map<String, Object> updateComment(HttpServletResponse response,
      HttpServletRequest request, @RequestBody TrainScheduleCommentDTO trainScheduleCommentDTO) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      System.out.println("trainScheduleCommentDTO :" + trainScheduleCommentDTO);
      SystemUser systemUser = SessionUtil.getFromSession(ApplicationConstants.SYSTEM_USER);
      boolean isUserNull = false;
      if (StringUtils.isEmpty(trainScheduleCommentDTO.getSystemUserMobileDevice())) {
        if (!(systemUser == null)) {
          trainScheduleCommentDTO.setUpdatedUser(systemUser.getUserId());
          trainScheduleCommentDTO.setUpdatedUserName(systemUser.getUserName());
        } else {
          long systemUserId = SessionUtil.getUserIdFromCookie(request);
          if (systemUserId == 0) {
            isUserNull = true;
          } else {
            SystemUser user = systemUserService.getSystemUserById(systemUserId);
            SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER, user);
            trainScheduleCommentDTO.setUpdatedUser(systemUserId);
            trainScheduleCommentDTO.setUpdatedUserName(user.getUserName());
          }
        }
      }
      map = trainScheduleService.saverainScheduleComment(trainScheduleCommentDTO);
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



}
