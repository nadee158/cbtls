package com.nadee.cbtls.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.dto.UserLoginReponseDTO;
import com.nadee.cbtls.dto.UserLoginRequestDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.service.SystemUserService;
import com.nadee.cbtls.util.SessionUtil;

@Controller
public class LoginController {

  @Autowired
  private SystemUserService systemUserService;

  @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
  public ModelAndView getLoginPage(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    System.out.println("CAME IN TO CONTROLER");
    return new ModelAndView("login", modelMap);
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView loginUser(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    System.out.println("CAME IN TO CONTROLER");
    return new ModelAndView("login", modelMap);
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public @ResponseBody UserLoginReponseDTO loginUser(HttpServletResponse response,
      HttpServletRequest request, @RequestBody UserLoginRequestDTO userLoginRequestDTO) {
    UserLoginReponseDTO reponseDTO = new UserLoginReponseDTO();
    reponseDTO.setStatus(ApplicationConstants.ERROR);
    try {
      System.out.println("userLoginRequestDTO :" + userLoginRequestDTO);
      reponseDTO = systemUserService.loginUser(userLoginRequestDTO);
      SystemUser user = systemUserService.getSystemUserByUserName(reponseDTO.getUserId());
      SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER, user);
      SessionUtil.addUserCookie(response, user);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return reponseDTO;
  }

}
