package com.nadee.cbtls.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public ModelAndView getLoginPage(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    modelMap.put("message", "Hi");
    return new ModelAndView("home", modelMap);
  }



  // @RequestMapping(value = "/viewRecommendations", method = RequestMethod.POST)
  // public ModelAndView viewRecommendations(HttpServletRequest request) {
  // ModelMap modelMap = new ModelMap();
  // TrainSearchDTO trainSearchDTO = (TrainSearchDTO)
  // request.getSession().getAttribute("trainSearchDTO");
  // System.out.println(trainSearchDTO.getStartDate());
  // modelMap.put("trainSearchDTO", trainSearchDTO);
  // return new ModelAndView("viewRecommendations", modelMap);
  // }
  //
  //

  
  //
  //
  // @RequestMapping(value = "/viewAnalysisOfTrain", method = RequestMethod.POST)
  // public ModelAndView viewAnalysisOfTrain(HttpServletRequest request) {
  // ModelMap modelMap = new ModelMap();
  // TrainSearchDTO trainSearchDTO = (TrainSearchDTO)
  // request.getSession().getAttribute("trainSearchDTO");
  // System.out.println(trainSearchDTO.getStartDate());
  // modelMap.put("trainSearchDTO", trainSearchDTO);
  // return new ModelAndView("viewAnalysisOfTrain", modelMap);
  // }
  //
 
  
  //
  // @RequestMapping(value = "/viewTrainLocation", method = RequestMethod.POST)
  // public ModelAndView viewTrainLocation(HttpServletRequest request) {
  // ModelMap modelMap = new ModelMap();
  // TrainSearchDTO trainSearchDTO = (TrainSearchDTO)
  // request.getSession().getAttribute("trainSearchDTO");
  // System.out.println(trainSearchDTO.getStartDate());
  // modelMap.put("trainSearchDTO", trainSearchDTO);
  // return new ModelAndView("viewTrainLocation", modelMap);
  // }
  //
 



}
