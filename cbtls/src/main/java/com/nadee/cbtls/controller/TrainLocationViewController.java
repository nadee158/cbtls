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
import com.nadee.cbtls.dto.ViewTrainlocationRequestDTO;
import com.nadee.cbtls.dto.ViewTrainlocationResponseDTO;
import com.nadee.cbtls.service.TrainLocationUpdateService;
import com.nadee.cbtls.util.SessionUtil;

@Controller
public class TrainLocationViewController {
  
  @Autowired
  private TrainLocationUpdateService trainLocationUpdateService;
  
  
   @RequestMapping(value = "/getViewTrainLocation", method = RequestMethod.POST)
   public ModelAndView getViewTrainLocation(HttpServletRequest request) {
     ModelMap modelMap = new ModelMap();
     long tssid=SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL_ID");
     modelMap.put("tssid", tssid);
     modelMap.put("trainStationScheduleDTO", SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL"));
     return new ModelAndView("viewTrainLocation", modelMap);
   }
   
   @RequestMapping(value = "/viewTrainLocation", method = RequestMethod.POST)
   public @ResponseBody ViewTrainlocationResponseDTO viewTrainLocation(HttpServletResponse response, HttpServletRequest request, 
           @RequestBody ViewTrainlocationRequestDTO requestDTO) {
       ViewTrainlocationResponseDTO dto = new ViewTrainlocationResponseDTO();
       try {
           System.out.println("requestDTO :" + requestDTO);
           dto= trainLocationUpdateService.listTrainLocation(requestDTO);
       } catch (Exception e) {
           dto.setMessage("System Error!");
           dto.setStatus(ApplicationConstants.ERROR);
           e.printStackTrace();
       }
       return dto;
   }

 
  

}
