package com.nadee.cbtls.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.service.SystemUserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminManageUsersController {

  @Autowired
  private SystemUserService systemUserService;

  @RequestMapping(value = "/manageUsers", method = RequestMethod.GET)
  public ModelAndView getLoginPage(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    try {
      modelMap.put("userList", systemUserService.listSystemUsers());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return new ModelAndView("manageUsers", modelMap);
  }

  @RequestMapping(value = "/viewUserFeedBcks", method = RequestMethod.GET)
  public ModelAndView viewUserFeedBcks(HttpServletRequest request,
      @RequestParam("userId") long userId) {
    ModelMap modelMap = new ModelMap();
    try {
      modelMap.put("userFeedBackList", systemUserService.listSystemUserFeedBacks(userId));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return new ModelAndView("viewUserFeedBcks", modelMap);
  }

}
